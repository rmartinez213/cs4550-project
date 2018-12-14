package com.example.rmart1nez.fortniteapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtilsItemShop {


    public static ArrayList<ItemShopAL> parseItemShop(String JSONString) {

        //ArrayList object to store the JSON strings
        ArrayList<ItemShopAL> ItemShopArrayList = new ArrayList<ItemShopAL>();


        try {

            //Parsing JSON string to object
            //JSONObject Jobject = new JSONObject(JSONString);

            //Parsing the JSON object to a JSON array
            JSONArray Jarray = new JSONArray(JSONString);


            //Add the following to the ArrayList object
            for (int i = 0; i < Jarray.length(); i++) {
                JSONObject jsonObject = Jarray.getJSONObject(i);
                ItemShopArrayList.add(new ItemShopAL(jsonObject.getString("imageUrl"), jsonObject.getString("name"), jsonObject.getString("rarity"), jsonObject.getString("storeCategory"), jsonObject.getInt("vBucks")));
            }
        } catch (JSONException e) {
            Log.d("TAG error", e.toString());
        }
        Log.d("TAG (IN JsonUtilsItemShop): ", ItemShopArrayList.size() + "");

        return ItemShopArrayList;
    }
}
