package com.yasince.sahibinden.ui.detail

import com.yasince.sahibinden.data.DataManager
import com.yasince.sahibinden.data.network.response.PhotoDetailResponse
import com.yasince.sahibinden.ui.base.BasePresenter
import com.yasince.sahibinden.ui.listeners.PhotoDetailListener

class DetailPresenter<V : DetailMvpView>(dataManager: DataManager) : BasePresenter<V>(dataManager),
        DetailMvpPresenter<V> {

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }

    override fun getPhotoDetail(photoId: Long) {
        if (photoId <= 0) {
            mvpView?.showPhotoIdError()
        }
        dataManager.getPhotoDetail(photoId, photoDetailListener)
    }

    val photoDetailListener = object : PhotoDetailListener {
        override fun onResponse(response: PhotoDetailResponse) {
            if (response.photo == null) {
                mvpView?.showDetailError("")
            }
            mvpView?.loadDetail(response.photo!!)
        }

        override fun onError(errorMessage: String) {
            mvpView?.showDetailError(errorMessage)
        }
    }
}