package com.example.habitapp;

import java.util.Date;

public class Habit {

    private String mTitle;
    private String mDescription;
    private String mDate;

    public Habit(String title, String desc, String date){
        mTitle = title;
        mDescription = desc;
        mDate = date;
    }

    public Habit(){}

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }

}
