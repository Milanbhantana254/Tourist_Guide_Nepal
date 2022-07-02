package com.example.tour_guide_nepal

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.example.tour_guide_nepal.place_details.chitwan_detail_activity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4::class)

class Busstationtest {
    @get:Rule
    val testRule = ActivityScenarioRule(chitwan_detail_activity::class.java)

    @Test
    fun Busstationtest() {
        onView(withId(R.id.chitwannear))
            .perform(click())
        onView(withId(R.id.Busstation))
            .perform(click())
        Thread.sleep(5000)
        onView(withId(R.id.nearByPlacesRecycle))
            .check(matches(isDisplayed()))


    }
}