package com.fadhlalhafizh.pathway.app.ui.welcome

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fadhlalhafizh.pathway.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}