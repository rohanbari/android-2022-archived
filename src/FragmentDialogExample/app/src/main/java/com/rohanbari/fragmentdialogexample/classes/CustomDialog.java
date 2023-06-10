package com.rohanbari.fragmentdialogexample.classes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class CustomDialog extends DialogFragment {

    private static final String TAG = "CustomDialog";

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("You have to make a choice.")
                .setPositiveButton("Positive", (dialogInterface, i) -> {
                    // Positive button is clicked
                    Log.d(TAG, "onCreateDialog: Clicked Positive button!");
                })
                .setNegativeButton("Negative", ((dialogInterface, i) -> {
                    // Negative button is clicked
                    Log.d(TAG, "onCreateDialog: Clicked Negative button!");
                }));

        return builder.create();
    }
}
