package com.example.jeremy.urbanflow.View;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jeremy.urbanflow.Beans.Element;
import com.example.jeremy.urbanflow.R;
import com.google.api.client.util.Collections2;
import com.google.api.client.util.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jeremy on 14/06/2016.
 */
public class ElementAdapter extends RecyclerView.Adapter<ElementViewHolder> {
    private static final String TAG = "ElementAdapter";

    private List<Element> elements;

    public ElementAdapter(List<Element> elements) {
        this.elements = elements;
    }

    @Override
    public ElementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_cards,parent,false);
        return new ElementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ElementViewHolder holder, int position) {
        Log.d(TAG, "Element " + position + " set.");
        Element element = elements.get(position);
        holder.bind(element);
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    public void setFilter(List<Element> e) {
        elements = new ArrayList<>();
        elements.addAll(e);
        notifyDataSetChanged();
    }
}
