package com.app.basearchmvvmapp.data.models.albums


import com.google.gson.annotations.SerializedName

data class AlbumsResponseModel(
    @SerializedName("albumId")
    var albumId: Int?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("thumbnailUrl")
    var thumbnailUrl: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("url")
    var url: String?
)