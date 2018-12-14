package com.example.rkjc.news_app_2;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.ArrayList;


@Entity(tableName = "news_item")
public class NewsItem {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    public String mTitle;

    @ColumnInfo(name = "body")
    public String mBody;

    @ColumnInfo(name = "image")
    public String mImage;

    @ColumnInfo(name = "time")
    public String mTime;


    public NewsItem(String mTitle, String mBody, String mImage, String mTime) {
        this.mTitle = mTitle;
        this.mBody = mBody;
        this.mImage = mImage;
        this.mTime = mTime;
    }

    @Ignore
    public NewsItem() {

    }


    public int getId() {
        return id;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmBody() {
        return mBody;
    }

    public String getmImage() {
        return mImage;
    }

    public String getmTime() {
        return mTime;
    }

    public void setId(int id) {
        this.id = id;
    }
}

