package com.yasince.sahibinden.ui.photos

import com.yasince.sahibinden.ui.base.MvpPresenter
import com.yasince.sahibinden.ui.base.MvpView

interface PhotosMvpPresenter<in V : MvpView> : MvpPresenter<V>{

    fun getPhotos()
}
