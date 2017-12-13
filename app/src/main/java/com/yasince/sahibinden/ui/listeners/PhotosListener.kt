package com.yasince.sahibinden.ui.listeners

import com.yasince.sahibinden.data.network.response.PhotosResponse

interface PhotosListener : ErrorListener {
    fun onResponse(response: PhotosResponse)
}
