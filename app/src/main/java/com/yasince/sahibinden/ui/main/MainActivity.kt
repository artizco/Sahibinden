package com.yasince.sahibinden.ui.main

import android.os.Bundle
import android.view.MenuItem
import com.yasince.sahibinden.R
import com.yasince.sahibinden.data.network.model.Photo
import com.yasince.sahibinden.ui.base.BaseActivity
import com.yasince.sahibinden.ui.detail.DetailFragment
import com.yasince.sahibinden.ui.photos.PhotosFragment

class MainActivity : BaseActivity(), MainMvpView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()
        openPhotosFragment()
    }

    override fun openPhotosFragment() {
        openFragment(PhotosFragment.getInstance(), false)
    }

    override fun openDetailFragment(photo: Photo) {
        openFragment(DetailFragment.getInstance(photo), true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            if (supportFragmentManager.backStackEntryCount > 0) {
                supportFragmentManager.popBackStack()
            }
            setHomeButtonVisibility(false)
        }
        return super.onOptionsItemSelected(item)
    }
}
