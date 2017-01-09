package com.example.jeremy.urbanflow;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.StringStartsWith.startsWith;

/**
 * Created by Ashley on 09/01/2017.
 */

public class MainActivityTransitionsTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void transitionToCredit() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("About")).perform(click());
        onView(withText("Credits")).check(matches(isDisplayed()));
    }

    // ARTICLES
    @Test
    public void transitionToFirst() {
        // Has to be in first position
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withText("Welcome to UrbanFlow")).check(matches(isDisplayed()));
    }

    @Test
    public void transitionToDNSP() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Le DNSP pour LES NULS (version #STRITER)")), click()));
        onView(withText("Le DNSP pour LES NULS (version #STRITER)")).check(matches(isDisplayed()));
    }

    @Test
    public void transitionToConference() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Retour sur la conférence-débat de @NoiseLaVille | STRITER")), click()));
        onView(withText("Retour sur la conférence-débat de @NoiseLaVille | STRITER")).check(matches(isDisplayed()));
    }

    @Test
    public void transitionToExperience() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Retour sur l’expérience “The Turnament” (FR) | #STRITER")), click()));
        onView(withText("Retour sur l’expérience “The Turnament” (FR) | #STRITER")).check(matches(isDisplayed()));
    }

    // VIDEOS
    @Test
    public void transitionToCercle() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Cercle Underground 2016 - Showcase - The Kartel")), click()));
        onView(withText(startsWith("Hagson présente"))).check(matches(isDisplayed()));
    }

    @Test
    public void transitionToKantyn() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Kantyn x PNL #LaFrenchTouch")), click()));
        onView(withText("Kantyn x PNL #LaFrenchTouch")).check(matches(isDisplayed()));
    }

    @Test
    public void transitionToAnthologie() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Un battle d'anthologie")), click()));
        onView(withText("Un battle d'anthologie")).check(matches(isDisplayed()));
    }

    @Test
    public void transitionToAnissa() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Anissa x Lefa #LaFrenchTouch")), click()));
        onView(withText("Anissa x Lefa #LaFrenchTouch")).check(matches(isDisplayed()));
    }

    @Test
    public void transitionToJerems() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText(startsWith("Maître Gims"))), click()));
        onView(withText(startsWith("Maître Gims"))).check(matches(isDisplayed()));
    }

    //EVENTS
    @Test
    public void transitionToCoursDeDanse() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Cours de danse")), click()));
        onView(withText("Cours de danse")).check(matches(isDisplayed()));
    }


    @Test
    public void transitionToJusteDebout() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Juste Debout 2017")), click()));
        onView(withText("Juste Debout 2017")).check(matches(isDisplayed()));
    }


    @Test
    public void transitionToPopping() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Popping Choreo Workshop")), click()));
        onView(withText("Popping Choreo Workshop")).check(matches(isDisplayed()));
    }

    @Test
    public void transitionToReady() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("WAR Battle - 1vs1 Popping & HipHop - by Ready Or Not")), click()));
        onView(withText("WAR Battle - 1vs1 Popping & HipHop - by Ready Or Not")).check(matches(isDisplayed()));
    }
}
