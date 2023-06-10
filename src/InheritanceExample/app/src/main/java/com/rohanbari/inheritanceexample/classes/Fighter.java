package com.rohanbari.inheritanceexample.classes;

import android.util.Log;

public class Fighter extends AlienShip {

    private static final String TAG = "Fighter";

    public Fighter() {
        super("FIGHTER", 500);
        Log.d(TAG, "Fighter: constructed!");
    }

    @Override
    public void fireWeapon() {
        Log.d(TAG, "fireWeapon: Firing with lasers!");
    }
}
