package com.rohanbari.exploringlayouts;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rohanbari.exploringlayouts.databinding.ActivityConstraintLayoutBinding;

public class ConstraintLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ActivityConstraintLayoutBinding binding = ActivityConstraintLayoutBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.calendarView.setOnDateChangeListener(
                (calendarView, i, i1, i2) -> Toast.makeText(getApplicationContext(),
                        "You have changed the date.",
                        Toast.LENGTH_SHORT).show());
    }
}
