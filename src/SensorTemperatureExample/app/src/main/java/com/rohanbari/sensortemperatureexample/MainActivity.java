package com.rohanbari.sensortemperatureexample;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rohanbari.sensortemperatureexample.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private static final String TAG = "MainActivity";

    private ActivityMainBinding binding;
    private SensorManager sensorManager;
    private Sensor sensorTemperature;

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorTemperature, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorTemperature = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        // TODO: 2/5/22 Get the TYPE_AMBIENT_TEMPERATURE sensor details
        binding.swipeWidget.setOnRefreshListener(this::updateTemperature);
    }

    void updateTemperature() {
        // Initializing the SensorManager object by getting the SENSOR_SERVICE from the system
        if (sensorTemperature == null) {
            // TYPE_AMBIENT_TEMPERATURE does not exist!
            Log.e(TAG, "updateTemperature: The temperature sensor does not exist!");
            Toast.makeText(getApplicationContext(),
                    "Your device does not support Temperature Sensor.",
                    Toast.LENGTH_SHORT).show();
        }

        // TYPE_AMBIENT_TEMPERATURE exists and ready to use...
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        double temperature = sensorEvent.values[0];
        String output = "The ambient temperature right now is " +
                String.format(Locale.ENGLISH, "%.2f", temperature);

        binding.textView.setText(output);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        // When the Sensor has its accuracy changed
        Log.d(TAG, "onSensorChanged: Accuracy changed to " + i + "!");
    }
}