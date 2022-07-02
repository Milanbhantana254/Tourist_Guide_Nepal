package com.example.tour_guide_nepal

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import com.example.tour_guide_nepal.fragments.Select_cityFragment
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4::class)
class logoutbdd{
    @Test
    fun logoutbdd() {
        launchFragmentInContainer<Select_cityFragment>(themeResId = R.style.Theme_Tour_Guide_Nepal)

        Espresso.onView(ViewMatchers.withId(R.id.navmenu)).perform(ViewActions.closeSoftKeyboard())
            .perform(ViewActions.click())
        Thread.sleep(3000)
        Espresso.onView(ViewMatchers.withId(R.id.navmenu))

        Espresso.onView(ViewMatchers.withId(R.id.nav_logout)).perform(ViewActions.closeSoftKeyboard())
            .perform(ViewActions.click())
        Thread.sleep(3000)
        Espresso.onView(ViewMatchers.withId(R.id.nav_logout))

        Espresso.onView(ViewMatchers.withId(R.layout.activity_main))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


    }
}