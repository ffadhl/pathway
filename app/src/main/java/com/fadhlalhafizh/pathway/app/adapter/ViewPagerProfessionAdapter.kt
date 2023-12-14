package com.fadhlalhafizh.pathway.app.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fadhlalhafizh.pathway.app.ui.main.ui.profession.fulltime.FullTimeFragment
import com.fadhlalhafizh.pathway.app.ui.main.ui.profession.intership.InternshipFragment

class ViewPagerProfessionAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        var fragment = Fragment()
        when (position) {
            0 -> fragment = FullTimeFragment()
            1 -> fragment = InternshipFragment()
        }
        return fragment
    }
}