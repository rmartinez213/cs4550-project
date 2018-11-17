package com.example.rmart1nez.fortniteapp;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {

    /**************************************/
    /********** API URL Endpoint **********/
    /**************************************/

    final static String endpointStats = "https://api.fortnitetracker.com/v1/profile"; //https://api.fortnitetracker.com/v1/profile/{platform}/{epic-nickname}
    final static String endpointMatchHistory =  "https://api.fortnitetracker.com/v1/profile/account"; //https://api.fortnitetracker.com/v1/profile/account/{accountId}/matches
    final static String endpointItemShop = "https://api.fortnitetracker.com/v1/store";
    final static String endpointChallenges = "https://api.fortnitetracker.com/v1/challenges";



    //QUERY and VALUES
    final static String PARAM_APIKEY = "TRN-Api-Key";
    final static String apiKey = "1db07a64-64ab-4c8c-9caa-97b4f81ae5d3";

    public static URL buildURLStats(){

//        if(someAribitraryVariable == null){
//            return null;
//        }
//
//        else{

        // For Testing Now
        ////https://api.fortnitetracker.com/v1/profile/{platform}/{epic-nickname}
        Uri builtUri = Uri.parse(endpointStats).buildUpon()
                .appendPath("ps4") //Add Arbitrary Platform
                .appendPath("rmart167") //Add Arbitrary Username
                .appendQueryParameter(PARAM_APIKEY, apiKey)
                .build();

        URL url = null;

        try{
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        Log.d("TAG", url.toString());
        return url;
    }



    public static URL buildURLMatchHistory(){


        //https://api.fortnitetracker.com/v1/profile/account/{accountId}/matches
        Uri builtUri = Uri.parse(endpointMatchHistory).buildUpon()
                .appendPath("573274ee-19a6-4772-b005-1c871474e67c") //Add arbitrary Epic ID
                .appendPath("matches")
                .build();


        URL url = null;

        try{
            url = new URL(builtUri.toString());

        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        Log.d("TAG", url.toString());
        return url;
    }



    //Connects by opening a connection with the url and returns the text
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();


//        urlConnection.setRequestProperty("TRN-Api-Key", "1db07a64-64ab-4c8c-9caa-97b4f81ae5d3");
//        urlConnection.setRequestMethod("GET");
//        urlConnection.setUseCaches(false);
//        urlConnection.setDoInput(true);
//        urlConnection.setDoOutput(true);


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
