package com.example.tour_guide_nepal

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.example.tour_guide_nepal.place_details.chitwan_detail_activity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4::class)
class placedetailsandweatherTesting {
    @get:Rule
    val testRule = ActivityScenarioRule(chitwan_detail_activity::class.java)

    @Test
    fun detailsandweatherTest() {
        onView(withId(R.id.chitwanimage))
            .check(matches(isDisplayed()))

        onView(withId(R.id.chitwanweather))
            .perform(click())

        onView(withId(R.id.status))
            .check(matches(withText("Clear Sky")))
    }
}