package com.example.rmart1nez.fortniteapp;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        /* Creates Menu button on the top left corner  */
        drawer = findViewById(R.id.drawer_layout);

        /* Set the navigation view for the view */
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);

        /* Handles the icon */
        toggle.syncState();


        /* if we see our activity for the first time  */
        if(savedInstanceState == null){

        /* Display main screen window when application loads */
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PlayerStats()).commit();
        navigationView.setCheckedItem(R.id.nav_player_stats);

        }


        //IMPLEMENT TEST FUNCTION
        URL url = NetworkUtils.buildURLServerStatus();
        Log.d("TAG", url.toString());

        QueryTask task = new QueryTask();
        task.execute(url);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        /* Finds out which item was clicked */
        switch (menuItem.getItemId()) {
            case R.id.nav_player_stats:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PlayerStats()).commit();
                break;

            case R.id.nav_match_history:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MatchHistory()).commit();
                break;

            case R.id.nav_item_shop:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ItemShop()).commit();
                break;

            case R.id.nav_challenges:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Challenges()).commit();
                break;

            case R.id.nav_news:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new News()).commit();
                break;

            case R.id.nav_server_status:
                Toast.makeText(this, "INSERT SERVER STATUS HERE", Toast.LENGTH_SHORT).show();
        }

        /* To close the navigation window (drawer) */
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed(){
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }


    public class QueryTask extends AsyncTask<URL, Void, String> {

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(URL...urls){


            String challengesText = "";

            try{
                challengesText = NetworkUtils.getResponseFromHttpUrl(urls[0]);
            } catch (IOException e){
                e.printStackTrace();
            }

            return challengesText;
        }

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            Log.d("TAG POST EXECUTE", s);
        }
    }
}



