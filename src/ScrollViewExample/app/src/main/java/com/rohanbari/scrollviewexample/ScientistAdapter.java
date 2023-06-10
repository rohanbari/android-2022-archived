package com.rohanbari.scrollviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.rohanbari.scrollviewexample.databinding.ItemScientistBinding;

import java.util.ArrayList;

public class ScientistAdapter extends BaseAdapter {
    Context context;
    ArrayList<Scientist> scientists;

    public ScientistAdapter(Context context, ArrayList<Scientist> scientists) {
        this.context = context;
        this.scientists = scientists;
    }

    @Override
    public int getCount() {
        return scientists.size();
    }

    @Override
    public Object getItem(int i) {
        return scientists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemScientistBinding binding =
                ItemScientistBinding.inflate(LayoutInflater.from(context),
                        viewGroup,
                        false);
        Scientist scientist = scientists.get(i);

        binding.image.setImageResource(scientist.getImage());
        binding.textViewHeader.setText(scientist.getName());
        binding.textViewBody.setText(scientist.getDescription());

        return binding.getRoot();
    }
}
