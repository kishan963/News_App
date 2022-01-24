package com.example.newapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    ArrayList<ModelClass> modelClassArrayList;

    public MyAdapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
        ViewHolder viewHolder=new MyAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        ((MyAdapter.ViewHolder)holder).textView.setText(modelClassArrayList.get(position).getTitle());
        ((ViewHolder)holder).source.setText(modelClassArrayList.get(position).getSource_id());
        ((ViewHolder)holder).time.setText(modelClassArrayList.get(position).getPublishedAt().substring(0,10));
         Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(((MyAdapter.ViewHolder)holder).imageView);


    }



    @Override
    public int getItemCount() {
        return modelClassArrayList.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView,source,time;
        ImageView imageView;
        CardView cardView;
        public ViewHolder( View itemView) {
            super(itemView);
            textView= (TextView)itemView.findViewById(R.id.textView);
            imageView=itemView.findViewById(R.id.imageView);
            cardView=(CardView)itemView.findViewById(R.id.cardView);
            source=itemView.findViewById(R.id.source);
            time=itemView.findViewById(R.id.time);


        }
    }
}
