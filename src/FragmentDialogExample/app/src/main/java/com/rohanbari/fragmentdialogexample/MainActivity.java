package com.rohanbari.fragmentdialogexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.rohanbari.fragmentdialogexample.classes.CustomDialog;
import com.rohanbari.fragmentdialogexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(v -> createDialog());
    }

    void createDialog() {
        CustomDialog customDialog = new CustomDialog();
        customDialog.show(getSupportFragmentManager(), TAG);
    }
}