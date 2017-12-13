package com.yasince.sahibinden.data.network.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

open class Photo : Parcelable {
    val id: Long? = 0

    val name: String? = ""

    val camera: String? = ""

    val rating: Double? = 0.0

    @SerializedName("image_url")
    val imageUrl: String = ""

    val user: User? = null

    constructor()

    constructor(source: Parcel) : this(
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {}

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Photo> = object : Parcelable.Creator<Photo> {
            override fun createFromParcel(source: Parcel): Photo = Photo(source)
            override fun newArray(size: Int): Array<Photo?> = arrayOfNulls(size)
        }
    }
}
