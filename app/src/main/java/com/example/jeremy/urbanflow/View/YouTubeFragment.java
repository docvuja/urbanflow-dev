package com.example.jeremy.urbanflow.View;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jeremy.urbanflow.R;
import com.example.jeremy.urbanflow.YouTube.YoutubeConnector;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by Jeremy on 16/06/2016.
 */
public class YouTubeFragment extends YouTubePlayerSupportFragment implements YouTubePlayer.OnInitializedListener{
    private YouTubePlayerView activePlayer;
    private static String ARG_ID = "id";

    public static YouTubeFragment newInstance(String id)
    {
        YouTubeFragment fragment = new YouTubeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View rooView = layoutInflater.inflate(R.layout.youtube_fragment, viewGroup, false);
        //activePlayer =  rooView.findViewById(R.id.youtube_fragment);
        //activePlayer.initialize(YoutubeConnector.KEY, this);
        return rooView;
    }


    /*public void init(){
        initialize(YoutubeConnector.KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                activePlayer = youTubePlayer;
                Log.d("YOUTUBE", "Successfully initialized");
                activePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                if (!b) {
                    activePlayer.cueVideo(getArguments().getString(ARG_ID));
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.e("YOUTUBE", youTubeInitializationResult.toString());
            }
        });
    }*/

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean restored) {
        if(!restored){
            player.cueVideo(getArguments().getString(ARG_ID));
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Log.e("YOUTUBE", youTubeInitializationResult.toString());
    }
}
