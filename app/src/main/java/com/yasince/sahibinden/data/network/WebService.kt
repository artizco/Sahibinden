package com.yasince.sahibinden.data.network

import com.yasince.sahibinden.data.network.response.PhotoDetailResponse
import com.yasince.sahibinden.data.network.response.PhotosResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {


    @GET("photos")
    fun getPhotos(): Call<PhotosResponse>

    @GET("photos/{photoId}")
    fun getPhotoDetail(@Path("photoId") photoId: Long): Call<PhotoDetailResponse>
}
