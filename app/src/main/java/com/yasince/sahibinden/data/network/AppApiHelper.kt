package com.yasince.sahibinden.data.network

import com.yasince.sahibinden.data.network.response.PhotoDetailResponse
import com.yasince.sahibinden.data.network.response.PhotosResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


class AppApiHelper : ApiHelper {

    private val BASE_URL = "https://api.500px.com/v1/"
    private val CONSUMER_KEY = "eLXcQTCFZzpYZD2uvyNgRaicv6zjixd1JrVXkJ5C"

    private var retrofit: Retrofit? = null
    private var service: WebService? = null

    private val isServiceAvailable: Boolean
        get() = service != null

    init {
        if (retrofit == null) {

            val okHttpClient = OkHttpClient.Builder()
            okHttpClient.addInterceptor(object : Interceptor {
                @Throws(IOException::class)
                override fun intercept(chain: Interceptor.Chain): Response {
                    val original = chain.request()
                    val originalHttpUrl = original.url()
                    val url = originalHttpUrl.newBuilder()
                            .addQueryParameter("consumer_key", CONSUMER_KEY)
                            .build()
                    val requestBuilder = original.newBuilder().url(url)
                    val request = requestBuilder.build()
                    return chain.proceed(request)
                }
            })

            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        if (service == null)
            service = retrofit!!.create(WebService::class.java)
    }

    override fun getPhotos(callback: Callback<PhotosResponse>) {
        if (isServiceAvailable) {
            val call = service!!.getPhotos()
            call.enqueue(callback)
        }
    }

    override fun getPhotoDetail(photoId: Long, callback: Callback<PhotoDetailResponse>) {
        if (isServiceAvailable) {
            val call = service!!.getPhotoDetail(photoId)
            call.enqueue(callback)
        }
    }

}
