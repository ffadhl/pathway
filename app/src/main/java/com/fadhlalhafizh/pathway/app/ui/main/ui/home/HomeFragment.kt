package com.fadhlalhafizh.pathway.app.ui.main.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fadhlalhafizh.pathway.R
import com.fadhlalhafizh.pathway.app.adapter.home.HomeProfessionAdapter
import com.fadhlalhafizh.pathway.app.adapter.home.HomeUniversityAdapter
import com.fadhlalhafizh.pathway.app.ui.path.inputpath.InputPathActivity
import com.fadhlalhafizh.pathway.app.ui.welcome.WelcomeActivity
import com.fadhlalhafizh.pathway.app.viewmodel.ViewModelFactory
import com.fadhlalhafizh.pathway.data.model.Job
import com.fadhlalhafizh.pathway.data.model.University
import com.fadhlalhafizh.pathway.databinding.FragmentHomeBinding
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var rvUniversity: RecyclerView
    private val listUniversity = ArrayList<University>()

    private lateinit var rvJob: RecyclerView
    private val listJob = ArrayList<Job>()
    private val viewModelHome by viewModels<HomeViewModel> {
        ViewModelFactory.getInstance(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        rvUniversity = binding.rvTopUniversity
        rvUniversity.setHasFixedSize(true)
        rvJob = binding.rvNewestJobs
        rvJob.setHasFixedSize(true)

        listUniversity.addAll(getListUniversity())
        showRecyclerList()
        listJob.addAll(getListJob())
        showRecyclerListJob()

        val pathGoalsCardView = root.findViewById<CardView>(R.id.cv_pathGoals)
        pathGoalsCardView.setOnClickListener {
            val intent = Intent(requireContext(), InputPathActivity::class.java)
            startActivity(intent)
        }

        val civHome = root.findViewById<CircleImageView>(R.id.civ_home)
        civHome.setOnClickListener {
            logout()
        }

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
                if (i < dataPhotoBackground.length()) dataPhotoBackground.getResourceId(i, -1) else -1
            )
            listUniversity.add(univ)
        }

        return listUniversity
    }


    private fun showRecyclerList() {
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvUniversity.layoutManager = layoutManager
        val listUniversityAdapter = HomeUniversityAdapter(listUniversity)
        rvUniversity.adapter = listUniversityAdapter
    }

    @SuppressLint("Recycle")
    private fun getListJob(): ArrayList<Job> {
        val dataPosition = resources.getStringArray(R.array.data_position)
        val dataCompany = resources.getStringArray(R.array.data_company)
        val dataDomicile = resources.getStringArray(R.array.data_domicile)
        val dataFullOrIntern = resources.getStringArray(R.array.data_fullOrIntern)
        val dataDescription = resources.getStringArray(R.array.data_descriptionJobs)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photoJobs)

        val minSize = minOf(
            dataPosition.size,
            dataCompany.size,
            dataDomicile.size,
            dataFullOrIntern.size,
            dataDescription.size
        )

        val listJob = ArrayList<Job>()

        for (i in 0 until minSize) {
            val job = Job(
                dataPhoto.getResourceId(i, -1),
                dataPosition[i],
                dataCompany[i],
                dataDomicile[i],
                dataFullOrIntern[i],
                dataDescription[i],
            )
            listJob.add(job)
        }

        // Recycle the TypedArray to avoid memory leaks
        dataPhoto.recycle()

        return listJob
    }


    private fun showRecyclerListJob() {
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvJob.layoutManager = layoutManager
        val listJobAdapter = HomeProfessionAdapter(listJob)
        rvJob.adapter = listJobAdapter
    }


    private fun logout() {
        CoroutineScope(Dispatchers.IO).launch { viewModelHome.logout() }
        val intent = Intent(requireContext(), WelcomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}