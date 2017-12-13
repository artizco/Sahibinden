package com.yasince.sahibinden.data

import android.content.Context
import com.yasince.sahibinden.data.db.DbHelper
import com.yasince.sahibinden.data.network.ApiHelper
import com.yasince.sahibinden.data.network.response.PhotoDetailResponse
import com.yasince.sahibinden.data.network.response.PhotosResponse
import com.yasince.sahibinden.data.prefs.PreferencesHelper
import com.yasince.sahibinden.ui.listeners.PhotoDetailListener
import com.yasince.sahibinden.ui.listeners.PhotosListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppDataManager(private val context: Context,
                     private val prefHelper: PreferencesHelper,
                     private val apiHelper: ApiHelper,
                     private val dbHelper: DbHelper) : DataManager {

    override fun getPhotos(listener: PhotosListener) {
        apiHelper.getPhotos(object : Callback<PhotosResponse> {
            override fun onResponse(call: Call<PhotosResponse>,
                                    response: Response<PhotosResponse>) {

                if (response.body() == null) {
                    listener.onError("")
                    return
                }

                listener.onResponse(response.body()!!)
            }

            override fun onFailure(call: Call<PhotosResponse>, t: Throwable) {
                listener.onError(t.message.toString())
            }
        })
    }

    override fun getPhotoDetail(photoId: Long, listener: PhotoDetailListener) {
        apiHelper.getPhotoDetail(photoId, object : Callback<PhotoDetailResponse> {
            override fun onResponse(call: Call<PhotoDetailResponse>,
                                    response: Response<PhotoDetailResponse>) {

                if (response.body() == null) {
                    listener.onError("")
                    return
                }
                listener.onResponse(response.body()!!)
            }

            override fun onFailure(call: Call<PhotoDetailResponse>, t: Throwable) {
                listener.onError(t.message.toString())
            }
        })
    }
}
