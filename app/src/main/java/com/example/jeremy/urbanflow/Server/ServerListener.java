package com.example.jeremy.urbanflow.Server;

import org.json.JSONObject;

/**
 * Created by Ruben on 14/06/16.
 */
public interface ServerListener {

    void onSuccess(JSONObject result);

    void onError();
}