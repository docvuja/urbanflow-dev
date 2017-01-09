package com.example.jeremy.urbanflow;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by Ashley on 09/01/2017.
 */

public class CreditActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(CreditActivity.class);

    @Test
    public void testToolbarTitle() {
        onView(allOf(instanceOf(TextView.class), withParent(withId(R.id.toolbar_credit))))
                .check(matches(withText("UrbanFlow")));
    }

    @Test
    public void testTitle() {
        onView(withId(R.id.credit_text)).check(matches(withText("Credits")));
    }

    @Test
    public void testRuben() {
        onView(withText(R.string.pres_ruben)).check(matches(isDisplayed()));
    }

    @Test
    public void testJerem() {
        onView(withText(R.string.pres_jerem)).check(matches(isDisplayed()));
    }
}
