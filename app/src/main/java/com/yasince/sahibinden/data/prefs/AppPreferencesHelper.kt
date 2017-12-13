package com.yasince.sahibinden.data.prefs

import android.content.Context
import android.content.SharedPreferences

class AppPreferencesHelper(context: Context) : PreferencesHelper {

    override fun getToken(): String {
        return sharedPrefs.getString(KEY_TOKEN, "")
    }

    override fun setToken(token: String) {
        sharedPrefs.edit().putString(KEY_TOKEN, token).commit()
    }

    private val sharedPrefs: SharedPreferences

    init {
        sharedPrefs = context.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE)
    }

    companion object {

        private val MY_PREFS = "MY_PREFS"
        private val KEY_TOKEN = "TOKEN"
    }
}
