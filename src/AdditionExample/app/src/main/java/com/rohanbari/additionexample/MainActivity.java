package com.rohanbari.additionexample;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.result);
        editText1 = findViewById(R.id.text1);
        editText2 = findViewById(R.id.text2);
    }

    public void addition(View view) {
        double result = Double.parseDouble(editText1.getText().toString()) + Double.parseDouble(editText2.getText().toString());
        textView.setText(String.format(Locale.ENGLISH, "The result is: %s", result));
    }
}