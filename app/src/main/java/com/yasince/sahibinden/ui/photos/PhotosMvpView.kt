package com.yasince.sahibinden.ui.photos

import com.yasince.sahibinden.data.network.model.Photo
import com.yasince.sahibinden.ui.base.MvpView

interface PhotosMvpView : MvpView {

    fun initPresenter()

    fun initUI()

    fun loadPhotos(photos: ArrayList<Photo>)

    fun showPhotosError(error: String)

    fun noPhotosFound()

    fun openDetailPage(photo: Photo)
}