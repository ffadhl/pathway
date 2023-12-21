package com.fadhlalhafizh.pathway.app.ui.path.outputpath

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fadhlalhafizh.pathway.data.remote.response.ResultMajorResponse

class OutputPathActivityViewModel : ViewModel() {
    private val _resultLiveData = MutableLiveData<ResultMajorResponse>()
    val resultLiveData: LiveData<ResultMajorResponse> = _resultLiveData

    fun setResult(result: ResultMajorResponse) {
        _resultLiveData.value = result
        Log.d("OutputPathActivityViewModel", "Result set: $result")
    }
}
