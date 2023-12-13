package com.fadhlalhafizh.pathway.app.ui.main.ui.profession

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fadhlalhafizh.pathway.app.viewmodel.ProfessionViewModel
import com.fadhlalhafizh.pathway.databinding.FragmentProfessionBinding

class ProfessionFragment : Fragment() {

private var _binding: FragmentProfessionBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
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

    val textView: TextView = binding.textProfession
    professionViewModel.text.observe(viewLifecycleOwner) {
      textView.text = it
    }
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}