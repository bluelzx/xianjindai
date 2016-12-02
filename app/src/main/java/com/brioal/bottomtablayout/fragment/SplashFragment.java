package com.brioal.bottomtablayout.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brioal.bottomtablayout.MainActivity;
import com.brioal.bottomtablayout.R;
import com.brioal.bottomtablayout.Task.CaiJIngTask;
import com.brioal.bottomtablayout.Task.TopTask;
import com.brioal.bottomtablayout.activity.WelcomeGuideActivity;
import com.brioal.bottomtablayout.utils.SharedPerferenceUtil;
import com.brioal.bottomtablayout.utils.Url;


/**
 * A simple {@link Fragment} subclass.
 */
public class SplashFragment extends Fragment {


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
                 CaiJIngTask.getMessge(Url.getCaiJing("caijing"));
                TopTask.getMessge(Url.getCaiJing("top"));
                // 判断是否是第一次开启应用
                boolean isFirstOpen = SharedPerferenceUtil.getBoolean(getActivity(), SharedPerferenceUtil.FIRST_OPEN, true);
                // 如果是第一次启动，则先进入功能引导页
                if (isFirstOpen) {
                    Intent intent = new Intent(getActivity(), WelcomeGuideActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                    return;
                }
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }

        }, 3000);
        return view;


    }


}

