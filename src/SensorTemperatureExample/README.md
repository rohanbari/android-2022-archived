# SensorTemperatureExample

To work with the Sensor Framework, the following declarations are made:

```java
private SensorManager sensorManager;
private Sensor sensorTemperature;
```

The first declaration manages to access the sensor services from the Android
system. On the other hand, the second one is the specific requirement asked by
the programmer.

Let's move on. In the following code segment:

```java
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
```

The `onResume` and `onPause` Android lifecycles are overriden to unregister the
sensor listeners in order to minimize the performance issues. Now, I have to
initialize the sensor manager and the sensor itself this way:

```java
sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
sensorTemperature = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
```

The first line initializes the first class member field, which is a requisite
for the second to access the specific sensor. The to-do is yet to be done. Still,
the base is ready to be shown in public, so no issues.

In the following lines:

```java
if (sensorTemperature == null) {
    // TYPE_AMBIENT_TEMPERATURE does not exist!
    Log.e(TAG, "updateTemperature: The temperature sensor does not exist!");
    Toast.makeText(getApplicationContext(),
            "Your device does not support Temperature Sensor.",
            Toast.LENGTH_SHORT).show();
}
```

We are examining whether the Android device supports the thermal sensor or not.
It is an important step to avoid unwanted run-time errors in the future.

Lastly, let us have a look at the last lines:

```java
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
```

Both the methods belongs to the implementation of the `SensorEventListener`.
Nothing special work is assigned to the second method, it is kept for debugging
purposes only. In the first method, when the sensor is changed, it is triggered
to update the `textView` widget.
