package com.rohanbari.exploringlayouts;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.rohanbari.exploringlayouts.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.buttonConV.setOnClickListener(v -> {
            Intent intent = new Intent(this, ConstraintLayoutActivity.class);
            startActivity(intent);
        });

        binding.buttonTabV.setOnClickListener(v -> {
            Intent intent = new Intent(this, TableLayoutActivity.class);
            startActivity(intent);
        });
    }
}