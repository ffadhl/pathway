package com.fadhlalhafizh.pathway.app.ui.detailprofession

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fadhlalhafizh.pathway.databinding.ActivityDetailProfessionBinding

class DetailProfessionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailProfessionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProfessionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}