package com.example.appzero;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private List<String> data;
    private LayoutInflater inflater;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, List<String> data) {
        System.out.println("HAHA"+context);
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }
    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }
    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String list = data.get(position);
        holder.textView.setText(list);
    }
    // total number of rows
    @Override
    public int getItemCount() {
        return data.size();
    }
    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            return;
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return data.get(id);
    }
}