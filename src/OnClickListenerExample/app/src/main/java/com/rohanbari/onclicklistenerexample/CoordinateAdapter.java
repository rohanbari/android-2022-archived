package com.rohanbari.onclicklistenerexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.rohanbari.onclicklistenerexample.databinding.ItemCoordinateBinding;

import java.util.ArrayList;

public class CoordinateAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<Coordinate> coordinates;
    private final OnClickListener onClickListener;

    public CoordinateAdapter(Context context,
                             ArrayList<Coordinate> coordinates,
                             OnClickListener onClickListener) {
        this.context = context;
        this.coordinates = coordinates;
        this.onClickListener = onClickListener;
    }

    @Override
    public int getCount() {
        return coordinates.size();
    }

    @Override
    public Object getItem(int i) {
        return coordinates.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemCoordinateBinding binding = ItemCoordinateBinding
                .inflate(LayoutInflater.from(context), viewGroup, false);
        Coordinate coordinate = coordinates.get(i);

        binding.textCX.setText(String.valueOf(coordinate.getX()));
        binding.textCY.setText(String.valueOf(coordinate.getY()));
        
        binding.getRoot().setOnClickListener(v -> onClickListener.onItemClicked(coordinate));

        return binding.getRoot();
    }
}
