package com.example.jeremy.urbanflow;

import com.example.jeremy.urbanflow.Beans.Element;
import com.example.jeremy.urbanflow.Beans.Video;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

/**
 * Created by Ashley on 06/01/2017.
 */

public class VideoUnitTest {
    public static final String EXPECTED_VIDEOTITLE = "Kantyn x PNL #LaFrenchTouch";
    public static final String EXPECTED_VIDEODESCRIPTION = "La nouvelle vidéo de Kantyn SaGraille";
    public static final String EXPECTED_URL = "https://www.youtube.com/watch?v=CtgLYGVligA";
    private Video videoEmpty;
    private Video videoSetFull;

    @Before
    public void setUp() throws Exception {
        videoSetFull = new Video();
        videoSetFull.setVideoTitle("Kantyn x PNL #LaFrenchTouch");
        videoSetFull.setVideoDescription("La nouvelle vidéo de Kantyn SaGraille");
        videoSetFull.setThumbnailURL("https://www.youtube.com/watch?v=CtgLYGVligA");

        videoEmpty = new Video();
    }

    @Test
    public void testVideoEmpty() throws Exception {
        Assert.assertNotNull(videoEmpty);
        Assert.assertNull(videoEmpty.getTitle());
        Assert.assertNull(videoEmpty.getImage());
        Assert.assertNull(videoEmpty.getDescription());
        Assert.assertNull(videoEmpty.getDate());
        Assert.assertNull(videoEmpty.getVideoTitle());
        Assert.assertNull(videoEmpty.getVideoDescription());
        Assert.assertNull(videoEmpty.getId());
        Assert.assertNull(videoEmpty.getThumbnailURL());
    }

    @Test
    public void testVideoSetFull() throws Exception {
        Assert.assertNotNull(videoSetFull);
        Assert.assertNull(videoSetFull.getTitle());
        Assert.assertNull(videoSetFull.getImage());
        Assert.assertNull(videoSetFull.getDescription());
        Assert.assertNull(videoSetFull.getDate());
        Assert.assertEquals(EXPECTED_VIDEOTITLE  , videoSetFull.getVideoTitle());
        Assert.assertEquals(EXPECTED_VIDEODESCRIPTION, videoSetFull.getVideoDescription());
        Assert.assertNull(videoSetFull.getId());
        Assert.assertEquals(EXPECTED_URL, videoSetFull.getThumbnailURL());
    }
}
