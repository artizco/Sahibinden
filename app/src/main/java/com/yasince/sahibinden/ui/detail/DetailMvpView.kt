package com.yasince.sahibinden.ui.detail

import com.yasince.sahibinden.data.network.model.Photo
import com.yasince.sahibinden.ui.base.MvpView

interface DetailMvpView : MvpView {

    fun initPresenter()

    fun initUI()

    fun getPhotoDetail(photoId: Long)

    fun loadDetail(photo: Photo)

    fun showDetailError(error: String)

    fun showPhotoIdError()
}
