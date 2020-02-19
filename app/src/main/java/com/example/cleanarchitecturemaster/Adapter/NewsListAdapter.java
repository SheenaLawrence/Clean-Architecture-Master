package com.example.cleanarchitecturemaster.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cleanarchitecturemaster.Model.NewsRes;
import com.example.cleanarchitecturemaster.Model.Row;
import com.example.cleanarchitecturemaster.R;

import java.util.ArrayList;
import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.MyViewHolder> {

    private Context context;
    private List<Row> list =new ArrayList<>();

    public NewsListAdapter(Context context, List<Row> newslist)
    {
        this.context=context;
        this.list=newslist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.newsHeadingText.setText(list.get(position).getTitle());
        holder.newsText.setText(list.get(position).getDescription());

        Glide.with(context).load(list.get(position).getImageHref()).into(holder.newsImage);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView newsHeadingText,newsText;
        ImageView newsImage;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            newsHeadingText=(TextView)itemView.findViewById(R.id.newsHaedingtextview);
            newsText=(TextView)itemView.findViewById(R.id.newstextView);
            newsImage=(ImageView)itemView.findViewById(R.id.newsImage);
        }
    }

}
