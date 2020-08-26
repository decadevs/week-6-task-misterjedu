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


    @Test
    fun test_profile_activity_in_view() {
        onView(withId(R.id.profile_activity)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun test_profile_activity_background() {
        onView(withId(R.id.profile_background)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_user_image)).check(matches(isDisplayed()))
    }

    @Test
    fun test_profile_welcome_user_name_display() {
        onView(withId(R.id.profile_welcome_text)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_name)).check(matches(isDisplayed()))
    }


    @Test
    fun test_profile_user_name_text() {
        onView(withId(R.id.profile_welcome_text)).check(matches(withText(R.string.welcome)))
    }


    @Test
    fun test_profile_phone_number_display() {
        onView(withId(R.id.profile_phone_number_key)).check(matches(isDisplayed()))
        onView(withId(R.id.phone_number_profile)).check(matches(isDisplayed()))
    }

    @Test
    fun test_profile_welcome_phone_number_text() {
        onView(withId(R.id.profile_phone_number_key)).check(matches(withText(R.string.profile_phone_number)))
    }

    @Test
    fun test_profile_email_display() {
        onView(withId(R.id.profile_email_key)).check(matches(isDisplayed()))
        onView(withId(R.id.phone_number_profile)).check(matches(isDisplayed()))
    }

    @Test
    fun test_profile_email_text() {
        onView(withId(R.id.profile_email_key)).check(matches(withText(R.string.email_profile)))
    }

    @Test
    fun test_profile_gender_display() {
        onView(withId(R.id.profile_gender_key)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_gender)).check(matches(isDisplayed()))
    }

    @Test
    fun test_profile_gender_text() {
        onView(withId(R.id.profile_gender_key)).check(matches(withText(R.string.profile_gender)))
    }



}