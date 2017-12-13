package com.yasince.sahibinden.ui.listeners

import com.yasince.sahibinden.data.network.response.PhotoDetailResponse

interface PhotoDetailListener : ErrorListener{
    fun onResponse(response: PhotoDetailResponse)
}
