package com.rohanbari.onclicklistenerexample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.rohanbari.onclicklistenerexample.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        ArrayList<Coordinate> coordinates = new ArrayList<>();

        coordinates.add(new Coordinate(10, 20));
        coordinates.add(new Coordinate(20, 40));
        coordinates.add(new Coordinate(60, 80));

        CoordinateAdapter adapter = new CoordinateAdapter(this, coordinates, this);
        binding.listView.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(Coordinate coordinate) {
        Log.d(TAG, "onItemClicked: (" + coordinate.getX() + " " + coordinate.getY() + ")");
    }
}