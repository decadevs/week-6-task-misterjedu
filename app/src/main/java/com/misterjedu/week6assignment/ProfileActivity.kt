package com.misterjedu.week6assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        /**
         * Get all strings passed as intent from Main Activity
         */
        val userProfileName: String = intent.getStringExtra("userName").toString()
        val userProfileEmail: String = intent.getStringExtra("userEmail").toString()
        val userPhoneNumber: String = intent.getStringExtra("userPhone").toString()
        val userGender: String = intent.getStringExtra("userGender").toString()


        /**
         * Set the placeholder texts to the strings retrieved from the intents
         */
        profile_name.text = userProfileName
        profile_email_address.text = userProfileEmail
        phone_number_profile.text = userPhoneNumber
        profile_gender.text = userGender
    }


}