package com.example.androidexam;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);
    private MainActivity mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity= activityRule.getActivity();
    }

    @Test
    public void testNavigationButtons () {

        // Click menu
       // openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        // home
        onView(withId(R.id.navbar_home));
        onView(withText("Do you want to study in Denmark?")).check(matches(isDisplayed()));
        onView(withId(R.id.homeImage)).check(matches(isDisplayed()));
        onView(withId(R.id.homeLongText)).check(matches(isDisplayed()));
         }


    @Test
    public void testLaunch(){

        onView(withId(R.id.drawerLayout)).check(matches(isDisplayed()));
    }

}