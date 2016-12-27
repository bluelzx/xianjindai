package com.brioal.bottomtablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.brioal.bottomtablayout.fragment.AboutFragment;
import com.brioal.bottomtablayout.fragment.FirstFragment;
import com.brioal.bottomtablayout.fragment.TodayFragment;
import com.umeng.analytics.MobclickAgent;

import me.majiajie.pagerbottomtabstrip.Controller;
import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectListener;

public class MainActivity extends AppCompatActivity {
    private PagerBottomTabLayout bottomTabLayout;
    private FragmentManager mFragmentManger;
    private Fragment mCurrentFragment;
    private Controller mController;
    int[] testColors = {0xFF00796B,0xFF5B4947,0xFF607D8B,0xFFF57C00,0xFFF57C00};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottonLayout();

    }

    private void initBottonLayout() {
        bottomTabLayout = (PagerBottomTabLayout) findViewById(R.id.tab);
        bottomTabLayout.builder().build().setBackgroundColor(getResources().getColor(R.color.windows_color));
        mCurrentFragment=new TodayFragment();
        mFragmentManger=getSupportFragmentManager();
        mFragmentManger.beginTransaction().add(R.id.app_item, mCurrentFragment).commit();
        mController=bottomTabLayout.builder()
                .addTabItem(R.mipmap.home, "首页")
                .addTabItem(R.drawable.bug,"主页",testColors[0])
                .addTabItem(android.R.drawable.btn_star, "帮助",testColors[3])
                .build();
        mController.addTabItemClickListener(listener);

    }
    OnTabItemSelectListener listener=new OnTabItemSelectListener() {
        @Override
        public void onSelected(int index, Object tag) {
            switchMenu(getFragmentName(index+1));
        }

        @Override
        public void onRepeatClick(int index, Object tag) {

        }
    };
    private String getFragmentName(int menuId) {
        switch (menuId) {
            case 1:
                return TodayFragment.class.getName();
            case 2:
                return FirstFragment.class.getName();
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
            mFragmentManger.beginTransaction().add(R.id.app_item, fragment, fragmentName).commit();
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
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
