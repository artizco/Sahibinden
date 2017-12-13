package com.yasince.sahibinden.ui.photos

import com.yasince.sahibinden.data.DataManager
import com.yasince.sahibinden.ui.BaseTest
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PhotosPresenterTest : BaseTest() {

    private lateinit var presenter: PhotosPresenter<PhotosMvpView>

    @Mock
    private lateinit var view: PhotosMvpView

    @Mock
    private lateinit var dataManager: DataManager

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = PhotosPresenter(dataManager)
        presenter.onAttach(view)
    }

    @Test
    fun testOnAttach() {
        Assert.assertNotNull(presenter.mvpView)
    }

    @Test
    fun testGetPhotos() {
        presenter.getPhotos()
        Mockito.verify(dataManager)?.getPhotos(presenter.photosListener)
    }
}