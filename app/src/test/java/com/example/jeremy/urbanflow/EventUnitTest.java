package com.example.jeremy.urbanflow;

import com.example.jeremy.urbanflow.Beans.Article;
import com.example.jeremy.urbanflow.Beans.Event;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Ashley on 06/01/2017.
 */

public class EventUnitTest {
    public static final String EXPECTED_TITLE = "Juste debout 2017";
    public static final String EXPECTED_IMAGE = "http://www.ambafrance-cn.org/IMG/arton19832.jpg?1404463140";
    public static final String EXPECTED_DESCRIPTION = "Le Juste Debout est une rencontre internationale de danses Hip Hop dites « debout », qui réunit plus de 4 000 danseurs, sélectionnés après une tournée internationale de deux mois. Six grandes disciplines y sont représentées: Locking, Popping, Hip Hop New style, House, Expérimental et Dancehall. Depuis 2012, le Juste Debout fait salle comble à Bercy (nouvellement renommé AccorHotels Arena), rassemblant plus de 16 000 spectateurs venus du monde entier. Découvrez l’histoire du Juste Debout dans l’article ci-dessous! http://www.juste-debout.com/juste-debout-story/";
    public static final String EXPECTED_ORGANIZER = "Bruce Ykanji";
    public static final Date EXPECTED_EVENTDATE = new GregorianCalendar(2017, 3, 3).getTime();
    public static final String EXPECTED_PLACE = "AccorHotel Arena";
    private Event eventFull;
    private Event eventEmpty;

    @Before
    public void setUp() throws Exception {
        eventFull = new Event("Juste debout 2017", "http://www.ambafrance-cn.org/IMG/arton19832.jpg?1404463140",
                "Le Juste Debout est une rencontre internationale de danses Hip Hop dites « debout », qui réunit plus de 4 000 danseurs, sélectionnés après une tournée internationale de deux mois. Six grandes disciplines y sont représentées: Locking, Popping, Hip Hop New style, House, Expérimental et Dancehall. Depuis 2012, le Juste Debout fait salle comble à Bercy (nouvellement renommé AccorHotels Arena), rassemblant plus de 16 000 spectateurs venus du monde entier. Découvrez l’histoire du Juste Debout dans l’article ci-dessous! http://www.juste-debout.com/juste-debout-story/",
                null, "Bruce Ykanji", new GregorianCalendar(2017, 3, 3).getTime(), "AccorHotel Arena");

        eventEmpty = new Event(null, null, null, null, null, null, null);
    }

    @Test
    public void testEventFull() throws Exception {
        Assert.assertNotNull(eventFull);
        Assert.assertEquals(EXPECTED_TITLE  , eventFull.getTitle());
        Assert.assertEquals(EXPECTED_IMAGE, eventFull.getImage());
        Assert.assertEquals(EXPECTED_DESCRIPTION, eventFull.getDescription());
        Assert.assertNull(eventFull.getDate());
        Assert.assertEquals(EXPECTED_ORGANIZER, eventFull.getOrganizer());
        Assert.assertEquals(EXPECTED_EVENTDATE, eventFull.getEventDate());
        Assert.assertEquals(EXPECTED_PLACE, eventFull.getPlace());
    }

    @Test
    public void testEventEmpty() throws Exception {
        Assert.assertNotNull(eventEmpty);
        Assert.assertNull(eventEmpty.getTitle());
        Assert.assertNull(eventEmpty.getImage());
        Assert.assertNull(eventEmpty.getDescription());
        Assert.assertNull(eventEmpty.getDate());
        Assert.assertNull(eventEmpty.getOrganizer());
        Assert.assertNull(eventEmpty.getEventDate());
        Assert.assertNull(eventEmpty.getPlace());
    }
}
