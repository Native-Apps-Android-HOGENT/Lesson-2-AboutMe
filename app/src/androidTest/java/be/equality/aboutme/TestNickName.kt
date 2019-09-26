package be.equality.aboutme


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class TestNickName {


    private lateinit var nickNameToBeEntered : String

    // By using ActivityTestRule, the testing framework launches the activity under test
    // before each test method annotated with @Test and before any method annotated with
    // @Before. The framework handles shutting down the activity after the test
    // finishes and all methods annotated with @After are run.
    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)


    @Before
    fun setNickname(){
        nickNameToBeEntered = "Jules"
    }

    /**
     * Tests whether the text entered for a nicknam is shown in the edit text
     */
    @Test
    fun testAddNickname() {
        performInput()
        //Check whether the data in the nickname field is the nickname entered
        onView(withId(R.id.nickname_txtview)).check(matches(withText(nickNameToBeEntered)))
    }

    @Test
    fun testDisableEditTextAfterInput(){
        performInput()
        //Check whether the edit text is still visible
        onView(withId(R.id.nickname_edit)).check(matches(withEffectiveVisibility(Visibility.GONE)))
    }

    private fun performInput(){
        //Enter the nickname in the edit text
        onView(withId(R.id.nickname_edit)).perform(typeText(nickNameToBeEntered), closeSoftKeyboard())

        //perform the click on the button
        onView(withId(R.id.nickname_btn)).perform(click())
    }
}