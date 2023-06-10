package com.rohanbari.scrollviewexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.rohanbari.scrollviewexample.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int MAX_CARDS = 10;
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        ArrayList<Scientist> scientists = new ArrayList<>();

        // Making ten instances of the CardView using the adapter
        for (int i = 0; i < MAX_CARDS; i++) {
            scientists.add(new Scientist(R.drawable.nikola_tesla_wireless,
                    "Nikola Tesla",
                    getString(R.string.text_teslaInfo)));
        }

        ScientistAdapter adapter = new ScientistAdapter(this, scientists);
        binding.listView.setAdapter(adapter);
    }
}