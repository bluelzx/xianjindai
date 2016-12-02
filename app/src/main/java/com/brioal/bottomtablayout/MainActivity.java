package com.brioal.bottomtablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.brioal.bottomtab.entity.TabEntity;
import com.brioal.bottomtab.interfaces.OnTabSelectedListener;
import com.brioal.bottomtab.view.BottomLayout;
import com.brioal.bottomtablayout.api.Api;
import com.brioal.bottomtablayout.fragment.AboutFragment;
import com.brioal.bottomtablayout.fragment.InternalFragment;
import com.brioal.bottomtablayout.fragment.TechnoloyFragment;
import com.brioal.bottomtablayout.fragment.TodayFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG=MainActivity.class.getSimpleName();
    private BottomLayout mBottomLayout;
    private List<TabEntity> mList;
    private FragmentManager mFragmentManger;
    private Fragment mCurrentFragment;
    private static String  NAME="头条";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottonLayout();

    }



    private void initBottonLayout() {
        mBottomLayout = (BottomLayout) findViewById(R.id.main_tab);
        mFragmentManger=getSupportFragmentManager();
        mCurrentFragment=new TodayFragment();
        mFragmentManger.beginTransaction().add(R.id.newsApp, mCurrentFragment, null).commit();
        mList = new ArrayList<>();
        mList.add(new TabEntity(R.mipmap.icon_1, "首页"));
        mList.add(new TabEntity(R.mipmap.icon_3, "财经"));
        mList.add(new TabEntity(R.mipmap.icon_4, "关于"));
        mBottomLayout.setList(mList); //设置数据源
        mBottomLayout.setSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onSelected(int position) {

                switchMenu(getFragmentName(position+1));

            }
        });

    }
    private String getFragmentName(int menuId) {
        switch (menuId) {
            case 1:
                return TodayFragment.class.getName();
            case 2:
                return InternalFragment.class.getName();
            case 3:
                return AboutFragment.class.getName();
            default:
                return null;
        }
    }

    /**
     * 底部菜单栏
     *
     * @param fragmentName
     */
    private void switchMenu(String fragmentName) {

        Fragment fragment = mFragmentManger.findFragmentByTag(fragmentName);

        if (fragment != null) {
            if (fragment == mCurrentFragment) return;

            mFragmentManger.beginTransaction().show(fragment).commit();
        } else {
            fragment = Fragment.instantiate(this, fragmentName);
            mFragmentManger.beginTransaction().add(R.id.newsApp, fragment, fragmentName).commit();
        }

        if (mCurrentFragment != null) {
            mFragmentManger.beginTransaction().hide(mCurrentFragment).commit();
        }
        mCurrentFragment = fragment;
    }


    private long mLastBackTime = 0;
    @Override
    public void onBackPressed() {
        // finish while click back key 2 times during 1s.
        if ((System.currentTimeMillis() - mLastBackTime) < 1000) {
            finish();
        } else {
            mLastBackTime = System.currentTimeMillis();
            Toast.makeText(this, R.string.exit_click_back_again, Toast.LENGTH_SHORT).show();
        }

    }
}
