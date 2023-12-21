package com.fadhlalhafizh.pathway.app.ui.main.ui.university

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fadhlalhafizh.pathway.R
import com.fadhlalhafizh.pathway.app.adapter.university.UnivUniversityAdapter
import com.fadhlalhafizh.pathway.data.model.University
import com.fadhlalhafizh.pathway.databinding.FragmentUniversityBinding

class UniversityFragment : Fragment() {

    private var _binding: FragmentUniversityBinding? = null
    private lateinit var rvUniversity: RecyclerView
    private val listUniversity = ArrayList<University>()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val universityViewModel =
            ViewModelProvider(this)[UniversityViewModel::class.java]

        _binding = FragmentUniversityBinding.inflate(inflater, container, false)
        val root: View = binding.root

        rvUniversity = binding.rvFragmentUniversity
        rvUniversity.setHasFixedSize(true)
        listUniversity.addAll(getListUniversity())
        showRecyclerList()

        return root
    }

    @SuppressLint("Recycle")
    private fun getListUniversity(): ArrayList<University> {
        val dataUniversity = resources.getStringArray(R.array.data_university)
        val dataAddress = resources.getStringArray(R.array.data_address)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataWorldRank = resources.getStringArray(R.array.data_worldRank)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataPhotoBackground = resources.obtainTypedArray(R.array.data_photoBackground)

        val minSize = minOf(
            dataUniversity.size,
            dataAddress.size,
            dataDescription.size,
            dataWorldRank.size,
            dataPhoto.length(),
            dataPhotoBackground.length()
        )

        val listUniversity = ArrayList<University>()

        for (i in 0 until minSize) {
            val univ = University(
                dataUniversity[i],
                dataAddress[i],
                dataDescription[i],
                if (i < dataWorldRank.size) dataWorldRank[i] else "",
                if (i < dataPhoto.length()) dataPhoto.getResourceId(i, -1) else -1,
                if (i < dataPhotoBackground.length()) dataPhotoBackground.getResourceId(
                    i,
                    -1
                ) else -1
            )
            listUniversity.add(univ)
        }

        return listUniversity
    }


    private fun showRecyclerList() {
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvUniversity.layoutManager = layoutManager
        val listUniversityAdapter = UnivUniversityAdapter(listUniversity)
        rvUniversity.adapter = listUniversityAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}