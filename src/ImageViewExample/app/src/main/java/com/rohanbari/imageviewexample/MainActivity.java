package com.rohanbari.imageviewexample;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final int[] images = new int[]{R.drawable.greece, R.drawable.san_francisco, R.drawable.indiana};
    private final String[] location = new String[]{"Greece", "San Francisco", "Indiana"};
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image);
    }

    public void shuffleImage(View view) {
        int id = images[new Random().nextInt(images.length)];
        Glide.with(this).load(id).into(imageView);

        textView = findViewById(R.id.locationLabel);

        if (id == R.drawable.greece) {
            textView.setText(location[0]);
        } else if (id == R.drawable.san_francisco) {
            textView.setText(location[1]);
        } else {
            textView.setText(location[2]);
        }

        imageView.setCropToPadding(true);
    }
}