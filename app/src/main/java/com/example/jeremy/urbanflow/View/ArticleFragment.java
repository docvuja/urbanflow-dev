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
public class ArticleFragment extends Fragment {
    private ImageView mImageView;
    private TextView mTitle;
    private TextView mText;
    private TextView mAuthor;

    private static final String ARG_IMAGE = "image";
    private static final String ARG_TITLE = "title";
    private static final String ARG_TEXT = "text";
    private static final String ARG_AUTHOR = "author";

    private String image;
    private String title;
    private String text;
    private String author;

    public static ArticleFragment newInstance(String image, String title, String text, String author)
    {
        ArticleFragment fragment = new ArticleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_IMAGE, image);
        args.putString(ARG_TITLE, title);
        args.putString(ARG_TEXT, text);
        args.putString(ARG_AUTHOR, author);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.image = getArguments().getString(ARG_IMAGE);
        this.title = getArguments().getString(ARG_TITLE);
        this.text = getArguments().getString(ARG_TEXT);
        this.author = getArguments().getString(ARG_AUTHOR);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.article_fragment, container, false);
        mImageView = (ImageView) rootView.findViewById(R.id.image_article);
        mTitle = (TextView) rootView.findViewById(R.id.title_article);
        mText = (TextView) rootView.findViewById(R.id.text_article);
        mAuthor = (TextView) rootView.findViewById(R.id.author);

        Picasso.with(mImageView.getContext()).load(image).centerCrop().fit().into(mImageView);
        mTitle.setText(title);
        mText.setText(text);
        mAuthor.setText(author);

        return rootView;
    }

    public ImageView getmImageView() {
        return mImageView;
    }
}
