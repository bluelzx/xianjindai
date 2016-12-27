package com.brioal.bottomtablayout.Task;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.brioal.bottomtablayout.MyApplication;
import com.brioal.bottomtablayout.bean.News;
import com.brioal.bottomtablayout.utils.JsonParseTool;

import java.util.List;


/**
 * Created by apple on 16/11/24.
 */

public class CaiJIngTask {
private static  final  String TAG=CaiJIngTask.class.getSimpleName();


    public static  void getMessge(String url){


        StringRequest request=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                List<News> list = JsonParseTool.parseNewsJsonWidthJSONObject(response);
                if(list.size()>1){
                    MyApplication.getmList().clear();
                    MyApplication.getmList().addAll(list);
                }
                MyApplication.getmTodayList().addAll(list);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        MyApplication.getVolleyRequestQueue().add(request);


    }


}
