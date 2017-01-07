package com.example.jeremy.urbanflow.View;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jeremy.urbanflow.Beans.Article;
import com.example.jeremy.urbanflow.Beans.Element;
import com.example.jeremy.urbanflow.Beans.Event;
import com.example.jeremy.urbanflow.Beans.Video;
import com.example.jeremy.urbanflow.PagerActivity;
import com.example.jeremy.urbanflow.R;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Jeremy on 14/06/2016.
 */
public class ElementViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "ElementViewHolder";

    private final String EXTRA_POSITION = "EXTRA_POSITION";
    private final String EXTRA_TITLE = "EXTRA_TITLE";

    private TextView mTextView;
    private ImageView mImageView;
    private TextView mDateView;
    private ImageView mIndex;

    public ElementViewHolder(final View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Element " + getPosition() + " clicked.");
                Context context = v.getContext();
                Intent intent = new Intent(context, PagerActivity.class);
                //intent.putExtra(EXTRA_POSITION, getPosition());
                intent.putExtra(EXTRA_TITLE, mTextView.getText());
                context.startActivity(intent);
            }
        });
        mTextView = (TextView) itemView.findViewById(R.id.text_card);
        mImageView = (ImageView) itemView.findViewById(R.id.image_card);
        mDateView = (TextView) itemView.findViewById(R.id.date_post);
        mIndex = (ImageView) itemView.findViewById(R.id.index);
    }

    public void bind(Element element){
        mTextView.setText(element.getTitle());
        mTextView.setBackgroundColor(Color.alpha(0));
        SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateTimeInstance(
                DateFormat.SHORT,
                DateFormat.SHORT);
        mDateView.setText(format.format(element.getDate()));

        Picasso.with(mImageView.getContext()).load(element.getImage()).centerCrop().fit().into(mImageView);
        if (element instanceof Article)
            mIndex.setBackgroundColor(Color.parseColor("#00A0B0"));
        else if (element instanceof Video)
            mIndex.setBackgroundColor(Color.parseColor("#F0A830"));
        else if (element instanceof Event)
            mIndex.setBackgroundColor(Color.parseColor("#CC333F"));
    }

}
