package com.centaurus.volleyapiexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.centaurus.volleyapiexample.databinding.ItemPostBinding;

import java.util.List;

public class PostAdapter extends BaseAdapter {
    private final List<Post> posts;
    private final Context context;

    public PostAdapter(List<Post> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Post post = posts.get(position);
        ItemPostBinding itemPostBinding = ItemPostBinding.inflate(LayoutInflater.from(context), parent, false);

        itemPostBinding.textUserId.setText(String.valueOf(post.getUserId()));
        itemPostBinding.textId.setText(String.valueOf(post.getId()));
        itemPostBinding.textTitle.setText(post.getTitle());
        itemPostBinding.textBody.setText(post.getBody());

        return itemPostBinding.getRoot();
    }
}
