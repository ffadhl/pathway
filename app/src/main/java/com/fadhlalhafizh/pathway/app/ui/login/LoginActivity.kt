package com.fadhlalhafizh.pathway.app.ui.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.AlertDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.fadhlalhafizh.pathway.R
import com.fadhlalhafizh.pathway.app.ui.login.forgotpassword.ForgotPasswordActivity
import com.fadhlalhafizh.pathway.app.ui.main.MainActivity
import com.fadhlalhafizh.pathway.app.ui.register.RegisterActivity
import com.fadhlalhafizh.pathway.app.viewmodel.ViewModelFactory
import com.fadhlalhafizh.pathway.data.model.UserModel
import com.fadhlalhafizh.pathway.databinding.ActivityLoginBinding
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModelLogin by viewModels<LoginViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelLogin.isLoading.observe(this) {
            displayProgressLoadingBar(it)
        }

        viewModelLogin.getSession().observe(this) {
            if (it.isLogin) {
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }
        }

        viewLoginFullScreenSetup()
        playAnimation()
        goToRegister()
        goToForgotPassword()
        setupAction()
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

    private fun playAnimation() {
        val elementsObjectAnimation = listOf(
            ObjectAnimator.ofFloat(binding.tvLoginWelcome, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.tvLoginDescription, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.emailEditTextLayout, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.passwordEditTextLayout, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.tvLoginForgotPassword, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.cvBtnLogin, View.ALPHA, 1f),
            ObjectAnimator.ofFloat(binding.tvLoginCreateNewAccount, View.ALPHA, 1f)
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
        binding.btnLogin.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            val inputEmail = getString(R.string.inputEmail)
            val inputPassword = getString(R.string.inputPassword)
            val passwordValidation = getString(R.string.passwordValidation)

            if (email.isEmpty()) {
                binding.emailEditText.error = inputEmail
            } else if (password.isEmpty()) {
                binding.passwordEditText.error = inputPassword
            } else if (password.length < 8) {
                binding.passwordEditText.error = passwordValidation
            } else {
                lifecycleScope.launch {
                    try {
                        val loginResult = viewModelLogin.signIn(email, password)
                        val error = loginResult.error
                        if (!error) {
                            viewModelLogin.saveSession(UserModel(email, true))
                            showSuccessDialog(loginResult.message)
                        } else {
                            showErrorDialog(loginResult.message)
                        }
                    } catch (e: HttpException) {
                        showErrorDialog("Server error: ${e.code()}")
                        e.printStackTrace()
                    } finally {
                        displayProgressLoadingBar(false)
                    }
                }
            }
        }
    }

    private fun showSuccessDialog(message: String?) {
        if (!isFinishing && !isDestroyed) {
            AlertDialog.Builder(this@LoginActivity).apply {
                setTitle("Success")
                setMessage(message)
                setPositiveButton("Ok") { _, _ ->
                    navigateToMainActivity()
                }
                val alertMessage = create()
                alertMessage.show()
            }
        }
    }


    private fun navigateToMainActivity() {
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

    private fun showErrorDialog(errorMessage: String?) {
        AlertDialog.Builder(this@LoginActivity).apply {
            setTitle("Alert")
            setMessage(errorMessage ?: "Incorrect Email or Password, Try Again!")
            setPositiveButton("Ok") { _, _ ->
                clearInputFields()
            }
            val alertMessage = create()
            alertMessage.show()
        }
    }

    private fun clearInputFields() {
        binding.emailEditText.text?.clear()
        binding.passwordEditText.text?.clear()
    }

    private fun displayProgressLoadingBar(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun goToRegister() {
        binding.tvLoginCreateNewAccount.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }

    private fun goToForgotPassword() {
        binding.tvLoginForgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}