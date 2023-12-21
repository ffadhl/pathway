package com.fadhlalhafizh.pathway.app.ui.detailprofession.detailprofessionhome

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fadhlalhafizh.pathway.R
import com.fadhlalhafizh.pathway.app.ui.main.MainActivity
import com.fadhlalhafizh.pathway.data.model.Job
import com.fadhlalhafizh.pathway.databinding.ActivityDetailProfessionHomeBinding

class DetailProfessionHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailProfessionHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProfessionHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataJob = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Job>("key_Job", Job::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Job>("key_Job")
        }

        val jobDetailPosition = findViewById<TextView>(R.id.tv_positionName_detailProf)
        val jobDetailCompany = findViewById<TextView>(R.id.tv_workPlace_detailProf)
        val jobDetailDomicile = findViewById<TextView>(R.id.tv_workDom_detailProf)
        val jobDetailFullOrIntern = findViewById<TextView>(R.id.tv_workDuration)
        val jobDetailDescription = findViewById<TextView>(R.id.tv_workDesc_detailProf)
        val jobDetailPhoto = findViewById<ImageView>(R.id.iv_univ_detailProfession)

        jobDetailPosition.text = dataJob?.position ?: "Unknown Position!"
        jobDetailCompany.text = dataJob?.company ?: "Unknown Company!"
        jobDetailDomicile.text = dataJob?.domicile ?: "Unknown Domicile!"
        jobDetailFullOrIntern.text = dataJob?.fullOrIntern ?: "Unknown Full or Intern!"
        jobDetailDescription.text = dataJob?.description ?: "No Data Description can be found!"
        jobDetailPhoto.setImageResource(dataJob?.photo ?: 0)

        goBack()
    }

    private fun goBack() {
        binding.ivBackArrowDetailProf.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}