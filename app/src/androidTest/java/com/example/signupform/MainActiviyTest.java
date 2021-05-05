package com.example.signupform;

import android.widget.EditText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActiviyTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<MainActivity>(MainActivity.class);


    @Test
    public void textEqual() {
        // onView(withId(R.id.username)).check(matches(withText(MainActivity.user.toString())));
        assert(MainActivity.validEmail("name@email.com"));
    }

    @Test
    public void formData() {
        onView(withId(R.id.fullname)).perform(typeText("Full Name"));
        onView(withId(R.id.useremail)).perform(typeText("userEmail@test.com"));
        onView(withId(R.id.username)).perform(typeText("User Name"));

        onView(withId(R.id.fullname)).check(matches(withText("Full Name")));
        onView(withId(R.id.useremail)).check(matches(withText("userEmail@test.com")));
        onView(withId(R.id.username)).check(matches(withText("User Name")));
    }
}
