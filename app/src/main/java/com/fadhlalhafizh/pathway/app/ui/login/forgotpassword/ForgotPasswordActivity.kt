package com.fadhlalhafizh.pathway.app.ui.login.forgotpassword

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.fadhlalhafizh.pathway.app.ui.main.MainActivity
import com.fadhlalhafizh.pathway.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewForgotPassFullScreenSetup()
        playAnimation()
        goToMain()
    }

    @Suppress("DEPRECATION")
    private fun viewForgotPassFullScreenSetup() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    private fun playAnimation() {
        val elementsObjectAnimation = listOf(
            ObjectAnimator.ofFloat(binding.tvForgotPasswordWelcome, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.tvForgotPasswordDescription, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.emailEditTextLayoutForgotPassword, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.cvBtnSubmit, View.ALPHA, 1f),
        ).map { it.setDuration(200) }

        val playSequentially = AnimatorSet().apply {
            playSequentially(*elementsObjectAnimation.toTypedArray())
        }
        AnimatorSet().apply {
            playSequentially(playSequentially)
            startDelay = 500
            start()
        }
    }

    private fun goToMain() {
        binding.btnSubmit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}