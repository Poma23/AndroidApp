package com.example.androidexam;

import android.app.Activity;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class ApplyTest extends Activity {

    @Rule
    public ActivityTestRule< ApplyTest > activityRule = new ActivityTestRule<>(ApplyTest.class);
    private ApplyTest mApply = null;

    @Before
    public void setUp() throws Exception {
        mApply = activityRule.getActivity();
    }

    @Test
    public void testOptagelseButton() throws IOException {
        onView(withId(R.id.apply_imagebutton)).check(matches(isDisplayed()));

        // onView(withId(R.id.apply_imagebutton)).perform(openLinkWithText("https://www.optagelse.dk"));
        // onView(hasLinks("https://www.optagelse.dk")).check(matches(isDisplayed()))
    }

}