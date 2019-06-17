package com.kit.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kit.myapplication.databinding.ViewMainBinding;

import io.realm.RealmResults;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private RealmResults<MainItem> results;

    public MainAdapter(RealmResults<MainItem> data) {
        results = data;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_main, parent, false);
        return new MainViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        MainItem item = results.get(position);
        holder.getBinding().content.setText(item.getContent());
        holder.getBinding().date.setText(item.getDate());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        private ViewMainBinding binding;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public ViewMainBinding getBinding() {
            return binding;
        }
    }
}
