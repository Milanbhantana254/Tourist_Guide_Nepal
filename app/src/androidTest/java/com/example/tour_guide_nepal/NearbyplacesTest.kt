package com.example.tour_guide_nepal

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.example.tour_guide_nepal.place_details.chitwan_detail_activity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4::class)
class NearbyplacesTest {
    @get:Rule
    val testRule =ActivityScenarioRule(chitwan_detail_activity::class.java)

    @Test
    fun nearbyplaceTest() {
        onView(withId(R.id.chitwannear))
            .perform(click())

        onView(withId(R.id.bus))
            .check(matches(withText("Bus stop")))

        onView(withId(R.id.restaurent))
            .check(matches(withText("Resturants")))

        onView(withId(R.id.hospital))
            .check(matches(withText("Hospitals")))

        onView(withId(R.id.atm))
            .check(matches(withText("ATM")))

        onView(withId(R.id.hotel))
            .check(matches(withText("Hotels")))

        onView(withId(R.id.police))
            .check(matches(withText("Police station")))

        onView(withId(R.id.market))
            .check(matches(withText("Shopping mall")))

        onView(withId(R.id.coffee))
            .check(matches(withText("Cafe")))

        onView(withId(R.id.visitzoo))
            .check(matches(withText("Zoo")))
    }
}