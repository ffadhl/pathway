package com.fadhlalhafizh.pathway.app.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fadhlalhafizh.pathway.data.remote.request.RegistrationRequest
import com.fadhlalhafizh.pathway.data.repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

class RegisterViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isErrorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _isErrorMessage

    fun register(name: String, email: String, password: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val registrationRequest = RegistrationRequest(name, email, password)
                val result = userRepository.signupUser(
                    registrationRequest.name,
                    registrationRequest.email,
                    registrationRequest.password
                )

                if (result.isSuccess) {
                    _isErrorMessage.value = result.getOrNull()?.message
                } else {
                    _isErrorMessage.value = result.getOrNull()?.message
                        ?: "the email has already been used"
                }
            } catch (e: HttpException) {
                _isErrorMessage.value = "Network error: ${e.message}"
            } catch (e: Exception) {
                _isErrorMessage.value = "An unexpected error occurred"
            } finally {
                _isLoading.value = false
            }
        }
    }
}