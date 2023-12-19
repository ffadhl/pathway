package com.fadhlalhafizh.pathway.app.ui.register

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.fadhlalhafizh.pathway.R
import com.fadhlalhafizh.pathway.app.ui.login.LoginActivity
import com.fadhlalhafizh.pathway.app.viewmodel.ViewModelFactory
import com.fadhlalhafizh.pathway.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val viewModelRegister by viewModels<RegisterViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelRegister.isLoading.observe(this) {
            displayProgressLoadingBar(it)
        }

        viewModelRegister.errorMessage.observe(this) {
            showAlertMessage(it.toString())
        }

        viewRegisterFullScreenSetup()
        playAnimation()
        setupAction()
        goToLogin()
    }

    @Suppress("DEPRECATION")
    private fun viewRegisterFullScreenSetup() {
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
            ObjectAnimator.ofFloat(binding.tvRegisterWelcome, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.tvRegisterDescription, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.nameEditTextLayout, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.emailEditTextLayout, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.passwordEditTextLayout, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.cvBtnRegister, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.tvRegisterAlreadyHaveAccount, View.ALPHA, 1f),
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

    private fun setupAction() {
        binding.btnRegister.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            val inputName = getString(R.string.inputName)
            val inputEmail = getString(R.string.inputEmail)
            val inputPassword = getString(R.string.inputPassword)
            val passwordValidation = getString(R.string.passwordValidation)

            if (name.isEmpty()) {
                binding.nameEditText.error = inputName
            } else if (email.isEmpty()) {
                binding.emailEditText.error = inputEmail
            } else if (password.isEmpty()) {
                binding.passwordEditText.error = inputPassword
            } else if (password.length < 8) {
                binding.passwordEditText.error = passwordValidation
            } else {
                viewModelRegister.register(name, email, password)
            }
        }
    }

    private fun displayProgressLoadingBar(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun showAlertMessage(message: String) {
        val dialogBuilder = android.app.AlertDialog.Builder(this)
        dialogBuilder.setMessage(message)
            .setCancelable(false)
            .setPositiveButton("Ok") { dialog, _ ->
                dialog.dismiss()
                if (message == "User created") {
                    val intent = Intent(this, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                    finish()
                } else {
                    binding.nameEditText.text?.clear()
                    binding.emailEditText.text?.clear()
                    binding.passwordEditText.text?.clear()
                }
            }
        val alertMessage = dialogBuilder.create()
        alertMessage.setTitle("Alert")
        alertMessage.show()
    }

    private fun goToLogin() {
        binding.tvRegisterAlreadyHaveAccount.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}