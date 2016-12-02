package com.brioal.bottomtablayout.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brioal.bottomtablayout.Details_Activity;
import com.brioal.bottomtablayout.MyApplication;
import com.brioal.bottomtablayout.R;
import com.brioal.bottomtablayout.adapter.InternetAdapter;
import com.brioal.bottomtablayout.bean.News;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.ybq.android.spinkit.SpinKitView;
import com.yalantis.phoenix.PullToRefreshView;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class InternalFragment extends Fragment {

    private final String TAG = InternalFragment.class.getSimpleName();
    @BindView(R.id.recycler_layout)
    RecyclerView recyclerLayout;
    @BindView(R.id.swipe_layout)
    PullToRefreshView swipeLayout;
    @BindView(R.id.spin_kit1)
    SpinKitView spinKit1;

    private InternetAdapter mAdapter;

    public InternalFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_internal, container, false);
        ButterKnife.bind(this, view);
        getDate();
        return view;
    }

    private void setListener() {
        swipeLayout.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeLayout.setRefreshing(false);
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


    private void getDate() {

        Log.e(TAG, String.valueOf(MyApplication.getmList().size()));
        if(MyApplication.getmList().size()>0){
            spinKit1.setVisibility(View.GONE);
            recyclerLayout.setLayoutManager(new LinearLayoutManager(getContext()));
            mAdapter = new InternetAdapter(MyApplication.getmList());
            mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
            mAdapter.addFooterView(getView());
            recyclerLayout.setAdapter(mAdapter);
            recyclerLayout.addItemDecoration(new HorizontalDividerItemDecoration
                    .Builder(getContext())
                    .color(Color.GRAY)
                    .size(getResources().getDimensionPixelSize(R.dimen.divider_height))
                    .build());
            setListener();
        }
    }


}
