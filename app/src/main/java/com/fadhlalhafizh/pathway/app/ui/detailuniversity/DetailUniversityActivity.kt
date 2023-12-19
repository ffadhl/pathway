package com.fadhlalhafizh.pathway.app.ui.detailuniversity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fadhlalhafizh.pathway.app.ui.main.MainActivity
import com.fadhlalhafizh.pathway.app.ui.maps.MapsActivity
import com.fadhlalhafizh.pathway.databinding.ActivityDetailUniversityBinding

class DetailUniversityActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUniversityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUniversityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val universityName = intent.getStringExtra(UNIVERSITY)
        val universityAddress = intent.getStringExtra(ADDRESS)
        val worldRank1 = intent.getStringExtra(WORLD_RANK1)
        val worldRank2 = intent.getStringExtra(WORLD_RANK2)

        binding.tvUniversitiesNameDetailUniv.text = universityName
        binding.tvUniversitiesAddDetailUniv.text = universityAddress
        binding.tvWorldRank1DetailUniv.text = worldRank1
        binding.tvWorldRank2DetailUniv.text = worldRank2

        goBack()
        goToMaps()
    }

    private fun goBack() {
        binding.ivBackArrowDetailUniv.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }

    private fun goToMaps() {
        binding.cvLocationDetailUniversity.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }

    companion object {
        const val UNIVERSITY = "university"
        const val ADDRESS = "address"
        const val DESCRIPTION = "description"
        const val WORLD_RANK1 = "world_rank1"
        const val WORLD_RANK2 = "world_rank2"
    }
}