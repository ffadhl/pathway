package com.fadhlalhafizh.pathway.app.ui.main.ui.home

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
import com.fadhlalhafizh.pathway.databinding.FragmentHomeBinding
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HomeUniversityAdapter
    private lateinit var recyclerView2: RecyclerView
    private lateinit var adapter2: HomeProfessionAdapter
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

        recyclerView = root.findViewById(R.id.rv_topUniversity)
        adapter = HomeUniversityAdapter()

        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter

        recyclerView2 = root.findViewById(R.id.rv_newestJobs)
        adapter2 = HomeProfessionAdapter()

        recyclerView2.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView2.adapter = adapter2

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

    private fun logout() {
        CoroutineScope(Dispatchers.IO).launch { viewModelHome.logout() }
        val intent = Intent(requireContext(), WelcomeActivity::class.java)
        startActivity(intent)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}