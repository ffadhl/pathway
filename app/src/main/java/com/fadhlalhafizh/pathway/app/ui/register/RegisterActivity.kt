package com.fadhlalhafizh.pathway.app.ui.register

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fadhlalhafizh.pathway.R
import com.fadhlalhafizh.pathway.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}