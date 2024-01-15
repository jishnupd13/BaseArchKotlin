package com.app.basearchmvvmapp.data.repository.animals

import com.app.basearchmvvmapp.data.network.animals.AnimalsApiService
import com.app.basearchmvvmapp.utils.safeApiCall
import javax.inject.Inject

class AnimalsRepository@Inject constructor(
    private val animalsApiService: AnimalsApiService
) {
    suspend fun getDog() = safeApiCall { animalsApiService.getDog() }
}