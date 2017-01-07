package com.example.jeremy.urbanflow.Beans;

import android.content.res.Resources;

import com.example.jeremy.urbanflow.R;

import java.util.Date;

/**
 * Created by Jeremy on 14/06/2016.
 */
public class Article extends Element {
    private String Author;
    private String Text;

    public Article(String title, String image, String description, Date date, String author, String text) {
        super(title, image, description, date);
        Author = author;
        Text = text;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    @Override
    public String toString() {
        String res = String.format("%s \n\n%s : %s \n\n%s",
                getTitle(),
                "Écrit par",
                Author,
                Text);
        return res;
    }
}
