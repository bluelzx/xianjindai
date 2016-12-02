package com.brioal.bottomtablayout.api;

/**
 * Created by apple on 16/11/24.
 */

public class Api {
    //底部菜单
    public static String MENU_URL="";

    //WebView
    public static String HTML_URL="";


    public class NewsAPI {

        /**
         * 接口api的有关请求参数，地址等
         */
        public class Params {

            /**
             * 新闻接口地址
             */
            public static final String REQUEST_URL = "http://v.juhe.cn/toutiao/index";

            /**
             * 新闻接口地址参数名
             */
            public static final String REQUEST_URL_TYPR_NAME = "type";

            /**
             * 新闻接口地址参数名
             */
            public static final String REQUEST_URL_KEY = "key=62e564ec8879ceebdda234a2dd125413";

            /**
             * 新闻接口参数值
             */
            public static final String REQUEST_URL_KEY_VALUE = "9a21b88b1793ce50d8403ae0abfbbb90";
        }

    }
}
