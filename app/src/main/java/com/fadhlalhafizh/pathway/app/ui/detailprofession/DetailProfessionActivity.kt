package com.fadhlalhafizh.pathway.app.ui.detailprofession

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fadhlalhafizh.pathway.app.ui.main.MainActivity
import com.fadhlalhafizh.pathway.databinding.ActivityDetailProfessionBinding

class DetailProfessionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailProfessionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProfessionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val positionName = intent.getStringExtra(POSITION)
        val workPlace = intent.getStringExtra(WORKPLACE)
        val workDomicile = intent.getStringExtra(DOMICILE)
        val fullOrIntern = intent.getStringExtra(FULL_OR_INTERN)

        binding.tvPositionNameDetailProf.text = positionName
        binding.tvWorkPlaceDetailProf.text = workPlace
        binding.tvWorkDomDetailProf.text = workDomicile
        binding.tvWorkDuration.text = fullOrIntern

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

    companion object {
        const val POSITION = "position"
        const val WORKPLACE = "workplace"
        const val DOMICILE = "domicile"
        const val FULL_OR_INTERN = "full_or_intern"
        const val DESCRIPTION = "description"
    }
}