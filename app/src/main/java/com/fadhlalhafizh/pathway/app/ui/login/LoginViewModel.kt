package com.fadhlalhafizh.pathway.app.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.fadhlalhafizh.pathway.data.model.UserModel
import com.fadhlalhafizh.pathway.data.remote.response.LoginResponse
import com.fadhlalhafizh.pathway.data.repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {
    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: MutableLiveData<Boolean> = _isLoading

    fun saveSession(userModel: UserModel) {
        viewModelScope.launch {
            userRepository.saveSession(userModel)
        }
    }

    fun getSession(): LiveData<UserModel> {
        return userRepository.getSession().asLiveData()
    }

    suspend fun signIn(email: String, password: String): LoginResponse {
        _isLoading.postValue(true)
        val response = userRepository.signInUser(email, password)
        _isLoading.postValue(false)
        return response.getOrNull()!!
    }
}