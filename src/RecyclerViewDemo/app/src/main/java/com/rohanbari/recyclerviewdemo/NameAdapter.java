package com.rohanbari.recyclerviewdemo;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rohanbari.recyclerviewdemo.databinding.ItemNameBinding;

import java.util.ArrayList;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.ViewHolder> {
    private final ArrayList<Name> names;

    public NameAdapter(ArrayList<Name> names) {
        this.names = names;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNameBinding binding = ItemNameBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getBinding().textView.setText(names.get(position).getName());
        holder.getBinding().cardView.setOnClickListener(v ->
                new AlertDialog.Builder(holder.getBinding().getRoot().getContext())
                        .setTitle(names.get(position).getName())
                        .setMessage("Congratulations! You are selected by the user.")
                        .setPositiveButton("Close",
                                (dialogInterface, i) -> dialogInterface.cancel()).show());
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemNameBinding mBinding;

        public ViewHolder(ItemNameBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public ItemNameBinding getBinding() {
            return mBinding;
        }
    }
}
