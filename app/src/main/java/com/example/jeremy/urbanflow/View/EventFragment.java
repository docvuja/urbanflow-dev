package com.example.jeremy.urbanflow.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jeremy.urbanflow.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Jeremy on 15/06/2016.
 */
public class EventFragment extends Fragment {
    private ImageView mImageView;
    private TextView mName;
    private TextView mPlace;
    private TextView mDate;
    private TextView mOrga;
    private TextView mDetails;

    private static final String ARG_IMAGE = "image";
    private static final String ARG_NAME = "name";
    private static final String ARG_PLACE = "place";
    private static final String ARG_DATE = "date";
    private static final String ARG_ORGA = "orga";
    private static final String ARG_DETAILS = "details";

    private String image;
    private String name;
    private String place;
    private String date;
    private String orga;
    private String details;

    public static EventFragment newInstance(String image, String name, String place, String date, String orga, String detalis){
        EventFragment fragment = new EventFragment();
        Bundle args = new Bundle();
        args.putString(ARG_IMAGE,image);
        args.putString(ARG_NAME, name);
        args.putString(ARG_PLACE, place);
        args.putString(ARG_DATE, date);
        args.putString(ARG_ORGA, orga);
        args.putString(ARG_DETAILS, detalis);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.image = getArguments().getString(ARG_IMAGE);
        this.name = getArguments().getString(ARG_NAME);
        this.place = getArguments().getString(ARG_PLACE);
        this.date = getArguments().getString(ARG_DATE);
        this.orga = getArguments().getString(ARG_ORGA);
        this.details = getArguments().getString(ARG_DETAILS);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.event_fragment, container, false);

        mImageView = (ImageView) rootView.findViewById(R.id.image_event);
        mName = (TextView) rootView.findViewById(R.id.name_event);
        mPlace = (TextView) rootView.findViewById(R.id.place);
        mDate = (TextView) rootView.findViewById(R.id.date_event);
        mOrga = (TextView) rootView.findViewById(R.id.organizer);
        mDetails = (TextView) rootView.findViewById(R.id.description);

        Picasso.with(mImageView.getContext()).load(image).centerCrop().fit().into(mImageView);
        mName.setText(name);
        mPlace.setText(place);
        mDate.setText(date);
        mOrga.setText(mOrga.getText());
        mOrga.append(orga);
        mDetails.setText(details);

        return rootView;
    }

    public ImageView getmImageView() {
        return mImageView;
    }
}
