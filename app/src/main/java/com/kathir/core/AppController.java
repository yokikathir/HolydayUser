package com.kathir.core;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.internal.ANRequestQueue;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class AppController  extends Application {
    private static AppController mInstance;
    @Override
    public void onCreate() {
        super.onCreate();

        OkHttpClient httpClient=new OkHttpClient().newBuilder().connectTimeout(120, TimeUnit.SECONDS).readTimeout(120,TimeUnit.SECONDS).writeTimeout(120,TimeUnit.SECONDS).build();

        AndroidNetworking.initialize(getApplicationContext(),httpClient);

    }

    public static synchronized AppController getInstance() {

        if(mInstance==null)
            mInstance=new AppController();
        return mInstance;
    }
    public void clearQueue(String tag)
    {
        ANRequestQueue.getInstance().cancelRequestWithGivenTag(tag,false);
    }
}
