package com.example.jeremy.urbanflow.YouTube;

import android.content.Context;
import android.util.Log;

import com.example.jeremy.urbanflow.Beans.Video;
import com.example.jeremy.urbanflow.R;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.IOUtils;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jeremy on 16/06/2016.
 */
public class YoutubeConnector {
    private final String TAG = "YC";
    private YouTube youtube;
    private YouTube.Search.List query;
    public static final String KEY =
            "AIzaSyBFAqnGJxCLSOP2Q0qPjF424szPqvpTook";

    public YoutubeConnector(String appname) {
        youtube = new YouTube.Builder(new NetHttpTransport(),
                new JacksonFactory(),
                new HttpRequestInitializer() {
                    @Override
                    public void initialize(HttpRequest hr) throws IOException {}
                }).setApplicationName(appname).build();

        try{

            query = youtube.search().list("id,snippet");
            query.setKey(KEY);
            query.setType("video");
            query.setFields("items(id/videoId,snippet/title,snippet/description,snippet/thumbnails/default/url)");

        }catch(IOException e){
            Log.d(TAG, "Could not initialize: "+e);
        }
    }

    public Video search(String url, Video video){
        String id = getId(url);
        query.setQ(id);

        try{
            SearchListResponse response = query.execute();
            List<SearchResult> results = response.getItems();

            video.setVideoTitle(results.get(0).getSnippet().getTitle());
            video.setVideoDescription(results.get(0).getSnippet().getDescription());
            video.setThumbnailURL(results.get(0).getSnippet().getThumbnails().getDefault().getUrl());
            video.setId(results.get(0).getId().getVideoId());
            return video;
        }catch(IOException e){
            Log.d(TAG, "Could not search: "+e);
            return null;
        }
    }

    public static String getId(String url) {
        String pattern = "(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(url);

        Log.d("YouTube", url);

        if(matcher.find()){
            Log.d("YouTube", matcher.group());
            return matcher.group();
        }

        return "";
    }

    public static String getTitle(String youtubeUrl) {
        try {
            if (youtubeUrl != null) {
                URL embededURL = new URL("http://www.youtube.com/oembed?url=" +
                        youtubeUrl + "&format=json"
                );
                Log.d("TITLE", embededURL.toString());
                JSONObject jsonObject = readJsonFromUrl(embededURL.toString());
                return jsonObject.getString("title");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }


    public static String getThumbnail(String id)
    {
        return "https://img.youtube.com/vi/" + id + "/0.jpg";
    }
}
