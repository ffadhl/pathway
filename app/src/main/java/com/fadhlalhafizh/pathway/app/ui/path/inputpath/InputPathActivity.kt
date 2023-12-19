package com.fadhlalhafizh.pathway.app.ui.path.inputpath

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fadhlalhafizh.pathway.databinding.ActivityInputPathBinding

class InputPathActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputPathBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputPathBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setSoftInputMode(android.view.WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }
}