package com.example.tour_guide_nepal

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.example.tour_guide_nepal.hotel.Hotelbooking_Activity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4::class)

class hotelbooking {
    @get:Rule
    val  testRule = ActivityScenarioRule(Hotelbooking_Activity::class.java)

    @Test
    fun hotelbooking(){

        Espresso.onView(withId(R.id.etfullname)).perform(ViewActions.closeSoftKeyboard())
            .perform(ViewActions.typeText("test@gmail.com"))
        Espresso.onView(withId(R.id.etemail)).perform(ViewActions.closeSoftKeyboard())
            .perform(ViewActions.typeText("test"))

            .perform(ViewActions.typeText("test"))
        Espresso.onView(withId(R.id.etphonenumber)).perform(ViewActions.closeSoftKeyboard())
            .perform(ViewActions.typeText("123"))

        Espresso.onView(withId(R.id.ethotelname)).perform(ViewActions.closeSoftKeyboard())
            .perform(ViewActions.typeText("test"))
        Espresso.onView(withId(R.id.etroomtype)).perform(ViewActions.closeSoftKeyboard())
            .perform(ViewActions.typeText("test"))
        Espresso.onView(withId(R.id.datefrom)).perform(ViewActions.closeSoftKeyboard())
            .perform(ViewActions.typeText("test"))
        Espresso.onView(withId(R.id.dateto)).perform(ViewActions.closeSoftKeyboard())
            .perform(ViewActions.typeText("test"))
        Espresso.onView(withId(R.id.etguestnumber)).perform(ViewActions.closeSoftKeyboard())
            .perform(ViewActions.typeText("test"))
        Espresso.onView(withId(R.id.comments)).perform(ViewActions.closeSoftKeyboard())
            .perform(ViewActions.typeText("test"))

        Espresso.onView(withId(R.id.btnsignup)).perform(ViewActions.closeSoftKeyboard())
            .perform(ViewActions.click())
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.btnsignup))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
