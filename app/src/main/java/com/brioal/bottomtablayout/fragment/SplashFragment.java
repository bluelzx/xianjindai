package com.brioal.bottomtablayout.fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.brioal.bottomtablayout.MainActivity;
import com.brioal.bottomtablayout.MyApplication;
import com.brioal.bottomtablayout.R;
import com.brioal.bottomtablayout.Task.TopTask;
import com.brioal.bottomtablayout.utils.SharedPerferenceUtil;
import com.brioal.bottomtablayout.utils.Url;


/**
 * A simple {@link Fragment} subclass.
 */
public class SplashFragment extends Fragment {

    private static  final String URL="http://www.shoujiweidai.com/android/app1.html";
    //private static  final String URL="https://www.baidu.com";
    private SharedPreferences sp;
    public SplashFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sp = getActivity().getSharedPreferences("info", getActivity().MODE_PRIVATE);

                String  url = sp.getString("url", "");

                if(url.isEmpty()){
                    setUrl();
                }
               //  CaiJIngTask.getMessge(Url.getCaiJing("caijing"));
                 TopTask.getMessge(Url.getCaiJing("keji"));
                // 判断是否是第一次开启应用
                boolean isFirstOpen = SharedPerferenceUtil.getBoolean(getActivity(), SharedPerferenceUtil.FIRST_OPEN, true);
                // 如果是第一次启动，则先进入功能引导页

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }

        }, 2000);
        return view;
    }
    private void setUrl() {

            StringRequest request=new StringRequest(URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString("url",URL);
                    edit.commit();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            MyApplication.getVolleyRequestQueue().add(request);
        }


}

