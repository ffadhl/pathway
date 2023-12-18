package com.fadhlalhafizh.pathway.app.ui.main.ui.profession

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fadhlalhafizh.pathway.app.adapter.ViewPagerProfessionAdapter
import com.fadhlalhafizh.pathway.databinding.FragmentProfessionBinding
import com.google.android.material.tabs.TabLayoutMediator

class ProfessionFragment : Fragment() {

    private var _binding: FragmentProfessionBinding? = null
    private lateinit var viewPagerAdapter: ViewPagerProfessionAdapter
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val professionViewModel =
            ViewModelProvider(this)[ProfessionViewModel::class.java]

        _binding = FragmentProfessionBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewPagerAdapter =
            ViewPagerProfessionAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)
        with(binding) {
            viewpagerProfession.adapter = viewPagerAdapter

            TabLayoutMediator(tabsProfession, viewpagerProfession) { tab, position ->
                when (position) {
                    0 -> tab.text = "Full Time"
                    1 -> tab.text = "Internship"
                }
            }.attach()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}