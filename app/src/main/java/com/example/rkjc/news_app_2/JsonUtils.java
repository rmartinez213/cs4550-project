package com.example.rkjc.news_app_2;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import org.json.*;

import static android.content.ContentValues.TAG;

public class JsonUtils {



    public static ArrayList<NewsItem> parseNews(String JSONString){

        //ArrayList object to store the JSON strings
        ArrayList<NewsItem> NewsItemArrayList = new ArrayList<NewsItem>();


        try {

            //Parsing JSON string to object
            JSONObject Jobject = new JSONObject(JSONString);

            //Parsing the JSON object to a JSON array
            JSONArray Jarray = Jobject.getJSONArray("entries");

            //Add the following to the ArrayList object
            for(int i = 0 ; i < Jarray.length() ; i++){
                NewsItemArrayList.add(new NewsItem(Jarray.getJSONObject(i).getString("title"), Jarray.getJSONObject(i).getString("body"), Jarray.getJSONObject(i).getString("image"), Jarray.getJSONObject(i).getString("time")));
            }
        }
        catch (JSONException e){
            Log.d("TAG", e.toString());
        }


        return NewsItemArrayList;
    }

}