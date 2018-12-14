package com.example.rmart1nez.fortniteappv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
