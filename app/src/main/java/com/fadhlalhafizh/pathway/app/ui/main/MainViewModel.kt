package com.fadhlalhafizh.pathway.app.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.fadhlalhafizh.pathway.data.model.UserModel
import com.fadhlalhafizh.pathway.data.repository.UserRepository

class MainViewModel (private val userRepository: UserRepository) : ViewModel() {
    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: MutableLiveData<Boolean> = _isLoading

    fun getSession(): LiveData<UserModel> {
        return userRepository.getSession().asLiveData()
    }
}