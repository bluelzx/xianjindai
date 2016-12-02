package com.brioal.bottomtablayout.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.brioal.bottomtablayout.Details_Activity;
import com.brioal.bottomtablayout.MyApplication;
import com.brioal.bottomtablayout.R;
import com.brioal.bottomtablayout.adapter.InternetAdapter;
import com.brioal.bottomtablayout.bean.News;
import com.brioal.bottomtablayout.utils.CommonInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.ybq.android.spinkit.SpinKitView;
import com.yalantis.phoenix.PullToRefreshView;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodayFragment extends Fragment {

    @BindView(R.id.todayWebView)
    WebView todayWebView;
    @BindView(R.id.recycler_layout2)
    RecyclerView recyclerLayout2;
    @BindView(R.id.swipe_layout2)
    PullToRefreshView swipeLayout2;
    InternetAdapter mAdapter;
    private static final String TAG = TodayFragment.class.getSimpleName();
    @BindView(R.id.spin_kit)
    SpinKitView spinKit;

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
        StringRequest request = new StringRequest(CommonInfo.HTML_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                spinKit.setVisibility(View.GONE);
                todayWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
                todayWebView.setWebChromeClient(new WebChromeClient());
                todayWebView.getSettings().setJavaScriptEnabled(true);
                todayWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
                todayWebView.getSettings().setDomStorageEnabled(true);
                todayWebView.loadUrl(CommonInfo.HTML_URL);
                todayWebView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);
                        return true;
                    }
                });
                todayWebView.setVisibility(View.VISIBLE);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (MyApplication.getmTodayList().size() > 0) {
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
               /*
                StringRequest request = new StringRequest(Url.getCaiJing("top"), new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        List<News> newses = JsonParseTool.parseNewsJsonWidthJSONObject(response);
                        Log.e(TAG, newses.toString());
                        mAdapter = new InternetAdapter(newses);
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
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, error.toString());
                        enptyImage.setVisibility(View.VISIBLE);
                    }
                });

                MyApplication.getVolleyRequestQueue().add(request);*/

            }
        });

        MyApplication.getVolleyRequestQueue().add(request);
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
    public void onDestroy() {
        super.onDestroy();
        todayWebView.destroy();
    }


}
