package com.example.androidexam;

import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;




public class StudyOption_Test {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);
    private MainActivity mActivity = null;

    @Before
    public void SetUPFragment() {
        activityRule.getActivity().getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void onClickButton() {
        launchFragmentInContainer<StudyOption_fragment>();
        onView(withId(R.id.button_UniList)).perform(click();
    }
}