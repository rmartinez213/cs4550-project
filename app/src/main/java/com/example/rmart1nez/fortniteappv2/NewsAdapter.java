package com.example.rmart1nez.fortniteappv2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.rmart1nez.fortniteappv2.ItemShopAL;
import com.example.rmart1nez.fortniteappv2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    Context mContext;
    List<NewsItem> newsitem;

    public NewsAdapter(Context context, List<NewsItem> newsItems){
        this.mContext = context;
        this.newsitem = newsItems;
    }

    //Creates it's context and instantiates View (for displaying as a UI)
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(R.layout.activity_main_news_cardview, parent, shouldAttachToParentImmediately);
        NewsViewHolder viewHolder = new NewsViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void  onBindViewHolder(NewsAdapter.NewsViewHolder holder, int position){
        holder.bind(position);
    }

    @Override
    public int getItemCount(){
        return newsitem.size();
    }


    public class NewsViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title;
        TextView body;
        TextView time;

        //Instantiated views now have set view
        public NewsViewHolder(View itemView){
            super(itemView);

            //imageView with Picasso
            imageView = (ImageView) itemView.findViewById(R.id.image);

            title = (TextView) itemView.findViewById(R.id.title);
            body = (TextView) itemView.findViewById(R.id.body);
            time = (TextView) itemView.findViewById(R.id.time);


        }

        //bind the texts with their views
        void bind(final int listIndex){

            Picasso.get().load(newsitem.get(listIndex).getmImage()).fit().into(imageView);
            title.setText(newsitem.get(listIndex).getmTitle());
            body.setText(newsitem.get(listIndex).getmBody());
            time.setText(newsitem.get(listIndex).getmTime());


        }
    }
}