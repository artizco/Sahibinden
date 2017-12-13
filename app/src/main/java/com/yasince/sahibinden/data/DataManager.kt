package com.yasince.sahibinden.data


import com.yasince.sahibinden.ui.listeners.PhotoDetailListener
import com.yasince.sahibinden.ui.listeners.PhotosListener

interface DataManager {

    fun getPhotos(listener: PhotosListener)

    fun getPhotoDetail(photoId: Long, listener: PhotoDetailListener)

}
