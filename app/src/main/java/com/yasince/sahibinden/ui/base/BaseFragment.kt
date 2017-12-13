package com.yasince.sahibinden.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.yasince.sahibinden.R

/**
 * Created by YCETINER on 12/10/17.
 */
open class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    fun showMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    fun showServiceError(error: String) {
        if (TextUtils.isEmpty(error)) {
            showMessage(getString(R.string.service_error))
        } else {
            showMessage(error)
        }
    }
}