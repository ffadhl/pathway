package com.fadhlalhafizh.pathway.app.ui.main.ui.goal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fadhlalhafizh.pathway.app.adapter.ViewPagerGoalsAdapter
import com.fadhlalhafizh.pathway.app.adapter.ViewPagerProfessionAdapter
import com.fadhlalhafizh.pathway.app.viewmodel.GoalsViewModel
import com.fadhlalhafizh.pathway.databinding.FragmentGoalsBinding
import com.google.android.material.tabs.TabLayoutMediator

class GoalsFragment : Fragment() {
    private var _binding: FragmentGoalsBinding? = null
    private lateinit var viewPagerAdapter : ViewPagerGoalsAdapter
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val goalsViewModel =
            ViewModelProvider(this)[GoalsViewModel::class.java]

        _binding = FragmentGoalsBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textGoals
//        goalsViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        viewPagerAdapter = ViewPagerGoalsAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)
        with(binding){
            viewpagerGoals.adapter = viewPagerAdapter

            TabLayoutMediator(tabsGoals, viewpagerGoals) { tab, position ->
                when (position) {
                    0 -> tab.text = "University"
                    1 -> tab.text = "Profession"
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