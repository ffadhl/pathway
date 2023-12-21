package com.fadhlalhafizh.pathway.app.ui.path.outputpath

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.fadhlalhafizh.pathway.app.ui.path.inputpath.InputPathActivity
import com.fadhlalhafizh.pathway.app.viewmodel.ViewModelFactory
import com.fadhlalhafizh.pathway.data.remote.response.ResultMajorResponse
import com.fadhlalhafizh.pathway.databinding.ActivityOutputPathBinding

class OutputPathActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOutputPathBinding
    private val viewModels by viewModels<OutputPathActivityViewModel> {
        ViewModelFactory.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutputPathBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val inputText = intent.getStringExtra("input")
        viewModels.processInput(inputText.toString())
        viewModels.resultLiveData.observe(this) { result ->
            result?.let {
                displayResult(it)
            }
        }

        goBack()
    }

    private fun goBack() {
        binding.ivBackArrowOutputPath.setOnClickListener {
            val intent = Intent(this, InputPathActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }

    private fun displayResult(result: ResultMajorResponse) {
        Log.d("OutputPathActivity", "Result: $result")
        binding.tvOutputResult.text = result.prediksiJurusan
    }
}
