package com.rohanbari.recyclerviewdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.rohanbari.recyclerviewdemo.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        ArrayList<Name> names = new ArrayList<>();

        names.add(new Name("John Doe"));
        names.add(new Name("William Anderson"));
        names.add(new Name("Alex Pina"));
        names.add(new Name("Rohan Bari"));

        NameAdapter adapter = new NameAdapter(names);
        binding.recyclerView.setAdapter(adapter);
    }
}