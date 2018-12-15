package com.example.rmart1nez.fortniteappv2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent notificationIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 10);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);




        Button button = (Button) findViewById(R.id.ItemShopButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openItemShopActivity();
            }
        });

        Button button2 = (Button) findViewById(R.id.ServerStatusButton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openServerStatusActivity();
            }
        });

        Button button3 = (Button) findViewById(R.id.NewsButton);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewsActivity();
            }
        });

    }

    public void openItemShopActivity(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void openServerStatusActivity(){
        Intent intent2 = new Intent(this, MainActivity3.class);
        startActivity(intent2);
    }

    public void openNewsActivity(){
        Intent intent3 = new Intent(this, MainActivity4.class);
        startActivity(intent3);
    }


}
