package com.brioal.bottomtablayout.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.brioal.bottomtablayout.fragment.ChildFragment;

/**
 * Created by apple on 16/12/4.
 */

public class FristAdapter extends FragmentPagerAdapter {
    private  Integer[] dateList;

    public FristAdapter(FragmentManager fm, Integer[] data) {
        super(fm);
        this.dateList=data;
    }

    @Override
    public Fragment getItem(int position) {
        int lang = dateList[position];
        return ChildFragment.newInstance(lang);
    }

    @Override
    public int getCount() {
        return dateList.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        int lang = dateList[position];
        switch (lang) {
            case 1:
                return "贷款利率计算机";

        }
        return "";
    }
}
