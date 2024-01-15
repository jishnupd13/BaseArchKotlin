package com.app.basearchmvvmapp.viewmodel.albums

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.basearchmvvmapp.data.models.albums.AlbumsResponseModel
import com.app.basearchmvvmapp.data.repository.albums.AlbumsRepository
import com.app.basearchmvvmapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel@Inject constructor(
    private val repository: AlbumsRepository
) : ViewModel() {

    private var _apiResponseMutableLiveData: MutableLiveData<NetworkResult<List<AlbumsResponseModel>>> = MutableLiveData()
    var apiResponseLiveData: LiveData<NetworkResult<List<AlbumsResponseModel>>> = _apiResponseMutableLiveData

    fun fetchAlbums() = viewModelScope.launch {
        _apiResponseMutableLiveData.value = NetworkResult.Loading()
        _apiResponseMutableLiveData.value =  repository.fetchAlbums()
    }
}