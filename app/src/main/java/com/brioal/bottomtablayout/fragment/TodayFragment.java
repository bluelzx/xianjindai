package com.brioal.bottomtablayout.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.brioal.bottomtablayout.Details_Activity;
import com.brioal.bottomtablayout.MyApplication;
import com.brioal.bottomtablayout.R;
import com.brioal.bottomtablayout.adapter.InternetAdapter;
import com.brioal.bottomtablayout.bean.News;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.ybq.android.spinkit.SpinKitView;
import com.yalantis.phoenix.PullToRefreshView;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodayFragment extends Fragment {

    InternetAdapter mAdapter;
    private static final String TAG = TodayFragment.class.getSimpleName();
    @Bind(R.id.recycler_layout2)
    RecyclerView recyclerLayout2;
    @Bind(R.id.swipe_layout2)
    PullToRefreshView swipeLayout2;
    @Bind(R.id.spin_kit)
    SpinKitView spinKit;
    @Bind(R.id.webView)
    WebView webView;
    private SharedPreferences sp;
    private boolean flag=false;
    public TodayFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_today, container, false);
        ButterKnife.bind(this, inflate);
        initView(inflate);
        return inflate;
    }

    private void initView(View view) {

        TextNet();
        sp = getActivity().getSharedPreferences("info", Context.MODE_PRIVATE);
        String url = sp.getString("url", "");

        if (url.length() > 0) {
            spinKit.setVisibility(View.GONE);
            webView.setVisibility(View.VISIBLE);
            webView.getSettings().setPluginState(WebSettings.PluginState.ON);
            webView.setWebChromeClient(new WebChromeClient());
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setAppCachePath(getActivity().getCacheDir().getPath());
            if(flag){
                webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
            }else {
                webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            }
            webView.getSettings().setAppCacheEnabled(true);
            webView.getSettings().setDomStorageEnabled(true);
            webView.loadUrl(url);
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);

                    return true;
                }
            });
            webView.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View view, int i, KeyEvent keyEvent) {

                    if (i == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                        webView.goBack();
                        return true;
                    }
                    return false;
                }
            });
        } else {
            spinKit.setVisibility(View.GONE);
            mAdapter = new InternetAdapter(MyApplication.getmTodayList());
            recyclerLayout2.setLayoutManager(new LinearLayoutManager(getActivity()));
            mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
            recyclerLayout2.addItemDecoration(new HorizontalDividerItemDecoration
                        .Builder(getContext())
                        .color(Color.GRAY)
                        .size(getResources().getDimensionPixelSize(R.dimen.divider_height))
                        .build());
            recyclerLayout2.setAdapter(mAdapter);
            setListener();


        }

    }

    /**
     * 网络状态检测
     * @return
     */
    private boolean TextNet() {

        ConnectivityManager con = (ConnectivityManager) getActivity().getSystemService(Activity.CONNECTIVITY_SERVICE);
        boolean wifi = con.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
        boolean internet = con.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
        if (wifi | internet) {
            //执行相关操作
            flag=true;
        } else {
            Toast.makeText(getActivity(),
                    "亲，网络连接失败咯！", Toast.LENGTH_LONG)
                    .show();
        }
        return flag;
    }


    private void setListener() {
        swipeLayout2.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeLayout2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeLayout2.setRefreshing(false);
                    }
                }, 1000);
            }
        });
        mAdapter.setOnRecyclerViewItemClickListener(mItemtClickListener);

    }

    private BaseQuickAdapter.OnRecyclerViewItemClickListener mItemtClickListener = new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            News item = mAdapter.getItem(position);
            startActivity(new Intent(getActivity(), Details_Activity.class).putExtra("url", item.getUrl()));
        }
    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        webView.destroy();
        ButterKnife.unbind(this);
    }
}
