package com.fadhlalhafizh.pathway.app.ui.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import com.fadhlalhafizh.pathway.R
import com.fadhlalhafizh.pathway.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewLoginFullScreenSetup()
        playAnimation()
    }

    @Suppress("DEPRECATION")
    private fun viewLoginFullScreenSetup() {
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

    private fun playAnimation(){
        val elementsObjectAnimation = listOf(
            ObjectAnimator.ofFloat(binding.tvLoginWelcome, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.tvLoginDescription, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.emailEditTextLayout, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.passwordEditTextLayout, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.tvLoginForgotPassword, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.cvBtnLogin, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.tvLoginCreateNewAccount, View.ALPHA, 1f)
        ).map { it.setDuration(100) }

        val playSequentially = AnimatorSet().apply {
            playSequentially(*elementsObjectAnimation.toTypedArray())
        }
        AnimatorSet().apply {
            playSequentially(playSequentially)
            startDelay = 500
            start()
        }
    }
}