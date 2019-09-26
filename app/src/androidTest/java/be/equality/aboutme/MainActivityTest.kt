package be.equality.aboutme

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun onEnterName_labelChanges() {
        onView(withId(R.id.txt_nickname)).perform(typeText("Naam"))
        onView(withId(R.id.btn_nickname)).perform(click())

        onView(withId(R.id.lbl_nickname)).check(matches(withText("Naam")))
    }

    @Test
    fun onEnterName_buttonDisappears() {
        onView(withId(R.id.txt_nickname)).perform(typeText("Naam"))
        onView(withId(R.id.btn_nickname)).perform(click())

        onView(withId(R.id.btn_nickname)).check(matches(not(isDisplayed())))
    }

}
