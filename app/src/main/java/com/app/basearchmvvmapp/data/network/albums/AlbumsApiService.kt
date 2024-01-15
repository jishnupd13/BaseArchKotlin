package com.app.basearchmvvmapp.data.network.albums

import com.app.basearchmvvmapp.data.models.albums.AlbumsResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface AlbumsApiService {
    @GET("photos")
    suspend fun fetchAlbums(): Response<List<AlbumsResponseModel>>
}