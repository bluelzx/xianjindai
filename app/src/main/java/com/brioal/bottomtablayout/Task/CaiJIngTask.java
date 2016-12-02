package com.brioal.bottomtablayout.Task;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.brioal.bottomtablayout.MyApplication;
import com.brioal.bottomtablayout.api.Api;
import com.brioal.bottomtablayout.bean.News;
import com.brioal.bottomtablayout.utils.JsonParseTool;

import java.util.List;

import static com.brioal.bottomtablayout.MyApplication.mList;


/**
 * Created by apple on 16/11/24.
 */

public class CaiJIngTask {
private static  final  String TAG=CaiJIngTask.class.getSimpleName();



    public static  void getMessge(){

        StringBuffer sb=new StringBuffer();
        StringBuffer buffer = sb.append(Api.NewsAPI.Params.REQUEST_URL).append("?").append(Api.NewsAPI.Params.REQUEST_URL_TYPR_NAME)
                .append("=").append("caijing").append("&").append(Api.NewsAPI.Params.REQUEST_URL_KEY);


        StringRequest request=new StringRequest(buffer.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                List<News> list = JsonParseTool.parseNewsJsonWidthJSONObject(response);

                MyApplication.getmList().addAll(list);

                Log.e(TAG,mList.toString());


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG,error.toString());
            }
        });

        MyApplication.getVolleyRequestQueue().add(request);


    }


}
