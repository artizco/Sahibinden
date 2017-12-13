package com.yasince.sahibinden.ui.photos

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yasince.sahibinden.App
import com.yasince.sahibinden.R
import com.yasince.sahibinden.data.network.model.Photo
import com.yasince.sahibinden.ui.adapter.PhotoItemListener
import com.yasince.sahibinden.ui.adapter.PhotosAdapter
import com.yasince.sahibinden.ui.base.BaseFragment
import com.yasince.sahibinden.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_photos.*

class PhotosFragment : BaseFragment(), PhotosMvpView, PhotoItemListener {

    private lateinit var adapter: PhotosAdapter
    private var photos: ArrayList<Photo> = ArrayList()
    private var presenter: PhotosPresenter<PhotosMvpView>? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view: View = inflater!!.inflate(R.layout.fragment_photos, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPresenter()
        initUI()
        presenter?.getPhotos()
    }

    override fun initUI() {
        adapter = PhotosAdapter(photos, this)
        photosContainerRv.adapter = adapter
        val lm = GridLayoutManager(activity, 2)
        photosContainerRv.layoutManager = lm
    }

    override fun initPresenter() {
        val dataManager = (activity.application as App).dataManager
        presenter = PhotosPresenter(dataManager)
        presenter?.onAttach(this)
    }

    override fun onItemClick(photo: Photo) {
        openDetailPage(photo)
    }

    override fun loadPhotos(photos: ArrayList<Photo>) {
        this.photos.clear()
        this.photos.addAll(photos)
        adapter.notifyDataSetChanged()
    }

    override fun openDetailPage(photo: Photo) {
        (activity as MainActivity).openDetailFragment(photo)
    }

    override fun showPhotosError(error: String) {
        showServiceError(error)
    }

    override fun noPhotosFound() {
        showMessage(getString(R.string.no_photos_found))
    }

    companion object {

        fun getInstance(): PhotosFragment {
            return PhotosFragment()
        }
    }
}
