package com.example.androidexam;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.*;

public class Accomodation_lifeTest {

    @Rule
    public ActivityTestRule< Accomodation_life > activityRule = new Accomodation_life<>(Accomodation_lifeTest.class);
    private Accomodation_life mLife = null;

    @Before
    public void setUp() throws Exception {
        mApply = activityRule.getActivity();
    }

}