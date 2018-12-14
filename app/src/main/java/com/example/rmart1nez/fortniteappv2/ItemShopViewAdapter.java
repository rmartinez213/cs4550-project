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


public class ItemShopViewAdapter extends RecyclerView.Adapter<ItemShopViewAdapter.NewsViewHolder> {

    Context mContext;
    ArrayList<ItemShopAL> itemShopALS;

    public ItemShopViewAdapter(Context context, ArrayList<ItemShopAL> newsItems){
        this.mContext = context;
        this.itemShopALS = newsItems;
    }

    //Creates it's context and instantiates View (for displaying as a UI)
    @Override
    public ItemShopViewAdapter.NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(R.layout.activity_main_2_cardview, parent, shouldAttachToParentImmediately);
        NewsViewHolder viewHolder = new NewsViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void  onBindViewHolder(ItemShopViewAdapter.NewsViewHolder holder, int position){
        holder.bind(position);
    }

    @Override
    public int getItemCount(){
        return itemShopALS.size();
    }


    public class NewsViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name;
        TextView rarity;
        TextView storeCategory;
        TextView vBucks;

        //Instantiated views now have set view
        public NewsViewHolder(View itemView){
            super(itemView);

            //imageView with Picasso
            imageView = (ImageView) itemView.findViewById(R.id.item_shop_imageView);

            name = (TextView) itemView.findViewById(R.id.item_shop_name);
            rarity = (TextView) itemView.findViewById(R.id.item_shop_rarity);
            storeCategory = (TextView) itemView.findViewById(R.id.item_shop_storeCategory);
            vBucks = (TextView) itemView.findViewById(R.id.item_shop_vBucks);

        }

        //bind the texts with their views
        void bind(final int listIndex){

            Picasso.get().load(itemShopALS.get(listIndex).getImageURL()).fit().into(imageView);
            name.setText(itemShopALS.get(listIndex).getName());
            rarity.setText(itemShopALS.get(listIndex).getRarity());
            storeCategory.setText(itemShopALS.get(listIndex).getStoreCategory());
            vBucks.setText(itemShopALS.get(listIndex).getvBucks() + " vBucks");


        }
    }
}