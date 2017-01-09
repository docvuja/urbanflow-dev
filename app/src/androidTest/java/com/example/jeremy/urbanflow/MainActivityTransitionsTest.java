package com.example.jeremy.urbanflow;

import com.example.jeremy.urbanflow.Utils.DateUtils;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.core.deps.guava.base.Utf8;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.StringStartsWith.startsWith;

/**
 * Created by Ashley on 08/01/2017.
 */

public class MainActivityTransitionsTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    // ARTICLES
    @Test
    public void transitionToFirst() {
        // Has to be in first position
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.title_article))
                .check(matches(withText("Welcome to UrbanFlow")));
        onView(withId(R.id.text_article))
                .check(matches(withText("Bienvenue sur la nouvelle application de " +
                        "référence de la culture urbaine. Vous y retrouverez toute l'actualité du monde " +
                        "hip hop : vidéo, articles, évènements\n\nPEACE, LOVE, UNITY & HAVIN' FUN")));
        onView(withId(R.id.author))
                .check(matches(withText(startsWith("Docvuja"))));
    }

    @Test
    public void transitionToDNSP() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Le DNSP pour LES NULS (version #STRITER)")), click()));
        onView(withId(R.id.title_article))
                .check(matches(withText("Le DNSP pour LES NULS (version #STRITER)")));
        onView(withId(R.id.text_article))
                .check(matches(withText(startsWith("\r\nQu’est-ce que le DNSP ?"))));
        onView(withId(R.id.author))
                .check(matches(withText(startsWith("Kiudee"))));
    }

    @Test
    public void transitionToConference() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Retour sur la conférence-débat de @NoiseLaVille | STRITER")), click()));
        onView(withId(R.id.title_article))
                .check(matches(withText("Retour sur la conférence-débat de @NoiseLaVille | STRITER")));
        onView(withId(R.id.text_article))
                .check(matches(withText(startsWith("Ce soir, j’ai pu retourner sur les bancs de l’école"))));
        onView(withId(R.id.author))
                .check(matches(withText(startsWith("Kiudee"))));
    }

    @Test
    public void transitionToExperience() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Retour sur l’expérience “The Turnament” (FR) | #STRITER")), click()));
        onView(withId(R.id.title_article))
                .check(matches(withText("Retour sur l’expérience “The Turnament” (FR) | #STRITER")));
        onView(withId(R.id.text_article))
                .check(matches(withText(startsWith("Ce Lundi 23 Mai, soit juste le lendemain de mon retour en France"))));
        onView(withId(R.id.author))
                .check(matches(withText(startsWith("Kiudee"))));
    }

    // VIDEOS
    @Test
    public void transitionToCercle() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Cercle Underground 2016 - Showcase - The Kartel")), click()));
        onView(withId(R.id.video_title))
                .check(matches(withText("Cercle Underground 2016 - Showcase - The Kartel")));
        onView(withId(R.id.video_desc))
                .check(matches(withText(startsWith("Hagson présente ..."))));
    }

    @Test
    public void transitionToKantyn() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Kantyn x PNL #LaFrenchTouch")), click()));
        onView(withId(R.id.video_title))
                .check(matches(withText("Kantyn x PNL #LaFrenchTouch")));
        onView(withId(R.id.video_desc))
                .check(matches(withText("La nouvelle vidéo de Kantyn SaGraille")));
    }

    @Test
    public void transitionToAnthologie() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Un battle d'anthologie")), click()));
        onView(withId(R.id.video_title))
                .check(matches(withText("Un battle d'anthologie")));
        onView(withId(R.id.video_desc))
                .check(matches(withText("Bruce Ykanji & Gator VS Nelson & Franqey")));
    }

    @Test
    public void transitionToAnissa() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Anissa x Lefa #LaFrenchTouch")), click()));
        onView(withId(R.id.video_title))
                .check(matches(withText(startsWith("Anissa x Lefa #LaFrenchTouch"))));
        onView(withId(R.id.video_desc))
                .check(matches(withText(startsWith("#5"))));
    }

    @Test
    public void transitionToJerems() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText(startsWith("Maître Gims"))), click()));
        onView(withId(R.id.video_title))
                .check(matches(withText(startsWith("Maître Gims"))));
        onView(withId(R.id.video_desc))
                .check(matches(withText(startsWith("#LePopCestLaVie"))));
    }

    //EVENTS
    @Test
    public void transitionToCoursDeDanse() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Cours de danse")), click()));
        onView(withId(R.id.name_event))
                .check(matches(withText("Cours de danse")));
        onView(withId(R.id.date_event))
                .check(matches(withText("le 17 juin 2016 à 11:18")));
        onView(withId(R.id.place))
                .check(matches(withText("EPITA")));
        onView(withId(R.id.organizer))
                .check(matches(withText("Organisé par :Ruben Moutot")));
        onView(withId(R.id.description))
                .check(matches(withText("Premier cours de danse.")));
    }


    @Test
    public void transitionToJusteDebout() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Juste Debout 2017")), click()));
        onView(withId(R.id.name_event))
                .check(matches(withText("Juste Debout 2017")));
        onView(withId(R.id.date_event))
                .check(matches(withText("le 03 mars 2017 à 14:00")));
        onView(withId(R.id.place))
                .check(matches(withText("AccorHotel Arena")));
        onView(withId(R.id.organizer))
                .check(matches(withText("Bruce Ykanji")));
        onView(withId(R.id.description))
                .check(matches(withText(startsWith("Le Juste Debout est une rencontre internationale de danses Hip Hop"))));
    }


    @Test
    public void transitionToPopping() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Popping Choreo Workshop")), click()));
        onView(withId(R.id.name_event))
                .check(matches(withText("Popping Choreo Workshop")));
        onView(withId(R.id.date_event))
                .check(matches(withText("le 22 juin 2016 à 20:30")));
        onView(withId(R.id.place))
                .check(matches(withText("14 rue Nicolau, 93400 Saint-Ouen, Ile-De-France, France")));
        onView(withId(R.id.organizer))
                .check(matches(withText("Pleyel City Beast")));
        onView(withId(R.id.description))
                .check(matches(withText(startsWith("Nelson nous fera l'honneur d'être parmi nous"))));
    }

    @Test
    public void transitionToReady() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("WAR Battle - 1vs1 Popping & HipHop - by Ready Or Not")), click()));
        onView(withId(R.id.name_event))
                .check(matches(withText("WAR Battle - 1vs1 Popping & HipHop - by Ready Or Not")));
        onView(withId(R.id.date_event))
                .check(matches(withText("le 25 juin 2016 à 13:00")));
        onView(withId(R.id.place))
                .check(matches(withText("MJC Savigny Sur Orge : 12 Grande rue, 91600 Savigny-sur-Orge")));
        onView(withId(R.id.organizer))
                .check(matches(withText("Ready Or Not - RON")));
        onView(withId(R.id.description))
                .check(matches(withText(startsWith("[ENGLISH BELOW] Ready Or Not Présente le W.A.R "))));
    }
}
