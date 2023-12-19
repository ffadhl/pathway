package com.fadhlalhafizh.pathway.app.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fadhlalhafizh.pathway.data.repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

class RegisterViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isErrorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _isErrorMessage

    fun register(name: String, email: String, password: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val message = userRepository.signupUser(name, email, password).message
                _isErrorMessage.value = message!!
            } catch (e: HttpException) {
                _isErrorMessage.value = "Server error: ${e.code()}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}