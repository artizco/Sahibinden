package com.yasince.sahibinden.ui.detail

import com.yasince.sahibinden.ui.base.MvpPresenter
import com.yasince.sahibinden.ui.base.MvpView

interface DetailMvpPresenter<in V : MvpView> : MvpPresenter<V> {

    fun getPhotoDetail(photoId: Long)
}
