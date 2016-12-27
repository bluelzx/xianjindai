package com.brioal.bottomtablayout.fragment;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brioal.bottomtablayout.R;
import com.brioal.bottomtablayout.SYFragment;
import com.brioal.bottomtablayout.adapter.HomePagerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.appbar_layout)
    AppBarLayout appbarLayout;
    @Bind(R.id.coord)
    CoordinatorLayout coord;

    public FirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

        HomePagerAdapter mHomePagerAdapter = new HomePagerAdapter(getActivity().getSupportFragmentManager());
        mHomePagerAdapter.addTab(new SYFragment(), "商业贷款");
        mHomePagerAdapter.addTab(new gongjijinFragment(), "公积金贷款");
        mHomePagerAdapter.addTab(new HunHeFragment(), "混合金贷款");
        viewPager.setAdapter(mHomePagerAdapter);
        tabLayout.setupWithViewPager(viewPager, false);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
