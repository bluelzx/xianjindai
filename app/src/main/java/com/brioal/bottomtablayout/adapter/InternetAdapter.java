package com.brioal.bottomtablayout.adapter;

import android.view.View;
import android.widget.ImageView;

import com.brioal.bottomtablayout.R;
import com.brioal.bottomtablayout.bean.News;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by apple on 16/11/24.
 */

public class InternetAdapter  extends BaseQuickAdapter<News> {


    public InternetAdapter(List<News> data) {
        super(R.layout.news_detail__listview_item,data);
    }

    public InternetAdapter(int layoutResId, List<News> data) {
        super(layoutResId, data);
    }

    public InternetAdapter(View contentView, List<News> data) {
        super(contentView, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, News news) {
                baseViewHolder.setText(R.id.news_title,news.getTitle())
                        .setText(R.id.news_author_name,news.getAuthor_name())
                        .setText(R.id.news_date,news.getDate());
       Glide.with(mContext).load(news.getPicPath()).placeholder(R.drawable.imageview_error_bc).crossFade().into((ImageView) baseViewHolder.getView(R.id.news_pic));
    }


}
