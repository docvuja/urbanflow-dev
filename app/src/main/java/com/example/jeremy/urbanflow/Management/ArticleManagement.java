package com.example.jeremy.urbanflow.Management;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.jeremy.urbanflow.Beans.Article;
import com.example.jeremy.urbanflow.Beans.Element;
import com.example.jeremy.urbanflow.Server.Server;
import com.example.jeremy.urbanflow.Server.ServerListener;
import com.example.jeremy.urbanflow.Utils.DateUtils;
import com.example.jeremy.urbanflow.View.ElementAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ruben on 15/06/16.
 */
public class ArticleManagement {

    private static List<Article> articleList;
    private static List<Map<String, String>> data;

    public static List<Article> getArticles(){
        if (articleList == null)
            return getArticlesFromServer();
        else
            return articleList;
    }

    public static void clean(){
        articleList = null;
    }

    private static List<Article> getArticlesFromServer(){
        data = new ArrayList<>();
        articleList = new ArrayList<>();
        Server.serverGetArticles(new ServerListener() {
            @Override
            public void onSuccess(JSONObject response) {
                LinkedHashMap<String, Float> result = new LinkedHashMap<>();
                try {
                    JSONArray articles = response.getJSONArray("article");
                    HashMap<String, String> item;

                    for (int i = 0; i < articles.length(); ++i) {
                        JSONObject article = articles.getJSONObject(i);
                        item = new HashMap<>();
                        item.put("id", String.valueOf(article.getInt("id")));
                        item.put("title", article.getString("title"));
                        item.put("author", article.getString("author"));
                        item.put("text", article.getString("text"));
                        item.put("description", article.getString("descriptipn"));
                        item.put("image", article.getString("image"));
                        item.put("date", article.getString("created_at"));
                        data.add(item);
                    }
                    for (Map<String, String> it : data) {
                        Date date = DateUtils.strToDate(it.get("date"));
                        Log.d("DATE", String.valueOf(date));
                        Article article = new Article(it.get("title"), it.get("image"), it.get("description"), date, it.get("author"), it.get("text"));
                        articleList.add(article);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError() {
            }
        });
        return articleList;
    }
}
