package com.rohanbari.counterappexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.rohanbari.counterappexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private int counter = 1;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.buttonCounter.setOnClickListener(v -> executeCounter());
    }

    void executeCounter() {
        String output = "You pressed " + counter + " time" + ((counter == 1) ? "!" : "s!");
        binding.textView.setText(output);

        counter++;
    }
}