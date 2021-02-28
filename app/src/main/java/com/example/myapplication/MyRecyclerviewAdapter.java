package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerviewAdapter extends RecyclerView.Adapter<MyRecyclerviewAdapter.ViewHolder> {

    private List<String> arrayStr = new ArrayList<>();
    private Context context;

    public MyRecyclerviewAdapter(Context context) {
        this.context = context;
        initData();
    }

    private void initData() {
        arrayStr.add("------1-------");
        arrayStr.add("------2-------");
        arrayStr.add("------3-------");
        arrayStr.add("------4-------");
        arrayStr.add("------5-------");
        arrayStr.add("------6-------");
        arrayStr.add("------7-------");
        arrayStr.add("------8-------");
        arrayStr.add("------9-------");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sub, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String str = arrayStr.get(position);
        holder.textView.setText(str);
    }

    @Override
    public int getItemCount() {
        return arrayStr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
