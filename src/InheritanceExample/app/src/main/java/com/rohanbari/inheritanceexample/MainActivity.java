package com.rohanbari.inheritanceexample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.rohanbari.inheritanceexample.classes.Bomber;
import com.rohanbari.inheritanceexample.classes.Fighter;
import com.rohanbari.inheritanceexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(v -> experiment());
    }

    /**
     * All the main code goes here.
     */
    void experiment() {
        Fighter fighter = new Fighter();
        Bomber bomber = new Bomber();

        Log.i("fighter Shield:", "Life " + fighter.getStrength());
        Log.i("bomber Shield:", "Life " + bomber.getStrength());

        bomber.fireWeapon();
        fighter.fireWeapon();

        bomber.hitDetected();
        bomber.hitDetected();
        bomber.hitDetected();
        bomber.hitDetected();
    }
}