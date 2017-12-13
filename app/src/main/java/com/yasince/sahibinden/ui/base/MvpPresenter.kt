package com.yasince.sahibinden.ui.base

interface MvpPresenter<in V : MvpView> {
    fun onAttach(mvpView: V)
}
