package com.example.jeremy.urbanflow.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeremy.urbanflow.R;
import com.example.jeremy.urbanflow.YouTube.YoutubeConnector;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.squareup.picasso.Picasso;

/**
 * Created by Jeremy on 16/06/2016.
 */
public class VideoFragment extends Fragment implements YouTubePlayer.OnInitializedListener {
    private TextView mTitle;
    private TextView mDescription;
    private ImageView mImageView;
    private YouTubePlayerSupportFragment youtubePlayerFragment;
    private YouTubePlayer yPlayer;

    private final static String ARG_ID = "id";
    private final static String ARG_TITLE = "title";
    private final static String ARG_DESC = "desc";
    private final static String ARG_THUMBNAIL = "thumbnail";

    private String id;
    private String title;
    private String desc;
    private String thumbnail;

    public static VideoFragment newInstance(String id, String title, String desc, String thumbnail)
    {
        VideoFragment fragment = new VideoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ID, id);
        args.putString(ARG_TITLE, title);
        args.putString(ARG_DESC, desc);
        args.putString(ARG_THUMBNAIL, thumbnail);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.id = getArguments().getString(ARG_ID);
        this.title = getArguments().getString(ARG_TITLE);
        this.desc = getArguments().getString(ARG_DESC);
        this.thumbnail = getArguments().getString(ARG_THUMBNAIL);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.youtube_fragment, container, false);

        mTitle = (TextView) rootView.findViewById(R.id.video_title);
        mDescription = (TextView) rootView.findViewById(R.id.video_desc);
        //mImageView = (ImageView) rootView.findViewById(R.id.play);


        youtubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
        youtubePlayerFragment.initialize(YoutubeConnector.KEY, this);
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.youtube_fragment, youtubePlayerFragment);
        fragmentTransaction.commit();

        //Picasso.with(mImageView.getContext()).load(thumbnail).centerCrop().fit().into(mImageView);
        /*mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });*/

        mTitle.setText(title);
        mDescription.setText(desc);

        return rootView;
    }

    public void play()
    {

        if (yPlayer != null)
        {
        }
        youtubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
        youtubePlayerFragment.initialize(YoutubeConnector.KEY, this);
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.youtube_fragment, youtubePlayerFragment);
        fragmentTransaction.commit();
        //mImageView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if(!b){
            yPlayer = youTubePlayer;
            yPlayer.cueVideo(id);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(getActivity(),"fail",Toast.LENGTH_SHORT).show();
    }


    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            youtubePlayerFragment.initialize(YoutubeConnector.KEY, this);
        }
    }*/



    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        Log.d("VideoFragment", "Enter" + id);
        super.setUserVisibleHint(isVisibleToUser);
        if (!isVisibleToUser && yPlayer != null) {
            yPlayer.release();
            Log.d("VideoFragment", "Release");
        }

        if (isVisibleToUser && youtubePlayerFragment != null) {
            youtubePlayerFragment.initialize(YoutubeConnector.KEY,this);
            Log.d("VideoFragment", "Init" + id);
        }
    }
}
