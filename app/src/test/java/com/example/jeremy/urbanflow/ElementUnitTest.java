package com.example.jeremy.urbanflow;

import com.example.jeremy.urbanflow.Beans.Article;
import com.example.jeremy.urbanflow.Beans.Element;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Ashley on 06/01/2017.
 */

public class ElementUnitTest {
    public static final String EXPECTED_TITLE = "Retour sur la conférence-débat de @NoiseLaVille";
    public static final String EXPECTED_IMAGE = "image1.jpg";
    public static final String EXPECTED_DESCRIPTION = "Ce soir, j’ai pu retourner sur les bancs de l’école (que j’ai quitté récemment, je vous rassure) en venant assister à une conférence-débat au sein de Sciences Po." ;
    public static final Date EXPECTED_DATE = new GregorianCalendar(2016, 2, 12).getTime();
    private Element elementFull;
    private Element elementEmpty;
    private Element elementSetFull;

    @Before
    public void setUp() throws Exception {
        elementFull = new Element("Retour sur la conférence-débat de @NoiseLaVille", "image1.jpg", "Ce soir, j’ai pu retourner sur les bancs de l’école (que j’ai quitté récemment, je vous rassure) en venant assister à une conférence-débat au sein de Sciences Po.",
                new GregorianCalendar(2016, 2, 12).getTime());

        elementEmpty = new Element();

        elementSetFull = new Element();
        elementSetFull.setTitle("Retour sur la conférence-débat de @NoiseLaVille");
        elementSetFull.setImage("image1.jpg");
        elementSetFull.setDate(new GregorianCalendar(2016, 2, 12).getTime());
        elementSetFull.setDescription("Ce soir, j’ai pu retourner sur les bancs de l’école (que j’ai quitté récemment, je vous rassure) en venant assister à une conférence-débat au sein de Sciences Po.");
    }

    @Test
    public void testElementFull() throws Exception {
        Assert.assertNotNull(elementFull);
        Assert.assertEquals(EXPECTED_TITLE  , elementFull.getTitle());
        Assert.assertEquals(EXPECTED_IMAGE, elementFull.getImage());
        Assert.assertEquals(EXPECTED_DESCRIPTION, elementFull.getDescription());
        Assert.assertEquals(EXPECTED_DATE, elementFull.getDate());
    }

    @Test
    public void testElementEmpty() throws Exception {
        Assert.assertNotNull(elementEmpty);
        Assert.assertNull(elementEmpty.getTitle());
        Assert.assertNull(elementEmpty.getImage());
        Assert.assertNull(elementEmpty.getDescription());
        Assert.assertNull(elementEmpty.getDate());
    }

    @Test
    public void testElementSetFull() throws Exception {
        Assert.assertNotNull(elementSetFull);
        Assert.assertEquals(EXPECTED_TITLE  , elementSetFull.getTitle());
        Assert.assertEquals(EXPECTED_IMAGE, elementSetFull.getImage());
        Assert.assertEquals(EXPECTED_DESCRIPTION, elementSetFull.getDescription());
        Assert.assertEquals(EXPECTED_DATE, elementSetFull.getDate());
    }
}
