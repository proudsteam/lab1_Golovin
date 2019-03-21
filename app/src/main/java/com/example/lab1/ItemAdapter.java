package com.example.lab1;

import android.content.ClipData;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    ArrayList<item> items;

    public ItemAdapter (ArrayList<item> items) {
        this.items = items;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView num;
        public ItemViewHolder (View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.logo);
            num = (TextView) view.findViewById(R.id.numb);
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.num.setText(items.get(position).getNumber());
        //holder.img.setImageResource(items.get(position).getImg());
        if(position % 2 == 0)
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        else holder.itemView.setBackgroundColor(Color.parseColor("#CCCCCC"));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
