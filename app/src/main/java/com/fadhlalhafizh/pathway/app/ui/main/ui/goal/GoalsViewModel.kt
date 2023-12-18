package com.fadhlalhafizh.pathway.app.ui.main.ui.goal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GoalsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Goals Fragment"
    }
    val text: LiveData<String> = _text
}