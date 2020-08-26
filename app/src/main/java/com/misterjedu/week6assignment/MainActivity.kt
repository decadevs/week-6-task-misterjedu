package com.misterjedu.week6assignment

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Matcher
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {
    /**
     * Initialize variables
     */
    private lateinit var signUpButton: Button
    private lateinit var userFullName: TextInputEditText
    private lateinit var userPhone: TextInputEditText
    private lateinit var userEmail: TextInputEditText
    private lateinit var genderChoice: Spinner
    private lateinit var genderSelected: String
    private lateinit var emailInput: String
    private lateinit var phoneNumber: String
    private lateinit var userName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Set field variables
         */
        signUpButton = sign_up_button
        userFullName = full_name_input
        userPhone = phone_number_input
        userEmail = email_address_input
        genderChoice = gender_select

        /**
         * Get the gender option selected.
         */
        genderChoice.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                genderSelected = adapterView?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                return
            }
        }

        // On Click Listener on the sign up button, validate all fields and start next activity
        sign_up_button.setOnClickListener {
            validateAllFields()
        }
    }


    /**
     * Check if all fields are validated, open the profile activity.
     */
    private fun validateAllFields() {
        //Get all User Input on Signup buttonClick
        emailInput = userEmail.text.toString().trim()
        phoneNumber = userPhone.text.toString().trim()
        userName = userFullName.text.toString().trim()


        //Validate all Inputs start next activity
        if (!validateEmail(emailInput) or !validateName(userName) or !validateNumber(phoneNumber) or !validateGender()) {
            validateUiEditText()
            if (!validateGender()) {
                Toast.makeText(this, "Select a Gender", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Check the fields", Toast.LENGTH_SHORT).show()
            }

        } else {
            val intent = Intent(this, ProfileActivity::class.java)

            intent.putExtra("userName", userFullName.text.toString())
            intent.putExtra("userEmail", userEmail.text.toString())
            intent.putExtra("userPhone", userPhone.text.toString())
            intent.putExtra("userGender", genderSelected)
            startActivity(intent)
        }
    }

    /**
     * Validate Email Address input
     */

    fun validateEmail(email: String): Boolean {
        var pattern: Pattern =
            Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})\$");
        var matcher: Matcher = pattern.matcher(email);
        val matchFound = matcher.matches()
        return !(email.isEmpty() || !matchFound)
    }


    /**
     * Validate Phone Number Input
     */
    fun validateNumber(number: String): Boolean {
        var pattern: Pattern = Pattern.compile("(\\+?234|0)[789][01][0-9]{8}")
        var matcher: Matcher = pattern.matcher(number)
        val matchFound = matcher.matches()
        return !(number.isEmpty() || !matchFound)
    }

    /**
     * Validate Full Name
     */
    fun validateName(name: String): Boolean {
        return !name.isEmpty()
    }

    /**
     *Check if Valid Gender is chosen
     */
    fun validateGender(): Boolean {
        return genderSelected == "Male" || genderSelected == "Female" || genderSelected == "Other"
    }

    /**
     * Validate all EditText UI fields
     */
    private fun validateUiEditText() {
        // UI Email input Validation
        if (!validateEmail(emailInput)) {
            userEmail.error = "Check your email"
        } else {
            userEmail.error = null
        }

        // UI User name input Validation
        if (!validateName(userName)) {
            userFullName.error = "Field can't be empty"
        } else {
            userFullName.error = null
        }

        // UI Phone input validation
        if (!validateNumber(phoneNumber)) {
            userPhone.error = "Check your number"
        } else {
            userPhone.error = null
        }
    }

    /**
     * Make any inputs out of focus when background is clicked
     */
    fun backGroundOnClick(view: View) {
        userFullName.clearFocus()
        userPhone.clearFocus()
        userEmail.clearFocus()
    }

}