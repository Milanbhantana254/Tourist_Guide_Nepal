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

class RegistrationTesting {
    @get:Rule
    val  testRule = ActivityScenarioRule(Signup::class.java)

    @Test
    fun TestRegisterUI(){

        Espresso.onView(withId(R.id.etemail)).perform(ViewActions.closeSoftKeyboard())
 
            .perform(ViewActions.typeText("test@gmail.com"))
 
        Espresso.onView(withId(R.id.etname)).perform(ViewActions.closeSoftKeyboard())
            .perform(ViewActions.typeText("test"))

            .perform(ViewActions.typeText("test"))
        Espresso.onView(withId(R.id.etphone)).perform(ViewActions.closeSoftKeyboard())
            .perform(ViewActions.typeText("123"))

        Espresso.onView(withId(R.id.etpass)).perform(ViewActions.closeSoftKeyboard())
            .perform(ViewActions.typeText("test"))
        Espresso.onView(withId(R.id.etconpass)).perform(ViewActions.closeSoftKeyboard())
            .perform(ViewActions.typeText("test"))

        Espresso.onView(withId(R.id.btnsignup)).perform(ViewActions.closeSoftKeyboard())
            .perform(ViewActions.click())
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.btnsignup))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
