package com.yasince.sahibinden.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.yasince.sahibinden.R
import com.yasince.sahibinden.data.network.model.Photo
import com.yasince.sahibinden.utils.inflate
import kotlinx.android.synthetic.main.item_photo.view.*

class PhotosAdapter(val photoList: ArrayList<Photo>, private val listener: PhotoItemListener) :
        RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = photoList[position]
        holder.bindPhoto(photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflatedView = parent.inflate(R.layout.item_photo, false)
        return PhotoViewHolder(inflatedView, listener)
    }

    override fun getItemCount() = photoList.size


    class PhotoViewHolder(v: View, private val listener: PhotoItemListener) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var photo: Photo? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            listener.onItemClick(photo!!)
        }

        fun bindPhoto(photo: Photo) {
            this.photo = photo
            view.tag = photo.id
            view.photoItemNameTv.text = photo.user?.fullName()
            Picasso.with(view.photoItemPicIv.context).load(photo.imageUrl).into(view.photoItemPicIv)
        }
    }
}