package com.rohanbari.inheritanceexample.classes;

import android.util.Log;

public abstract class AlienShip {
    private static final String TAG = "AlienShip";
    private static int numberShips;

    private String shipName;
    private int strength;

    public AlienShip(String shipName, int strength) {
        this.shipName = shipName;
        this.strength = strength;

        numberShips++;

        Log.d(TAG, "AlienShip: constructed!");
    }

    public static int getNumberShips() {
        return numberShips;
    }

    public static void setNumberShips(int numberShips) {
        AlienShip.numberShips = numberShips;
    }

    public abstract void fireWeapon();

    public void hitDetected() {
        Log.d(TAG, "hitDetected: Boom!");

        this.strength -= 25;

        if (this.strength == 0) {
            destroyShip();
        }
    }

    protected void destroyShip() {
        numberShips--;
        Log.d(TAG, "destroyShip: Ship " + this.shipName + " exploded!");
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
