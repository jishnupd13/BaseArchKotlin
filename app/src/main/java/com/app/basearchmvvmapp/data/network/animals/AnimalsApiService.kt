package com.app.basearchmvvmapp.data.network.animals

import com.app.basearchmvvmapp.data.models.animals.AnimalsResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface AnimalsApiService {

    @GET("api/breeds/image/random")
    suspend fun getDog(): Response<AnimalsResponseModel>
}