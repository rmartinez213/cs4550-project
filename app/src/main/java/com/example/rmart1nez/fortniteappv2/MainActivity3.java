package com.example.rmart1nez.fortniteappv2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private EditText mSearchBoxEditText;
    private TextView mUrlDisplayTextView;
    private TextView mSearchResultsTextView;
    private ProgressBar mProgressBar;
    private static final String TAG = "MainActivity";

    private RecyclerView mRecyclerView;


    //USE THIS
    private RecyclerView fRecyclerView;
    private FRecyclerViewAdapter fAdapter;

    private ArrayList<PlayerStatsAL> player = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        mSearchBoxEditText = (EditText) findViewById(R.id.et_search_box);

//      mSearchResultsTextView = (TextView) findViewById(R.id.date);

        //mRecyclerView = (RecyclerView)findViewById(R.id.news_recyclerview);
        fRecyclerView = (RecyclerView)findViewById(R.id.news_recyclerview);


        fAdapter = new FRecyclerViewAdapter(this, player);
        //mAdapter = new NewsRecyclerViewAdapter(this, newsItems);
        fRecyclerView.setAdapter(fAdapter);
        fRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }







    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_search) {
            Log.d("EDITING", mSearchBoxEditText.getText().toString());
            //HERE CALL FORTNITE
            URL statURL = FNetworkUtils.buildURLStats(mSearchBoxEditText.getText().toString());
            NewsQueryTask t = new NewsQueryTask();

//            URL url = NetworkUtils.buildUrl();
//            NewsQueryTask task = new NewsQueryTask();
            t.execute(statURL);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    // DONE (1) Create a class called GithubQueryTask that extends AsyncTask<URL, Void, String>
    public class NewsQueryTask extends AsyncTask<URL, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(URL... urls) {
            String githubSearchResults = "";
            try {
                githubSearchResults = FNetworkUtils.getResponseFromHttpUrl(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return githubSearchResults;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d("mycode", s);
            super.onPostExecute(s);
            //mProgressBar.setVisibility(View.GONE);
            player = JSONPlayerUtils.parseNews(s);
            //newsItems = JsonUtils.parseNews(s);

            fAdapter.mNewsItem.addAll(player);
            fAdapter.notifyDataSetChanged();



//
//            mAdapter.mNewsItem.addAll(newsItems);
//            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}
