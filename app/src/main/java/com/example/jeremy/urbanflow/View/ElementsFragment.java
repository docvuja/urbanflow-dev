package com.example.jeremy.urbanflow.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jeremy.urbanflow.Beans.Article;
import com.example.jeremy.urbanflow.Beans.Element;
import com.example.jeremy.urbanflow.Management.ElementManagement;
import com.example.jeremy.urbanflow.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeremy on 14/06/2016.
 */
public class ElementsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private List<Element> elements;
    private ElementAdapter adapter;

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        elements = ElementManagement.getElements(getFragmentManager());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.elements_fragment, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ElementAdapter(elements);
        mRecyclerView.setAdapter(adapter);

        return rootView;
    }

    public void setFilter(String name)
    {
        name = name.toLowerCase();
        final List<Element> filter = new ArrayList<>();
        for (Element e: elements) {
            final String title = e.getTitle().toLowerCase();
            if (title.contains(name))
                filter.add(e);
        }
        adapter.setFilter(filter);
    }
}
