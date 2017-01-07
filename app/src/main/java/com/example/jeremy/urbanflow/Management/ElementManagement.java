package com.example.jeremy.urbanflow.Management;


import android.support.v4.app.FragmentManager;

import com.example.jeremy.urbanflow.Beans.Article;
import com.example.jeremy.urbanflow.Beans.Element;
import com.example.jeremy.urbanflow.Beans.Event;
import com.example.jeremy.urbanflow.Beans.Video;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by Ruben on 16/06/16.
 */
public class ElementManagement {

    public static boolean articleLoaded;
    public static boolean eventLoaded;
    public static boolean videoLoaded;

    public static void init(FragmentManager fm){
        ArticleManagement.getArticles();
        VideoManagement.getVideos();
        EventManagement.getEvents(fm);
    }

    public static void clean(){
        ArticleManagement.clean();
        VideoManagement.clean();
        EventManagement.clean();
    }

    public static List<Element> getElements(FragmentManager fm){

        List<Element> elements = new ArrayList<>();

        elements.add(new Article("Welcome to UrbanFlow",
                "https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-388606.png",
                "The new app", new Date(), "Docvuja", "Bienvenue sur la nouvelle application de " +
                "référence de la culture urbaine. Vous y retrouverez toute l'actualité du monde " +
                "hip hop : vidéo, articles, évènements\n\nPEACE, LOVE, UNITY & HAVIN' FUN"));

        for (Article a: ArticleManagement.getArticles()
                ) {
            elements.add(a);
        }

        for (Video v: VideoManagement.getVideos()
                ) {
            elements.add(v);
        }

        for (Event e: EventManagement.getEvents(fm)
                ) {
            elements.add(e);
        }

        Collections.sort(elements, new Comparator<Element>() {
            @Override
            public int compare(Element lhs, Element rhs) {
                return rhs.getDate().compareTo(lhs.getDate());
            }
        });
        return elements;
    }

}
