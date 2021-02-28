package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> arrayStr = new ArrayList<>();
    private Context context;

    private MyRecyclerviewAdapter myRecyclerviewAdapter;
    private LinearLayoutManager linearLayoutManager;

    public MyAdapter(Context context) {
        this.context = context;
        initData();
    }

    private void initData() {
        arrayStr.add("------A-------");
        arrayStr.add("------B-------");
        arrayStr.add("------C-------");
        arrayStr.add("------D-------");
        arrayStr.add("------E-------");
        arrayStr.add("------F-------");
        arrayStr.add("------G-------");
        arrayStr.add("------H-------");
        arrayStr.add("------I-------");
        arrayStr.add("------J-------");
        arrayStr.add("------K-------");
        arrayStr.add("------L-------");
        arrayStr.add("------M-------");
        arrayStr.add("------N-------");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_my, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String str = arrayStr.get(position);
        holder.textView.setText(str);

        if (null == myRecyclerviewAdapter) {
            myRecyclerviewAdapter = new MyRecyclerviewAdapter(context);
        }
//        if (null == linearLayoutManager) {
//            linearLayoutManager = new LinearLayoutManager(context);
//        }
//        holder.recyclerView.setLayoutManager(linearLayoutManager);
        holder.recyclerView.setAdapter(myRecyclerviewAdapter);
    }

    @Override
    public int getItemCount() {
        return arrayStr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            recyclerView = itemView.findViewById(R.id.recyclerView);
        }
    }
}
