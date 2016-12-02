package com.brioal.bottomtablayout.utils;

import com.brioal.bottomtablayout.api.Api;

/**
 * Created by apple on 16/11/25.
 */

public class Url {

    public static  String  getCaiJing(String name){
        StringBuffer sb=new StringBuffer();
        StringBuffer buffer = sb.append(Api.NewsAPI.Params.REQUEST_URL).append("?").append(Api.NewsAPI.Params.REQUEST_URL_TYPR_NAME)
                .append("=").append(name).append("&").append(Api.NewsAPI.Params.REQUEST_URL_KEY);
        return buffer.toString();

    }


}
