package com.yasince.sahibinden.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.yasince.sahibinden.App
import com.yasince.sahibinden.R
import com.yasince.sahibinden.data.network.model.Photo
import com.yasince.sahibinden.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : BaseFragment(), DetailMvpView {

    private var presenter: DetailPresenter<DetailMvpView>? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater!!.inflate(R.layout.fragment_detail, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPresenter()
        val photo = arguments.getParcelable<Photo>(PARAM_PHOTO)
        presenter?.getPhotoDetail(photo.id!!)
    }

    override fun initUI() {
    }

    override fun initPresenter() {
        val dataManager = (activity.application as App).dataManager
        presenter = DetailPresenter(dataManager)
        presenter?.onAttach(this)
    }

    override fun getPhotoDetail(photoId: Long) {
        presenter?.getPhotoDetail(photoId)
    }

    override fun showDetailError(error: String) {
        showDetailError(error)
    }

    override fun showPhotoIdError() {
        showMessage(getString(R.string.invalid_photo_id))
    }

    override fun loadDetail(photo: Photo) {
        detailNameTv.text = photo.name
        detailPhotographerTv.text = photo.user?.fullName()
        detailCameraTv.text = photo.camera
        Picasso.with(activity).load(photo.imageUrl).into(detailPhotoIv)
    }

    companion object {
        val PARAM_PHOTO: String = "PHOTO"

        fun getInstance(photo: Photo): DetailFragment {
            val f = DetailFragment()
            val bundle = Bundle()
            bundle.putParcelable(PARAM_PHOTO, photo)
            f.arguments = bundle
            return f
        }
    }
}
