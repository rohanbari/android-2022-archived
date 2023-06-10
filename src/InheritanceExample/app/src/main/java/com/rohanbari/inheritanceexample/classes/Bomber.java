package com.rohanbari.inheritanceexample.classes;

import android.util.Log;

public class Bomber extends AlienShip {
    private static final String TAG = "Bomber";

    public Bomber() {
        super("Bomber", 100);
        Log.d(TAG, "Bomber: constructed!");
    }

    @Override
    public void fireWeapon() {
        Log.d(TAG, "fireWeapon: Firing weapon! Bombs away...");
    }
}
