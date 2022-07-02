package com.example.tour_guide_nepal

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.example.tour_guide_nepal.fragments.Selectplaces
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.concurrent.thread

@LargeTest
@RunWith(JUnit4::class)

class Selectplacestesting {



        @get:Rule
        val testRule = ActivityScenarioRule(Selectplaces::class.java)

        @Test
        fun Selectplacestesting() {
            onView(withId(R.id.kathmandu))
                .perform(click())

            onView(withId(R.id.kathmanduimage))
                .check(matches(isDisplayed()))
            Espresso.pressBack();

            onView(withId(R.id.lumbini))
                .perform(click())

            onView(withId(R.id.lumbiniimage))
                .check(matches(isDisplayed()))
            Espresso.pressBack();

            onView(withId(R.id.solukhumbu))
                .perform(click())

            onView(withId(R.id.solukhumbuimage))
                .check(matches(isDisplayed()))
            Espresso.pressBack();

            onView(withId(R.id.chitwan))
                .perform(click())

            onView(withId(R.id.chitwanimage))
                .check(matches(isDisplayed()))
            Espresso.pressBack();
            onView(withText("Chitwan"))
                .perform(ViewActions.swipeUp())

            Thread.sleep(2000)
            onView(withText("Chitwan"))
                .perform(ViewActions.swipeUp())

            onView(withText("Chitwan"))
                .perform(ViewActions.swipeUp())

            onView(withText("Chitwan"))
                .perform(ViewActions.swipeUp())

            onView(withText("Chitwan"))
                .perform(ViewActions.swipeUp())

            onView(withText("Chitwan"))
                .perform(ViewActions.swipeUp())

            onView(withId(R.id.dolakha))
                .perform(click())

            onView(withId(R.id.dolakhaimage))
                .check(matches(isDisplayed()))
            Espresso.pressBack();
            onView(withText("Chitwan"))
                .perform(ViewActions.swipeUp())
            onView(withText("Chitwan"))
                .perform(ViewActions.swipeUp())

            Thread.sleep(2000)
            onView(withText("Chitwan"))
                .perform(ViewActions.swipeUp())

            onView(withText("Chitwan"))
                .perform(ViewActions.swipeUp())

            onView(withText("Chitwan"))
                .perform(ViewActions.swipeUp())

            onView(withText("Chitwan"))
                .perform(ViewActions.swipeUp())

            onView(withText("Dolakha"))
                .perform(ViewActions.swipeUp())
            onView(withText("Dolakha"))
                .perform(ViewActions.swipeUp())
            onView(withText("Dolakha"))
                .perform(ViewActions.swipeUp())
            onView(withText("Dolakha"))
                .perform(ViewActions.swipeUp())
            onView(withText("Dolakha"))
                .perform(ViewActions.swipeUp())


            onView(withId(R.id.mustang))
                .perform(click())

            onView(withId(R.id.mustangimage))
                .check(matches(isDisplayed()))
            Espresso.pressBack();

            onView(withText("Mustang"))
                .perform(ViewActions.swipeUp())
            onView(withText("Mustang"))
                .perform(ViewActions.swipeUp())
            onView(withText("Mustang"))
                .perform(ViewActions.swipeUp())
            onView(withText("Mustang"))
                .perform(ViewActions.swipeUp())
            onView(withText("Mustang"))
                .perform(ViewActions.swipeUp())
            onView(withText("Mustang"))
                .perform(ViewActions.swipeUp())
            onView(withText("Mustang"))
                .perform(ViewActions.swipeUp())
            onView(withText("Mustang"))
                .perform(ViewActions.swipeUp())
            onView(withText("Mustang"))
                .perform(ViewActions.swipeUp())
            onView(withText("Mustang"))
                .perform(ViewActions.swipeUp())

            onView(withId(R.id.pokhara))
                .perform(click())

            onView(withId(R.id.pokharaimage))
                .check(matches(isDisplayed()))
            Espresso.pressBack();
            onView(withText("Pokhara"))
                .perform(ViewActions.swipeUp())
            onView(withText("Pokhara"))
                .perform(ViewActions.swipeUp())
            onView(withText("Pokhara"))
                .perform(ViewActions.swipeUp())
            onView(withText("Pokhara"))
                .perform(ViewActions.swipeUp())
            onView(withText("Pokhara"))
                .perform(ViewActions.swipeUp())
            onView(withText("Pokhara"))
                .perform(ViewActions.swipeUp())
            onView(withText("Pokhara"))
                .perform(ViewActions.swipeUp())
            onView(withText("Pokhara"))
                .perform(ViewActions.swipeUp())
            onView(withText("Pokhara"))
                .perform(ViewActions.swipeUp())
            onView(withText("Pokhara"))
                .perform(ViewActions.swipeUp())

            onView(withId(R.id.gorkha))
                .perform(click())

            onView(withId(R.id.gorkhaimage))
                .check(matches(isDisplayed()))
            Espresso.pressBack();
            onView(withText("Gorkha"))
                .perform(ViewActions.swipeUp())
            onView(withText("Gorkha"))
                .perform(ViewActions.swipeUp())
            onView(withText("Gorkha"))
                .perform(ViewActions.swipeUp())
            onView(withText("Gorkha"))
                .perform(ViewActions.swipeUp())
            onView(withText("Gorkha"))
                .perform(ViewActions.swipeUp())
            onView(withText("Gorkha"))
                .perform(ViewActions.swipeUp())
            onView(withText("Gorkha"))
                .perform(ViewActions.swipeUp())
            onView(withText("Gorkha"))
                .perform(ViewActions.swipeUp())
            onView(withText("Gorkha"))
                .perform(ViewActions.swipeUp())
            onView(withText("Gorkha"))
                .perform(ViewActions.swipeUp())

            onView(withId(R.id.janakpur))
                .perform(click())

            onView(withId(R.id.janakpurimage))
                .check(matches(isDisplayed()))
            Espresso.pressBack();

            onView(withText("Janakpur"))
                .perform(ViewActions.swipeUp())
            onView(withText("Janakpur"))
                .perform(ViewActions.swipeUp())
            onView(withText("Janakpur"))
                .perform(ViewActions.swipeUp())
            onView(withText("Janakpur"))
                .perform(ViewActions.swipeUp())
            onView(withText("Janakpur"))
                .perform(ViewActions.swipeUp())
            onView(withText("Janakpur"))
                .perform(ViewActions.swipeUp())
            onView(withText("Janakpur"))
                .perform(ViewActions.swipeUp())
            onView(withText("Janakpur"))
                .perform(ViewActions.swipeUp())
            onView(withText("Gorkha"))
                .perform(ViewActions.swipeUp())
            onView(withText("Gorkha"))
                .perform(ViewActions.swipeUp())


            onView(withId(R.id.tanahun))
                .perform(click())

            onView(withId(R.id.tanahunimage))
                .check(matches(isDisplayed()))

        }
    }
