package com.fadhlalhafizh.pathway.app.ui.welcome

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.fadhlalhafizh.pathway.app.ui.login.LoginActivity
import com.fadhlalhafizh.pathway.app.ui.register.RegisterActivity
import com.fadhlalhafizh.pathway.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewWelcomeFullScreenSetup()
        playAnimation()
        buttonAction()
    }

    @Suppress("DEPRECATION")
    private fun viewWelcomeFullScreenSetup() {
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
        ObjectAnimator.ofFloat(binding.lottieAnimationViewWelcome, View.TRANSLATION_X, -30f, 30f).apply {
            duration = 5000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        val elementsObjectAnimation = listOf(
            ObjectAnimator.ofFloat(binding.tvWelcome1, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.tvPathHere1, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.tvPathHere2, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.tvWelcomeDescription, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.cvBlueButton, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.cvWhiteButton, View.ALPHA, 1f)
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

    private fun buttonAction() {
        binding.btnLoginWelcome.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        binding.btnRegisterWelcome.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}