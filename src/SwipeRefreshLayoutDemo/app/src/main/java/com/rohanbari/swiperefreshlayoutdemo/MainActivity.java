package com.rohanbari.swiperefreshlayoutdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.rohanbari.swiperefreshlayoutdemo.databinding.ActivityMainBinding;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.swipeRefresh.setOnRefreshListener(
                () -> {
                    updateOperation();
                    binding.swipeRefresh.setRefreshing(false);
                }
        );
    }

    /**
     * Performs the refresh request operation.
     */
    void updateOperation() {
        String output = "Refresh time: " + new Date();
        binding.textView.setText(output);
    }
}