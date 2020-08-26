package com.misterjedu.week6assignment

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class MainActivityUnitTest {

    private var mainActivity = MainActivity()


    //Phone Number Input testing
    @Test
    fun validate_phone_number_start_with_0() {
        var validePhoneWith0 = "07033187690"
        assertTrue("Phone number starts with 0", mainActivity.validateNumber(validePhoneWith0));
    }

    @Test
    fun validate_phone_number_start_with_234() {
        var validePhoneWith0 = "2347033187690"
        assertTrue("Phone number starts with 234", mainActivity.validateNumber(validePhoneWith0));
    }

    @Test
    fun validate_phone_number_start_with_plus234() {
        var validePhoneWith0 = "+2347033187690"
        assertTrue("Phone number starts with +234", mainActivity.validateNumber(validePhoneWith0));
    }

    @Test
    fun phone_number_not_start_with_0() {
        var validePhoneWith0 = "17033187690"
        assertFalse(
            "Phone number does not start with 0 or (+)234",
            mainActivity.validateNumber(validePhoneWith0)
        );
    }

    @Test
    fun phone_number_length_not_correct() {
        var validePhoneWith0 = "070373187690"
        assertFalse(
            "Phone number does not start with 0 or (+)234",
            mainActivity.validateNumber(validePhoneWith0)
        );
    }

    @Test
    fun phone_number_with_extra_prefix() {
        var validePhoneWith0 = "++2347033187690"
        assertFalse(
            "Phone number does not start with 0 or (+)234",
            mainActivity.validateNumber(validePhoneWith0)
        );
    }

    //Name Input Test

    @Test
    fun test_if_name_input_is_empty() {
        assertFalse("Name Input is Empty", mainActivity.validateName(""))
    }

    @Test
    fun test_if_name_input_is_not_empty() {
        assertTrue("Name input field is not empty", mainActivity.validateName("Not Empty"))
    }


    //Email Input Test
    @Test
    fun test_email_if_valid() {
        assertTrue("Email is valid", mainActivity.validateEmail("olad@gmail.com"))
    }

    @Test
    fun test_email_not_valid() {
        assertFalse("Email is not valid", mainActivity.validateEmail("oladgmail.com"))
    }

    @Test
    fun test_email_is_empty() {
        assertFalse("Email is not valid", mainActivity.validateEmail(""))
    }

}