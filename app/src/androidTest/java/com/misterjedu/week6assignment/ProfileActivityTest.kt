package com.misterjedu.week6assignment

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)

class ProfileActivityTest{

    @get: Rule
    val activityRule : ActivityScenarioRule<ProfileActivity> = ActivityScenarioRule(ProfileActivity::class.java)

    //Test if Activity is in view
    @Test
    fun test_profile_activity_in_view() {
        onView(withId(R.id.profile_activity)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    //Test if profile activity background and the user image is displayed
    @Test
    fun test_profile_activity_background() {
        onView(withId(R.id.profile_background)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_user_image)).check(matches(isDisplayed()))
    }

    //Test if welcome user name textview is displayed
    @Test
    fun test_profile_welcome_user_name_display() {
        onView(withId(R.id.profile_welcome_text)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_name)).check(matches(isDisplayed()))
    }

    //Test if welcome user name text is displays the correct
    @Test
    fun test_profile_user_name_text() {
        onView(withId(R.id.profile_welcome_text)).check(matches(withText(R.string.welcome)))
    }

    //Test if welcome user phone number text view and placeholder is displays the correct
    @Test
    fun test_profile_phone_number_display() {
        onView(withId(R.id.profile_phone_number_key)).check(matches(isDisplayed()))
        onView(withId(R.id.phone_number_profile)).check(matches(isDisplayed()))
    }

    //Test if welcome user phone number text is displays the correct
    @Test
    fun test_profile_welcome_phone_number_text() {
        onView(withId(R.id.profile_phone_number_key)).check(matches(withText(R.string.profile_phone_number)))
    }

    //Test if welcome user profile email textview and placeholder text are displayed correctly
    @Test
    fun test_profile_email_display() {
        onView(withId(R.id.profile_email_key)).check(matches(isDisplayed()))
        onView(withId(R.id.phone_number_profile)).check(matches(isDisplayed()))
    }

    //Test if email text is displays the correct value
    @Test
    fun test_profile_email_text() {
        onView(withId(R.id.profile_email_key)).check(matches(withText(R.string.email_profile)))
    }

    //Test if welcome user profile gender text vire and placeholder text are displayed correctly
    @Test
    fun test_profile_gender_display() {
        onView(withId(R.id.profile_gender_key)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_gender)).check(matches(isDisplayed()))
    }

    //Test if gender text view is displays the correct value
    @Test
    fun test_profile_gender_text() {
        onView(withId(R.id.profile_gender_key)).check(matches(withText(R.string.profile_gender)))
    }

}