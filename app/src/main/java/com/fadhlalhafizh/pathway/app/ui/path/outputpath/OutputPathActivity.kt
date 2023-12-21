package com.fadhlalhafizh.pathway.app.ui.path.outputpath

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.fadhlalhafizh.pathway.app.ui.path.inputpath.InputPathActivity
import com.fadhlalhafizh.pathway.data.remote.response.ResultMajorResponse
import com.fadhlalhafizh.pathway.databinding.ActivityOutputPathBinding

class OutputPathActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOutputPathBinding
    private lateinit var viewModel: OutputPathActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutputPathBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[OutputPathActivityViewModel::class.java]

        viewModel.resultLiveData.observe(this) { result ->
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
        binding.tvOutputResult.text = result.prediksiJurusan
    }
}
