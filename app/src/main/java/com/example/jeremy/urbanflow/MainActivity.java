package com.example.jeremy.urbanflow;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.example.jeremy.urbanflow.Management.ElementManagement;
import com.example.jeremy.urbanflow.View.ElementsFragment;

import java.util.List;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        if (savedInstanceState != null) {
            return;
        }

        ElementManagement.clean();
        ElementManagement.init(getSupportFragmentManager());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        //MenuItem searchItem = menu.findItem(R.id.search);
        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        // Do not iconify the widget; expand it by default
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.menu_about:
                Intent intent = new Intent(MainActivity.this, CreditActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {


        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        ElementsFragment fragment = new ElementsFragment();
        for (Fragment f:fragments
                ) {
            Log.d("MainActivity", "fragment");
            if (f instanceof ElementsFragment)
                fragment = (ElementsFragment) f;
        }

        if (fragment != null && fragment.getElements() != null) {
            Log.d("MainActivity", "not null");
            fragment.setFilter(newText);
        }
        return true;
    }
}
