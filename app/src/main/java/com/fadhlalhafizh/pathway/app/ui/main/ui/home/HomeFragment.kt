package com.fadhlalhafizh.pathway.app.ui.main.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fadhlalhafizh.pathway.R
import com.fadhlalhafizh.pathway.app.adapter.HomeProfession
import com.fadhlalhafizh.pathway.app.adapter.HomeUniversity
import com.fadhlalhafizh.pathway.app.viewmodel.HomeViewModel
import com.fadhlalhafizh.pathway.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HomeUniversity

    private lateinit var recyclerView2: RecyclerView
    private lateinit var adapter2: HomeProfession

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textUniversity
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        recyclerView = root.findViewById(R.id.rv_topUniversity)
        adapter = HomeUniversity()

        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter

        recyclerView2 = root.findViewById(R.id.rv_newestJobs)
        adapter2 = HomeProfession()

        recyclerView2.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView2.adapter = adapter2

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}