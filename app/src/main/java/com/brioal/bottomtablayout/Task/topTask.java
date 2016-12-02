package com.brioal.bottomtablayout.Task;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.brioal.bottomtablayout.MyApplication;
import com.brioal.bottomtablayout.bean.News;
import com.brioal.bottomtablayout.utils.JsonParseTool;

import java.util.List;

import static com.brioal.bottomtablayout.MyApplication.mList;

/**
 * Created by apple on 16/12/1.
 */

public class TopTask {
    private static final String TAG = TopTask.class.getSimpleName();


    public static void getMessge(String url) {


        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                List<News> list = JsonParseTool.parseNewsJsonWidthJSONObject(response);
                if (list.size() > 0) {
                    MyApplication.getmTodayList().clear();
                    MyApplication.getmTodayList().addAll(list);
                }
                Log.e(TAG, mList.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.toString());

            }
        });

        MyApplication.getVolleyRequestQueue().add(request);


    }
}