package com.rohanbari.runtimeobjectcreation;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.rohanbari.runtimeobjectcreation.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.buttonMain.setOnClickListener(v -> createNewButton());
    }

    void createNewButton() {
        Button button = new Button(this);

        String output = "New Button " + counter++;
        button.setText(output);

        button.setOnClickListener(v -> createNewButton());

        binding.getRoot().addView(button);
    }
}