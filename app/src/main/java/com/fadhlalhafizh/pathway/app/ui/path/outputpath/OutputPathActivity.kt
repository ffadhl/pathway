package com.fadhlalhafizh.pathway.app.ui.path.outputpath

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
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

        setupSaveButton()
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

        // Menampilkan 4 elemen pertama dari rekomendasiKarir
        val firstFourCareers = result.rekomendasiKarir.subList(0, minOf(result.rekomendasiKarir.size, 4))
        val formattedCareers = firstFourCareers.joinToString("\n")
        binding.tvResultProfession.text = formattedCareers

        binding.tvOutputRelatedMajor.text = result.recommendedAlternatif[0]
        binding.tvOutputRelatedMajor2.text = result.recommendedAlternatif[1]
        binding.tvOutputRelatedMajor3.text = result.recommendedAlternatif[2]

        binding.tvOutputPresentation.text = formatPercentage(result.similarities[0])
        binding.tvOutputPresentation2.text = formatPercentage(result.similarities[1])
        binding.tvOutputPresentation3.text = formatPercentage(result.similarities[2])
    }

    private fun formatPercentage(value: Any): String {
        val percentage = ((value as Double) * 100).toInt()
        return "$percentage%"
    }

    private fun setupSaveButton() {
        binding.btnSubmit.setOnClickListener {
            showSaveAlertDialog()
        }
    }

    private fun showSaveAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Your goals is saved")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .setCancelable(false)
            .show()
    }
}
