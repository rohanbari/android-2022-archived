package com.rohanbari.googlelogindemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.rohanbari.googlelogindemo.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

        Glide.with(this).load(R.drawable.google_logo).into(binding.imageLogo);
    }
}