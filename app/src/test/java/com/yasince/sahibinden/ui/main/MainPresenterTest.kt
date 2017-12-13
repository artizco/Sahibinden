package com.yasince.sahibinden.ui.detail

import com.yasince.sahibinden.data.DataManager
import com.yasince.sahibinden.ui.BaseTest
import com.yasince.sahibinden.ui.main.MainMvpView
import com.yasince.sahibinden.ui.main.MainPresenter
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest : BaseTest() {


    private lateinit var presenter: MainPresenter<MainMvpView>

    @Mock
    private lateinit var view: MainMvpView

    @Mock
    private lateinit var dataManager: DataManager

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = MainPresenter(dataManager)
        presenter.onAttach(view)
    }

    @Test
    fun testOnAttach() {
        Assert.assertNotNull(presenter.mvpView)
    }

}