package com.yasince.sahibinden.ui.main

import com.yasince.sahibinden.data.network.model.Photo
import com.yasince.sahibinden.ui.base.MvpView

/**
 * Created by YCETINER on 12/10/17.
 */
interface MainMvpView : MvpView {

    fun openPhotosFragment()

    fun openDetailFragment(photo: Photo)
}