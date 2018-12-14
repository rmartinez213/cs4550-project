package com.example.rmart1nez.fortniteapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ItemShop extends Fragment {

//    Context mContext;
//    ArrayList<ItemShopAL> itemShopALS;
//
//    public ItemShop(Context context, ArrayList<ItemShopAL> itemShopALS){
//        this.mContext = context;
//        this.itemShopALS = itemShopALS;
//    }
//
//    @Override
//    public ItemShop. onCreateViewHolder(ViewGroup parent, int viewType){
//
//    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_shop, container,false);
    }
}
