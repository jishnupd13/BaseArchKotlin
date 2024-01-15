package com.app.basearchmvvmapp.data.repository.albums

import com.app.basearchmvvmapp.data.network.albums.AlbumsApiService
import com.app.basearchmvvmapp.utils.safeApiCall
import javax.inject.Inject

class AlbumsRepository @Inject constructor(
    private val albumApiService: AlbumsApiService
)  {
    suspend fun fetchAlbums() = safeApiCall { albumApiService.fetchAlbums() }

}