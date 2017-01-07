package com.example.jeremy.urbanflow.Management;

import android.util.Log;

import com.example.jeremy.urbanflow.Beans.Video;
import com.example.jeremy.urbanflow.MainActivity;
import com.example.jeremy.urbanflow.R;
import com.example.jeremy.urbanflow.Server.Server;
import com.example.jeremy.urbanflow.Server.ServerListener;
import com.example.jeremy.urbanflow.Utils.DateUtils;
import com.example.jeremy.urbanflow.YouTube.YoutubeConnector;
import com.google.common.io.Resources;

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
public class VideoManagement {

    private static List<Video> videoList;
    private static List<Map<String, String>> data;

    public static List<Video> getVideos(){
        if (videoList == null)
            return getVideosFromServer();
        else
            return videoList;
    }

    public static void clean(){
        videoList = null;
    }

    private static List<Video> getVideosFromServer(){
        data = new ArrayList<>();
        videoList = new ArrayList<>();
        Server.serverGetVideos(new ServerListener() {
            @Override
            public void onSuccess(JSONObject response) {
                LinkedHashMap<String, Float> result = new LinkedHashMap<>();
                try {
                    JSONArray videos = response.getJSONArray("video");
                    HashMap<String, String> item;

                    for (int i = 0; i < videos.length(); ++i) {
                        JSONObject video = videos.getJSONObject(i);
                        item = new HashMap<>();
                        item.put("id", String.valueOf(video.getInt("id")));
                        item.put("title", video.getString("title"));
                        item.put("description", video.getString("description"));
                        item.put("url", video.getString("url"));
                        item.put("date", video.getString("created_at"));
                        data.add(item);
                    }

                    for (final Map<String, String> it : data) {
                        Date date = DateUtils.strToDate(it.get("date"));
                        Log.d("DATE", String.valueOf(date));
                        String id = YoutubeConnector.getId(it.get("url"));
                        String thumbnail = YoutubeConnector.getThumbnail(id);
                        String title = YoutubeConnector.getTitle(it.get("url"));

                        final Video video = new Video(it.get("title"), thumbnail, it.get("description"), date);
                        video.setId(id);
                        video.setVideoTitle(title);

                        Log.d("VIDEO", video.getId());

                        videoList.add(video);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError() {
            }
        });
        return videoList;
    }
}
