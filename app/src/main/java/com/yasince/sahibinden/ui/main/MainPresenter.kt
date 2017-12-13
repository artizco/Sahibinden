package com.yasince.sahibinden.ui.main

import com.yasince.sahibinden.data.DataManager
import com.yasince.sahibinden.ui.base.BasePresenter

/**
 * Created by YCETINER on 12/10/17.
 */

class MainPresenter<V : MainMvpView>(dataManager: DataManager) : BasePresenter<V>(dataManager),
        MainMvpPresenter<V> {

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)
        this.mvpView = mvpView
    }
}