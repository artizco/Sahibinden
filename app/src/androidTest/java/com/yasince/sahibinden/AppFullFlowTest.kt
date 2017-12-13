package com.yasince.sahibinden

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.yasince.sahibinden.ui.adapter.PhotosAdapter
import com.yasince.sahibinden.ui.main.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppFullFlowTest : BaseTest() {

    @get:Rule
    private val activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java, true, true)

    @Before
    fun setUp() {
    }

    @Test
    fun testHappyPath() {
        activityRule.launchActivity(null)

        //PHOTOS FRAGMENT
        sleepShort()

        onView(withId(R.id.photosContainerRv)).check(matches(isDisplayed()))

        onView(ViewMatchers.withId(R.id.photosContainerRv))
                .perform(RecyclerViewActions.
                        actionOnItemAtPosition<PhotosAdapter.PhotoViewHolder>(PHOTO_INDEX, click()))

        sleepShort()

        //DETAIL FRAGMENT

        onView(withId(R.id.detailCameraTv)).check(matches(isDisplayed()))
        onView(withId(R.id.detailNameTv)).check(matches(isDisplayed()))
        onView(withId(R.id.detailPhotoIv)).check(matches(isDisplayed()))
        onView(withId(R.id.detailPhotographerTv)).check(matches(isDisplayed()))

        onView(withContentDescription("Navigate up")).perform(click())

        sleepShort()

        //PHOTOS FRAGMENT

        onView(withId(R.id.photosContainerRv)).check(matches(isDisplayed()))

    }

    companion object {
        val PHOTO_INDEX: Int = 5
    }
}
