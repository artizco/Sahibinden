package com.yasince.sahibinden

import android.app.Application
import com.yasince.sahibinden.data.AppDataManager
import com.yasince.sahibinden.data.DataManager
import com.yasince.sahibinden.data.db.AppDbHelper
import com.yasince.sahibinden.data.network.AppApiHelper
import com.yasince.sahibinden.data.prefs.AppPreferencesHelper

class App : Application() {

    lateinit var dataManager: DataManager
        internal set

    override fun onCreate() {
        super.onCreate()

        val spHelper = AppPreferencesHelper(applicationContext)
        val apiHelper = AppApiHelper()
        val dbHelper = AppDbHelper(applicationContext)
        dataManager = AppDataManager(applicationContext, spHelper, apiHelper, dbHelper)
    }
}
