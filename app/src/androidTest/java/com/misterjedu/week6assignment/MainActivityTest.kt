package com.misterjedu.week6assignment

import android.content.Intent
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.core.IsAnything.anything
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)

class MainActivityTest {
    //Declare Variables
    private var fullName = "Oladokun Oladapo"
    private  var phoneNumnber = "07013473097"
    private var emailAddress = "oladokun104@gmail.com"
    private  var gender = "Male"

    @get: Rule
    val activityRule : ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun test_main_activity_in_view() {
        onView(withId(R.id.main_activity)).check(matches(isDisplayed()))
    }

    @Test
    fun test_main_activity_background() {
        onView(withId(R.id.main_activity_background_image)).check(matches(isDisplayed()))
        onView(withId(R.id.main_activity_background_text)).check(matches(isDisplayed()))
    }

    @Test
    fun is_main_activity_background_text_displayed() {
        onView(withId(R.id.main_activity_background_text)).check(matches(withText(R.string.sign_up_page)))
    }

    @Test
    fun test_main_activity_user_name() {
        onView(withId(R.id.username_icon)).check(matches(isDisplayed()))
        onView(withId(R.id.full_name_input)).check(matches(isDisplayed()))
    }

    @Test
    fun test_main_activity_phone_number() {
        onView(withId(R.id.phone_icon)).check(matches(isDisplayed()))
        onView(withId(R.id.phone_number_input)).check(matches(isDisplayed()))
    }

    @Test
    fun test_main_activity_email_address() {
        onView(withId(R.id.email_icon)).check(matches(isDisplayed()))
        onView(withId(R.id.email_address_input)).check(matches(isDisplayed()))
    }

    @Test
    fun test_main_activity_gender() {
        onView(withId(R.id.gender_icon)).check(matches(isDisplayed()))
        onView(withId(R.id.gender_select)).check(matches(isDisplayed()))
    }

    @Test
    fun test_main_activity_terms_agreement() {
        onView(withId(R.id.terms_check_box)).check(matches(isDisplayed()))
        onView(withId(R.id.terms_text)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.terms_text)).check(matches(withText(R.string.terms_conditions)))
    }

    @Test
    fun test_main_activity_sign_up_button() {
        onView(withId(R.id.sign_up_button)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }


    @Test
    fun check_navigation_to_profile_activity(){
        //Input all required fields.
        onView(withId(R.id.full_name_input)).perform(click(), typeText(fullName), closeSoftKeyboard())
        onView(withId(R.id.phone_number_input)).perform(click(), replaceText(phoneNumnber), closeSoftKeyboard())
        onView(withId(R.id.email_address_input)).perform(click(), replaceText(emailAddress), closeSoftKeyboard())

        //Select Gender spinner and check value
        onView(withId(R.id.gender_select)).perform(click())
        onData(anything()).atPosition(1).perform(click())
        onView(withId(R.id.gender_select)).check(matches(withSpinnerText(containsString("Male"))))

        //Click Sign Up Button
        onView(withId(R.id.sign_up_button)).perform(click())

        //Check if Profile activity is displayed
        onView(withId(R.id.profile_activity)).check(matches((isDisplayed())))
    }


    //Create intent to be passed before next activity startrts
    @Before
    fun stub_profile_activity_with_intent(){
        var intent = Intent()
        intent.putExtra("userName", fullName)
        intent.putExtra("userEmail", emailAddress)
        intent.putExtra("userPhone", phoneNumnber)
        intent.putExtra("userGender", gender)
    }

    @get: Rule
    val intentRule : IntentsTestRule<MainActivity> = IntentsTestRule(MainActivity::class.java)

    @Test
    fun check_intent_passed_from_main_activity(){
        //Input all required fields.
        onView(withId(R.id.full_name_input)).perform(click(), typeText(fullName), closeSoftKeyboard())
        onView(withId(R.id.phone_number_input)).perform(click(), replaceText(phoneNumnber), closeSoftKeyboard())
        onView(withId(R.id.email_address_input)).perform(click(), replaceText(emailAddress), closeSoftKeyboard())

        //Select Gender spinner and check value
        onView(withId(R.id.gender_select)).perform(click())
        onData(anything()).atPosition(1).perform(click())
        onView(withId(R.id.gender_select)).check(matches(withSpinnerText(containsString("Male"))))

        //Click Sign Up Button
        onView(withId(R.id.sign_up_button)).perform(click())

        //Pass intent in the profile Activity
        intended(hasComponent(ProfileActivity::class.java.name))

        //Check if intents are passed and populated in the profile activity
        onView(withId(R.id.profile_name)).check(matches((withText(fullName))))
        onView(withId(R.id.profile_email_address)).check(matches((withText(emailAddress))))
        onView(withId(R.id.phone_number_profile)).check(matches((withText(phoneNumnber))))
        onView(withId(R.id.profile_gender)).check(matches((withText(gender))))
    }

}