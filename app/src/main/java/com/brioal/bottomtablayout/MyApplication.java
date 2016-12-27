package com.brioal.bottomtablayout;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.brioal.bottomtablayout.bean.News;

import java.util.ArrayList;

/**
 * Created by apple on 16/11/24.
 */

public class MyApplication extends Application {
    public static MyApplication application;
    private static MyApplication instance;

    // 建立请求队列
    public static RequestQueue queue;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        instance = this;
        queue = Volley.newRequestQueue(getApplicationContext());
    }
    public static MyApplication getInstance(){
        if(instance==null){
            instance = new MyApplication();
        }
        return instance;
    }
    public static RequestQueue getVolleyRequestQueue() {
        return queue;
    }

    public static ArrayList<News>mList=new ArrayList<>();

    public static ArrayList<News> getmList() {
        return mList;
    }

    public static void setmList(ArrayList<News> mList) {
        MyApplication.mList = mList;
    }
    public static ArrayList<News>mTodayList=new ArrayList<>();

    public static ArrayList<News> getmTodayList() {
        return mTodayList;
    }
    public static void setmTodayList(ArrayList<News> mTodayList) {
        MyApplication.mTodayList = mTodayList;
    }
}
