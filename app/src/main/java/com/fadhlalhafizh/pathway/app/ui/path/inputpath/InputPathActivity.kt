package com.fadhlalhafizh.pathway.app.ui.path.inputpath

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fadhlalhafizh.pathway.app.ui.path.outputpath.OutputPathActivity
import com.fadhlalhafizh.pathway.databinding.ActivityInputPathBinding

class InputPathActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputPathBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputPathBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setSoftInputMode(android.view.WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        setupSubmitButton()
    }

    private fun navigateToOutputPathActivity() {
        val intent = Intent(this, OutputPathActivity::class.java)
        intent.putExtra("input", binding.inputPathEditText.text?.toString())
        startActivity(intent)
        finish()
    }

    private fun setupSubmitButton() {
        binding.btnSubmit.setOnClickListener {
            val inputText = binding.inputPathEditText.text?.toString()
            if (inputText.isNullOrEmpty()) {
                binding.inputPathEditTextLayout.error = "Please enter a valid input."
            } else {
                navigateToOutputPathActivity()
            }
        }
    }
}