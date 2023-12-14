package com.fadhlalhafizh.pathway.app.ui.main.ui.profession.fulltime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fadhlalhafizh.pathway.R
import com.fadhlalhafizh.pathway.app.adapter.FullTimeAdapter
import com.fadhlalhafizh.pathway.databinding.FragmentFullTimeBinding

class FullTimeFragment : Fragment() {

    private var _binding: FragmentFullTimeBinding? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FullTimeAdapter

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFullTimeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        recyclerView = root.findViewById(R.id.rv_fullTime)
        adapter = FullTimeAdapter()

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