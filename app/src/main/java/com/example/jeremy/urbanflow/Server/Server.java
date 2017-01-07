package com.example.jeremy.urbanflow.Server;

import android.os.AsyncTask;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;


/**
 * Created by Ruben on 14/06/16.
 */
public class Server {

    private static String server = "https://urbanflow.herokuapp.com/api";



    public static void serverGetVideos(ServerListener listener) {
        sendServerRequest(null, false, "/getVideos", listener);
    }

    public static void serverGetArticles(ServerListener listener) {
        sendServerRequest(null, false, "/getArticles", listener);
    }

    public static void serverGetEvents(ServerListener listener) {
        sendServerRequest(null, false, "/getEvents", listener);
    }

    public static void sendServerRequest(JSONObject jsonObject, final Boolean postRequest, final String request, final ServerListener listener) {

        new AsyncTask<JSONObject, Void, JSONObject>(){
            int responseCode = 0;

            @Override
            protected JSONObject doInBackground(JSONObject... params) {
                JSONObject result = null;
                try {
                    URL url = new URL(server + request);

                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                    if (postRequest)
                        urlConnection.setRequestProperty("Content-Type", "application/json");

                    if (postRequest)
                        urlConnection.setDoOutput(true);

                    urlConnection.setConnectTimeout(3000);
                    urlConnection.setChunkedStreamingMode(0);
                    urlConnection.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
                    urlConnection.setRequestProperty("Accept-Charset", "UTF-8");
                    urlConnection.setRequestProperty("Accept-Encoding", "identity");
                    urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");

                    try {

                        if (postRequest) {
                            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8");
                            out.write(params[0].toString());
                            out.flush();
                        }

                        responseCode = urlConnection.getResponseCode();

                        InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream(), "utf-8");
                        BufferedReader in = new BufferedReader(isr);

                        String inputLine;
                        String res = "";
                        while ((inputLine = in.readLine()) != null) {
                            res += inputLine;
                        }

                        result = new JSONObject(res);

                        isr.close();
                        in.close();

                    } finally {
                        urlConnection.disconnect();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return result;
            }

            @Override
            protected void onPostExecute(JSONObject result) {
                if (listener != null && responseCode == 200)
                    listener.onSuccess(result);
                else if (listener != null)
                    listener.onError();
            }
        }.execute(jsonObject);

    }

    // Comment l'utiliser:

    // Data stored here : private List<Map<String, String>> data;

    /*
    data = new ArrayList<>();
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

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError() {
            }
        });
    */

}
