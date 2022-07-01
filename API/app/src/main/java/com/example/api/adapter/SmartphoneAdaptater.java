package com.example.api.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api.R;
import com.example.api.model.Smartphone;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SmartphoneAdaptater extends RecyclerView.Adapter<SmartphoneViewHolder> {
    Context context;
    List<Smartphone> list;

    public SmartphoneAdaptater(Context context, List<Smartphone> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SmartphoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_smartphone,parent,false);
        return new SmartphoneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SmartphoneViewHolder holder, int position) {
        holder.t1.setText(list.get(position).getMarque());
        holder.t2.setText(String.valueOf(list.get(position).getPrix()));
        Picasso.with(context).load(list.get(position).getImageURL()).placeholder(R.drawable.load).into(holder.img);
        

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
