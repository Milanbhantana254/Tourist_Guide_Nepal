package com.example.tour_guide_nepal

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4::class)
class logintest{
    @get:Rule
    val testRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun checkArithmetic() {
        Espresso.onView(withId(R.id.txtname))
            .perform(ViewActions.typeText("aadi"))

        Espresso.onView(withId(R.id.txtpass))
            .perform(ViewActions.typeText("aadi"))

        Espresso.closeSoftKeyboard()

        Espresso.onView(withId(R.id.btnlogin))
            .perform(ViewActions.click())

        Thread.sleep(10000)

        Espresso.onView(withId(R.id.tablayout))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
}