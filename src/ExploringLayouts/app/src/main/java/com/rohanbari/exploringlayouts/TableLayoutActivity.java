package com.rohanbari.exploringlayouts;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rohanbari.exploringlayouts.databinding.ActivityTableLayoutBinding;

public class TableLayoutActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        ActivityTableLayoutBinding binding = ActivityTableLayoutBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
    }
}
