package com.yasince.sahibinden.ui.adapter

import com.yasince.sahibinden.data.network.model.Photo

interface PhotoItemListener {
    fun onItemClick(photo: Photo)
}