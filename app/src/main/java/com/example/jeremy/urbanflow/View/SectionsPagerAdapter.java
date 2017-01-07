package com.example.jeremy.urbanflow.View;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.jeremy.urbanflow.Beans.Article;
import com.example.jeremy.urbanflow.Beans.Element;
import com.example.jeremy.urbanflow.Beans.Event;
import com.example.jeremy.urbanflow.Beans.Video;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeremy on 15/06/2016.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> listFragment;
    private List<Element> elements;

    public SectionsPagerAdapter(FragmentManager fm, List<Element> elements) {
        super(fm);
        this.elements = elements;
        init();
    }

    public void init()
    {
        DateFormat simpleFormat = new SimpleDateFormat("'le' dd MMMM yyyy 'à' HH:mm");
        listFragment = new ArrayList<>();
        for (Element o : elements) {
            if (o instanceof Article) {
                ArticleFragment fragment =
                        ArticleFragment.newInstance(o.getImage(),
                                o.getTitle(),
                                ((Article) o).getText(),
                                ((Article) o).getAuthor());
                listFragment.add(fragment);
            }
            else if (o instanceof Event)
            {
                EventFragment fragment =
                        EventFragment.newInstance(o.getImage(),
                                o.getTitle(),
                                ((Event) o).getPlace(),
                                simpleFormat.format(((Event) o).getEventDate()),
                                ((Event) o).getOrganizer(),
                                o.getDescription());
                listFragment.add(fragment);
            }
            else if (o instanceof Video)
            {
                VideoFragment fragment = VideoFragment.newInstance(((Video) o).getId(),
                        o.getTitle(),
                        o.getDescription(),
                        ((Video) o).getThumbnailURL());
                listFragment.add(fragment);
            }
        }
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }


}
