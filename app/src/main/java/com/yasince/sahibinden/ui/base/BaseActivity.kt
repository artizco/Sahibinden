package com.yasince.sahibinden.ui.base

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yasince.sahibinden.R
import kotlinx.android.synthetic.main.appbar.*

open class BaseActivity : AppCompatActivity(), MvpView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun initToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar)
            toolbar.setTitleTextColor(Color.WHITE)
        }
    }

    fun setHomeButtonVisibility(showBack: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(showBack)
        supportActionBar?.setDisplayShowHomeEnabled(showBack)
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
    }

    override fun onStart() {
        super.onStart()
    }

    fun openFragment(fragment: BaseFragment, showBack: Boolean) {
        setHomeButtonVisibility(showBack)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.mainFl, fragment)
        fragmentTransaction.addToBackStack("")
        fragmentTransaction.commit()
    }
}
