package com.brioal.bottomtablayout.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.brioal.bottomtablayout.R;
import com.brioal.bottomtablayout.utils.GlideImageLoader;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TechnoloyFragment extends Fragment {
    public static final String NAME = "TechnoloyFragment";
    @BindView(R.id.banner)
    Banner banner;
    public TechnoloyFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_technoloy, container, false);
        ButterKnife.bind(this, inflate);

        initView();
        return inflate;
    }


    private void initView() {


        List<Integer>images=new ArrayList<>();
        images.add(R.drawable.auto_1);
        images.add(R.drawable.auto_2);
        images.add(R.drawable.auto_3);
        images.add(R.drawable.auto_4);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

}
