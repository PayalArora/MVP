package com.mylearning;

import android.app.Application;
import android.content.Context;

import com.mylearning.model.DataManager;

public class MyApplication extends Application {

    private DataManager mDataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mDataManager = DataManager.getInstance();
    }

    public static MyApplication get(Context context){
        return (MyApplication) context.getApplicationContext();
    }

    public DataManager getDataManager(){
        return mDataManager;
    }
}