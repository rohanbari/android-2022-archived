package com.rohanbari.retrofitapidemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.rohanbari.retrofitapidemo.databinding.ItemRepoBinding;
import com.rohanbari.retrofitapidemo.models.Repo;

import java.util.List;

public class RepoAdapter extends BaseAdapter {
    private final Context context;
    private final List<Repo> repoList;

    public RepoAdapter(Context context, List<Repo> repoList) {
        this.context = context;
        this.repoList = repoList;
    }

    @Override
    public int getCount() {
        return repoList.size();
    }

    @Override
    public Object getItem(int position) {
        return repoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemRepoBinding binding = ItemRepoBinding.inflate(LayoutInflater.from(context), parent, false);
        Repo repo = repoList.get(position);

        binding.itemRepoName.setText(repo.getName());
        binding.itemRepoDescription.setText(repo.getDescription());

        binding.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(repo.getHtmlUrl()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(intent);
        });

        return binding.getRoot();
    }
}
