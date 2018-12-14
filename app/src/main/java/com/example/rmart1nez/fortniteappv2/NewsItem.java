package com.example.rmart1nez.fortniteappv2;

import java.util.ArrayList;


public class NewsItem {



    public String mTitle;
    public String mBody;
    public String mImage;
    public String mTime;


    public NewsItem(String mTitle, String mBody, String mImage, String mTime) {
        this.mTitle = mTitle;
        this.mBody = mBody;
        this.mImage = mImage;
        this.mTime = mTime;
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


}
