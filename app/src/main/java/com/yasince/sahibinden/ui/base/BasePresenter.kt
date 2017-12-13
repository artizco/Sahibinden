package com.yasince.sahibinden.ui.base


import com.yasince.sahibinden.data.DataManager

open class BasePresenter<V : MvpView>(val dataManager: DataManager) : MvpPresenter<V> {

    var mvpView: V? = null

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }
}
