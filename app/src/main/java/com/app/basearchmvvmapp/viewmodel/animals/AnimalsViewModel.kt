package com.app.basearchmvvmapp.viewmodel.animals

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.basearchmvvmapp.data.models.animals.AnimalsResponseModel
import com.app.basearchmvvmapp.data.repository.animals.AnimalsRepository
import com.app.basearchmvvmapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimalsViewModel @Inject constructor(
    private val repository: AnimalsRepository
) : ViewModel(){

    private var _apiResponseMutableLiveData:MutableLiveData<NetworkResult<AnimalsResponseModel>> = MutableLiveData()
    var apiResponseLiveData:LiveData<NetworkResult<AnimalsResponseModel>> = _apiResponseMutableLiveData

    fun getDogs() = viewModelScope.launch {
        _apiResponseMutableLiveData.value = NetworkResult.Loading()
        _apiResponseMutableLiveData.value =  repository.getDog()
    }
}