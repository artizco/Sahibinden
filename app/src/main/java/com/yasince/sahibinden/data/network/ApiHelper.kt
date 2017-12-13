package com.yasince.sahibinden.data.network

import com.yasince.sahibinden.data.network.response.PhotoDetailResponse
import com.yasince.sahibinden.data.network.response.PhotosResponse
import retrofit2.Callback

interface ApiHelper {


    fun getPhotos(callback: Callback<PhotosResponse>)

    fun getPhotoDetail(photoId: Long, callback: Callback<PhotoDetailResponse>)
}
