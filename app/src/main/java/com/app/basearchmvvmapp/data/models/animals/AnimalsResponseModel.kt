package com.app.basearchmvvmapp.data.models.animals

import com.google.gson.annotations.SerializedName

data class AnimalsResponseModel(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)