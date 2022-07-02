package com.example.tour_guide_nepal

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.example.tour_guide_nepal.vehicle.Vehicle_booking_form_activity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4::class)

class Vechiclerenttest {
    @get:Rule
    val testRule = ActivityScenarioRule(Vehicle_booking_form_activity::class.java)

    @Test
    fun checkArithmetic() {
        onView(ViewMatchers.withId(R.id.hireemail))
            .perform(typeText("roshni1234@gmail.com"))

        onView(ViewMatchers.withId(R.id.hirename))
            .perform(typeText("roshni"))

        onView(ViewMatchers.withId(R.id.hirembnumber))
            .perform(typeText("987654321"))

        onView(ViewMatchers.withId(R.id.hirenoofperson)).perform(scrollTo(), click())
            .perform(typeText("2"))

        Espresso.closeSoftKeyboard()

        onView(ViewMatchers.withId(R.id.hirestartdate))
            .perform(typeText("13/8/2021"))
        Espresso.closeSoftKeyboard()

        onView(ViewMatchers.withId(R.id.hireenddate))
            .perform(typeText("20/8/2021"))
        Espresso.closeSoftKeyboard()

        onView(ViewMatchers.withId(R.id.hirecomments)).perform(scrollTo(), click())
            .perform(typeText("goodservice"))

        Espresso.closeSoftKeyboard()

        onView(ViewMatchers.withId(R.id.btnrent))
            .perform(click())


    }
}
