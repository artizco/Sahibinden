package com.yasince.sahibinden.ui.photos

import com.yasince.sahibinden.data.DataManager
import com.yasince.sahibinden.data.network.response.PhotosResponse
import com.yasince.sahibinden.ui.base.BasePresenter
import com.yasince.sahibinden.ui.listeners.PhotosListener

class PhotosPresenter<V : PhotosMvpView>(dataManager: DataManager) : BasePresenter<V>(dataManager),
        PhotosMvpPresenter<V> {

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)
        this.mvpView = mvpView
    }

    override fun getPhotos() {
        dataManager.getPhotos(photosListener)
    }

    val photosListener = object : PhotosListener {
        override fun onError(errorMessage: String) {
            mvpView?.showPhotosError(errorMessage)
        }

        override fun onResponse(response: PhotosResponse) {
            if (response.photos == null || response.photos.isEmpty()) {
                mvpView?.noPhotosFound()
                return
            }
            mvpView?.loadPhotos(response.photos)
        }
    }
}