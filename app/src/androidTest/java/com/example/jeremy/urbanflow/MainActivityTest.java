package com.example.jeremy.urbanflow;

import android.app.Application;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;
import android.test.ApplicationTestCase;
import android.view.View;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.hamcrest.object.HasToString.hasToString;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void testToolbarTitle() {
        onView(allOf(instanceOf(TextView.class), withParent(withId(R.id.toolbar_main))))
                .check(matches(withText("UrbanFlow")));
    }

    @Test
    public void countRecyclerViewSize() {
        onView(withId(R.id.recyclerView)).check(new RecyclerViewItemCountAssertion(13));
    }

    // ARTICLES
    @Test
    public void isInRecyclerViewWelcome() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Welcome to UrbanFlow")), click()));
    }

    @Test
    public void isInRecyclerViewDNSP() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Le DNSP pour LES NULS (version #STRITER)")), click()));
    }

    @Test
    public void isInRecyclerViewConference() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Retour sur la conférence-débat de @NoiseLaVille | STRITER")), click()));
    }

    @Test
    public void isInRecyclerViewExperience() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Retour sur l’expérience “The Turnament” (FR) | #STRITER")), click()));
    }

    // VIDEOS
    @Test
    public void isInRecyclerViewCercle() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Cercle Underground 2016 - Showcase - The Kartel")), click()));
    }

    @Test
    public void isInRecyclerViewKantyn() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Kantyn x PNL #LaFrenchTouch")), click()));
    }

    @Test
    public void isInRecyclerViewAnthologie() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Un battle d'anthologie")), click()));
    }

    @Test
    public void isInRecyclerViewAnissa() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Anissa x Lefa #LaFrenchTouch")), click()));
    }

    @Test
    public void isInRecyclerViewJerems() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText(startsWith("Maître Gims"))), click()));
    }

    //EVENTS
    @Test
    public void isInRecyclerViewCoursDeDanse() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Cours de danse")), click()));
    }


    @Test
    public void isInRecyclerViewJusteDebout() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Juste Debout 2017")), click()));
    }


    @Test
    public void isInRecyclerViewPopping() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Popping Choreo Workshop")), click()));
    }

    @Test
    public void isInRecyclerViewReady() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("WAR Battle - 1vs1 Popping & HipHop - by Ready Or Not")), click()));
    }

    public class RecyclerViewItemCountAssertion implements ViewAssertion {
        private final int expectedCount;

        public RecyclerViewItemCountAssertion(int expectedCount) {
            this.expectedCount = expectedCount;
        }

        @Override
        public void check(View view, NoMatchingViewException noViewFoundException) {
            if (noViewFoundException != null) {
                throw noViewFoundException;
            }

            RecyclerView recyclerView = (RecyclerView) view;
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            Assert.assertEquals(adapter.getItemCount(), expectedCount);
        }
    }
}