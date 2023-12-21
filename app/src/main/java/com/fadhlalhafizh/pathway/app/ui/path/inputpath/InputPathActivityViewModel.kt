package com.fadhlalhafizh.pathway.app.ui.path.inputpath

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fadhlalhafizh.pathway.data.remote.request.AnswerRequest
import com.fadhlalhafizh.pathway.data.remote.response.ResultMajorResponse
import com.fadhlalhafizh.pathway.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InputPathActivityViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _resultLiveData = MutableLiveData<ResultMajorResponse>()
    val resultLiveData: LiveData<ResultMajorResponse> = _resultLiveData

    fun processInput(input: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val answerRequest = AnswerRequest(input)
            val result = userRepository.getAnswer(answerRequest)

            result.onSuccess { resultMajorResponse ->
                _resultLiveData.postValue(resultMajorResponse)
            }

            result.onFailure { exception ->

            }
        }
    }
}