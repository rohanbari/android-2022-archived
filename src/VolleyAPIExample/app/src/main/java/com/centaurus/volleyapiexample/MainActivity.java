package com.centaurus.volleyapiexample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.centaurus.volleyapiexample.databinding.ActivityMainBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    private PostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        getPosts();
    }

    private void getPosts() {
        RequestQueue queue = Volley.newRequestQueue(this);
        final String URL = "https://jsonplaceholder.typicode.com/posts/";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL,
                response -> {
                    try {
                        List<Post> postList = new ArrayList<>();

                        for (int index = 0; index < response.length(); index++) {
                            JSONObject object = (JSONObject) response.get(index);
                            Post post = new Post(Integer.parseInt(object.get("userId").toString()),
                                    Integer.parseInt(object.get("id").toString()),
                                    String.valueOf(object.get("title")),
                                    String.valueOf(object.get("body"))
                            );

                            postList.add(post);
                        }
                        adapter = new PostAdapter(postList, this);
                        binding.listView.setAdapter(adapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> Log.d(TAG, "Error while fetching response."));

        queue.add(jsonArrayRequest);
    }
}