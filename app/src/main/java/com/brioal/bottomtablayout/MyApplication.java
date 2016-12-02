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
    // 建立请求队列
    public static RequestQueue queue;
    @Override
    public void onCreate() {
        super.onCreate();

        queue = Volley.newRequestQueue(getApplicationContext());
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
