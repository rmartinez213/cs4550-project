package com.example.rmart1nez.fortniteappv2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    private List<NewsItem> news = new ArrayList<NewsItem>();
    private NewsAdapter itemShopViewAdapter ;
    private RecyclerView mRecyclerView;
    private TextView mSearchResultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);



        //mSearchResultsTextView = (TextView) findViewById(R.id.date);
        mRecyclerView = (RecyclerView)findViewById(R.id.news_recyclerview);
        itemShopViewAdapter = new NewsAdapter(this, news);
        mRecyclerView.setAdapter(itemShopViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        URL url = NetworkUtils.buildURLNews(); //Returns proper URL with API Key
        QueryTask task = new QueryTask();
        task.execute(url);

    }




    public class QueryTask extends AsyncTask<URL, Void, String> {

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(URL...urls){
            String articleText = "";

            try{
                articleText = NetworkUtils.getResponseFromHttpUrl(urls[0]);
            } catch (IOException e){
                e.printStackTrace();
            }

            return articleText;
        }

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            news = JsonUtilsNews.parseNews(s);
            itemShopViewAdapter.newsitem.addAll(news); //Add all values into adapter
            itemShopViewAdapter.notifyDataSetChanged(); //Display *live* changes
        }
    }
}
