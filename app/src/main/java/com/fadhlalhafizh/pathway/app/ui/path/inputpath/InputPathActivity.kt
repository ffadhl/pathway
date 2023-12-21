package com.fadhlalhafizh.pathway.app.ui.path.inputpath

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.fadhlalhafizh.pathway.app.ui.path.outputpath.OutputPathActivity
import com.fadhlalhafizh.pathway.app.ui.path.outputpath.OutputPathActivityViewModel
import com.fadhlalhafizh.pathway.app.viewmodel.ViewModelFactory
import com.fadhlalhafizh.pathway.databinding.ActivityInputPathBinding

class InputPathActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputPathBinding
    private val viewModelInput by viewModels<InputPathActivityViewModel> {
        ViewModelFactory.getInstance(this)
    }
    private var viewModelOutput: OutputPathActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputPathBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setSoftInputMode(android.view.WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        setupSubmitButton()

        // Observe the resultLiveData
        viewModelInput.resultLiveData.observe(this) { result ->
            result?.let {
                viewModelOutput?.setResult(result)
                navigateToOutputPathActivity()
            }
        }

        // Initialize viewModelOutput
        viewModelOutput = ViewModelProvider(this).get(OutputPathActivityViewModel::class.java)
    }

    private fun navigateToOutputPathActivity() {
        val intent = Intent(this, OutputPathActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun setupSubmitButton() {
        binding.btnSubmit.setOnClickListener {
            val inputText = binding.inputPathEditText.text?.toString()
            if (inputText.isNullOrEmpty()) {
                binding.inputPathEditTextLayout.error = "Please enter a valid input."
            } else {
                viewModelInput.processInput(inputText)
            }
        }
    }

}