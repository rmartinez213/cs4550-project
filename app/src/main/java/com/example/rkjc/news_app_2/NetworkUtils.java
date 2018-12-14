package com.example.rkjc.news_app_2;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class NetworkUtils{

    final static String endpointNews = "https://fortnite-public-api.theapinetwork.com/prod09/br_motd/get";

    final static String key = "TRN-Api-Key";
    final static String value = "60955cfd-dd2a-43dd-82ca-af2164e30e2f";


    //Builds the URL for calling the API
    public static URL buildURL(){
        Uri builtUri = Uri.parse(endpointNews).buildUpon()
                .appendQueryParameter(key, value)
                .build();

        URL url = null;

        try{
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        //System.out.println(url.toString());
        Log.d("TAG", url.toString());


        return url;
    }


    //Connects by opening a connection with the url and returns the text
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try{
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();

            if(hasInput)
                return scanner.next();

            else
                return null;
        } finally {
            urlConnection.disconnect();
        }
    }
}

