package com.misterjedu.week6assignment

import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.Suite

//Run Both Main activity and Profile Activity UI tests
@RunWith(Suite::class)
 @Suite.SuiteClasses(
     MainActivityTest::class,
    ProfileActivityTest::class
 )

class ActivityTestSuite