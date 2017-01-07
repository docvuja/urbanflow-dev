package com.example.jeremy.urbanflow;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.jeremy.urbanflow.Beans.Element;
import com.example.jeremy.urbanflow.Management.ElementManagement;
import com.example.jeremy.urbanflow.View.ArticleFragment;
import com.example.jeremy.urbanflow.View.EventFragment;
import com.example.jeremy.urbanflow.View.SectionsPagerAdapter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeremy on 15/06/2016.
 */
public class PagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private final String EXTRA_POSITION = "EXTRA_POSITION";
    private final String EXTRA_TITLE = "EXTRA_TITLE";
    private List<Element> elements = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_viewpager);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), elements);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setOffscreenPageLimit(0);
        if (mViewPager != null)
            mViewPager.setAdapter(mSectionsPagerAdapter);

        Intent intent = getIntent();
        if (intent != null)
        {
            //int position = intent.getIntExtra(EXTRA_POSITION, 0);
            String title = intent.getStringExtra(EXTRA_TITLE);
            int position = getPosition(title);
            if (position != -1)
                mViewPager.setCurrentItem(position);
        }
    }

    public void init() {
        elements = ElementManagement.getElements(getSupportFragmentManager());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pager_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_share) {
            int itemId = mViewPager.getCurrentItem();
            Element element = elements.get(itemId);
            Fragment fragment = mSectionsPagerAdapter.getItem(itemId);

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, element.toString());


            if (fragment instanceof ArticleFragment) {
                ImageView imageView = ((ArticleFragment) fragment).getmImageView();
                Uri bmpUri = getLocalBitmapUri(imageView);
                if (bmpUri != null)
                {
                    sendIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
                    sendIntent.setType("image/*");
                }
            }
            else if (fragment instanceof EventFragment)
            {
                ImageView imageView = ((EventFragment) fragment).getmImageView();
                Uri bmpUri = getLocalBitmapUri(imageView);
                if (bmpUri != null)
                {
                    sendIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
                    sendIntent.setType("image/*");
                }
            }
            else
                sendIntent.setType("text/plain");

            sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


    public Uri getLocalBitmapUri(ImageView imageView) {
        // Extract Bitmap from ImageView drawable
        Drawable drawable = imageView.getDrawable();
        Bitmap bmp = null;
        if (drawable instanceof BitmapDrawable){
            bmp = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        } else {
            return null;
        }
        // Store image to default external storage directory
        Uri bmpUri = null;
        try {
            File file =  new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "share_image_" + System.currentTimeMillis() + ".png");
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.close();
            bmpUri = Uri.fromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmpUri;
    }

    public int getPosition(String title)
    {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getTitle().equals(title))
                return i;
        }
        Log.d("Pager", "fail");
        return -1;
    }
}
