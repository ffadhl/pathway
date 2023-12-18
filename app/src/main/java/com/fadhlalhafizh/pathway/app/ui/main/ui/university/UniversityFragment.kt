package com.fadhlalhafizh.pathway.app.ui.main.ui.university

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
import com.fadhlalhafizh.pathway.databinding.FragmentUniversityBinding

class UniversityFragment : Fragment() {

    private var _binding: FragmentUniversityBinding? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UnivUniversityAdapter
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

        recyclerView = root.findViewById(R.id.rv_fragmentUniversity)
        adapter = UnivUniversityAdapter()

        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}