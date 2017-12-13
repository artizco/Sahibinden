package com.yasince.sahibinden.ui.detail

import com.yasince.sahibinden.data.DataManager
import com.yasince.sahibinden.ui.BaseTest
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailPresenterTest : BaseTest() {

    private val INVALID_PHOTO_ID: Long = 0
    private val PHOTO_ID: Long = 123

    private lateinit var presenter: DetailPresenter<DetailMvpView>

    @Mock
    private lateinit var view: DetailMvpView

    @Mock
    private lateinit var dataManager: DataManager

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailPresenter(dataManager)
        presenter.onAttach(view)
    }

    @Test
    fun testOnAttach() {
        Assert.assertNotNull(presenter.mvpView)
    }

    @Test
    fun testGetPhotoDetailWithEmptyId() {
        presenter.getPhotoDetail(INVALID_PHOTO_ID)
        verify(presenter.mvpView)?.showPhotoIdError()
    }

    @Test
    fun testGetPhotoDetailWithValidId() {
        presenter.getPhotoDetail(PHOTO_ID)
        verify(dataManager)?.getPhotoDetail(PHOTO_ID, presenter.photoDetailListener)
    }
}