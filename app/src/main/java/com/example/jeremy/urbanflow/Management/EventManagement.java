package com.example.jeremy.urbanflow.Management;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.example.jeremy.urbanflow.Beans.Event;
import com.example.jeremy.urbanflow.R;
import com.example.jeremy.urbanflow.Server.Server;
import com.example.jeremy.urbanflow.Server.ServerListener;
import com.example.jeremy.urbanflow.Utils.DateUtils;
import com.example.jeremy.urbanflow.View.ElementsFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ruben on 15/06/16.
 */
public class EventManagement {
    private static List<Event> eventList;
    private static List<Map<String, String>> data;

    public static List<Event> getEvents(FragmentManager fm){
        if (eventList == null)
            return getEventsFromServer(fm);
        else
            return eventList;
    }

    public static void clean(){
        eventList = null;
    }

    private static List<Event> getEventsFromServer(final FragmentManager fm){
        data = new ArrayList<>();
        eventList = new ArrayList<>();
        Server.serverGetEvents(new ServerListener() {
            @Override
            public void onSuccess(JSONObject response) {
                LinkedHashMap<String, Float> result = new LinkedHashMap<>();
                try {
                    JSONArray events = response.getJSONArray("event");
                    HashMap<String, String> item;

                    for (int i = 0; i < events.length(); ++i) {
                        JSONObject event = events.getJSONObject(i);
                        item = new HashMap<>();
                        item.put("id", String.valueOf(event.getInt("id")));
                        item.put("title", event.getString("title"));
                        item.put("organizer", event.getString("organizer"));
                        item.put("eventDate", event.getString("event_date"));
                        item.put("place", event.getString("place"));
                        item.put("description", event.getString("descriptipn"));
                        item.put("image", event.getString("image"));
                        item.put("date", event.getString("created_at"));
                        data.add(item);
                    }

                    for (Map<String, String> it : data) {
                        Date date = DateUtils.strToDate(it.get("date"));
                        Log.d("DATE", String.valueOf(date));
                        Date edate = DateUtils.strToDate(it.get("eventDate"));
                        Log.d("EVENT", String.valueOf(edate));
                        Event event = new Event(it.get("title"), it.get("image"), it.get("description"), date, it.get("organizer"), edate, it.get("place"));
                        eventList.add(event);
                    }

                    FragmentTransaction transaction = fm.beginTransaction();
                    ElementsFragment elementsFragment = new ElementsFragment();
                    transaction.replace(R.id.main_content, elementsFragment);
                    transaction.commit();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError() {
            }
        });
        return eventList;
    }
}
