package com.fadhlalhafizh.pathway.app.ui.detailuniversity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fadhlalhafizh.pathway.R
import com.fadhlalhafizh.pathway.databinding.ActivityDetailUniversityBinding

class DetailUniversityActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUniversityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUniversityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}