package com.example.dateprofile;

import androidx.test.espresso.ViewAssertion;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static org.hamcrest.Matchers.allOf;


public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<MainActivity>(MainActivity.class);


    @Test
    public void validEmail() {
        // onView(withId(R.id.username)).check(matches(withText(MainActivity.user.toString())));
        assert(MainActivity.validEmail("name@email.com"));
    }


    @Test
    public void formData(){
        onView(withId(R.id.fullname)).perform(typeText("Full Name"));
        onView(withId(R.id.useremail)).perform(typeText("userEmail@test.com"));
        onView(withId(R.id.username)).perform(typeText("User Name"));
        onView(withId(R.id.userbio)).perform(typeText("User BIO"));
        onView(withId(R.id.useroccupation)).perform(typeText("User Occupation"));
        
        onView(withId(R.id.fullname)).check(matches(withText("Full Name")));
        onView(withId(R.id.useremail)).check(matches(withText("userEmail@test.com")));
        onView(withId(R.id.username)).check(matches(withText("User Name")));
        onView(withId(R.id.userbio)).check(matches(withText("User BIO")));
        onView(withId(R.id.useroccupation)).check((matches(withText("User Occupation"))));
    }

    @Test
    public void validateFormDataNotBlank(){
        onView(withId(R.id.fullname)).perform(typeText(""));
        onView(withId(R.id.useremail)).perform(typeText(""));
        onView(withId(R.id.username)).perform(typeText(""));
        onView(withId(R.id.userbio)).perform(typeText(""));
        onView(withId(R.id.useroccupation)).perform(typeText(""));

        onView(allOf(withId(R.id.fullname), hasErrorText("Full name is required")));
        onView(allOf(withId(R.id.useremail), hasErrorText("Enter valid email!")));
        onView(allOf(withId(R.id.username), hasErrorText("User name is required")));
        onView(allOf(withId(R.id.userbio), hasErrorText("BIO is required")));
        onView(allOf(withId(R.id.useroccupation), hasErrorText("Occupation is required")));

    }
}
