package com.brioal.bottomtablayout.utils;

/**
 * Created by parting_soul on 2016/10/5.
 * 可供所有类访问的一些公共信息
 */

public class CommonInfo {
     public static  final String  HTML_URL="http://www.shoujiweidai.com/android/app1.html";

    /**
     * 图片缩放级别
     */
    public class ImageZoomLeve {
        /**
         * 默认ListView图片宽度分辨率
         */
        public static final int REQUEST_IMAGE_WIDTH = 100;
        /**
         * 默认ListView图片高度分辨率
         */
        public static final int REQUEST_IMAGE_HEIGHT = 100;
    }

    /**
     * 微信精选接口有关的信息
     */
    public class WeiChatAPI {

        /**
         * 接口api的有关请求参数，地址等
         */
        public class Params {
            /**
             * 微信精选接口地址
             */
            public static final String REQUEST_URL = "http://v.juhe.cn/weixin/query";

            /**
             * 请求页码
             */
            public static final String REQUEST_PAGE_NO_NAME = "pno";

            /**
             * 请求条数
             */
            public static final String REQUEST_NUMS = "ps";

            /**
             * 返回数据格式
             */
            public static final String REQUEST_DATATYPE = "dtype";

            /**
             * 默认格式为json
             */
            public static final String REQUEST_TYPE = "json";

            /**
             * key
             */
            public static final String REQUEST_KEY_NAME = "key";

            /**
             * 参数值
             */
            public static final String REQUEST_KEY_VALUE = "a70d645e3a38d3446ed8d6c67ea1a10c";

        }

        public class JSONKEY {
            /**
             * json数据返回结果的键
             */
            public static final String RESPONSE_JSON_RESULT_KEY_NAME = "result";

            /**
             * 数据集合key
             */
            public static final String REQUEST_JSON_DATA_LISTS = "list";

            /**
             * 结果返回成功
             */
            public static final String RESQUEST_JSON_REASON_SUCCESS_KEY_VALUE = "success";

            /**
             * 结果返回状态键
             */
            public static final String REQUEST_JSON_REASON_KEY_NAME = "reason";

            /**
             * 图片键
             */
            public static final String REQUEST_JSON_IMG_KEY_NAME = "firstImg";

            /**
             * id
             */
            public static final String REQUEST_JSON_ID_KEY_NAME = "id";

            /**
             * 来源
             */
            public static final String REQUEST_JSON_SOURCE_KEY_NAME = "source";

            /**
             * 标题
             */
            public static final String REQUEST_JSON_TITLE_KEY_NAME = "title";

            /**
             * url
             */
            public static final String REQUEST_JSON_URL_KEY_NAME = "url";

            /**
             * 总共的页面数
             */
            public static final String REQUEST_JSON_TOLALPAGE_KEY_NAME = "totalPage";

            /**
             * 每次请求数目
             */
            public static final String REQUEST_JSON_ITEM_NUMS_KEY_NAME = "ps";

            /**
             * 当前页
             */
            public static final String REQUEST_JSON_PAGE_NO_KEY_NAME = "pno";
        }
    }

    /**
     * 新闻api接口有关的信息
     */
    public class NewsAPI {

        /**
         * 接口api的有关请求参数，地址等
         */
        public class Params {
            /**
             * activity与fragment间通信的Bundle中的键<br>
             * 用于得到向网络请求的新闻类参数
             */
            public static final String REQUEST_TYPE_PARAM_NAME = "type_param_name";

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
            public static final String REQUEST_URL_KEY_NAME = "key";

            /**
             * 新闻接口参数值
             */
            public static final String REQUEST_URL_KEY_VALUE = "9a21b88b1793ce50d8403ae0abfbbb90";
        }

        /**
         * 解析接口返回的json数据中所需要的键，以便获取相应的值
         */
        public class JSONKEY {

            /**
             * json数据返回状态码的名字
             */
            public static final String RESPONSE_JSON_ERROR_CODE_KEY_NAME = "error_code";

            /**
             * json数据返回结果的键
             */
            public static final String RESPONSE_JSON_RESULT_KEY_NAME = "result";

            /**
             * json数据数据集的键
             */
            public static final String RESPONSE_JSON_RESULT_DATA_KEY_NAME = "data";

            /**
             * 新闻的标题键
             */
            public static final String RESPONSE_JSON_RESULT_NEWS_TITLE = "title";

            /**
             * 新闻的日期键
             */
            public static final String RESPONSE_JSON_RESULT_NEWS_DATE = "date";

            /**
             * 新闻的作者键
             */
            public static final String RESPONSE_JSON_RESULT_NEWS_AUTHOR_NAME = "author_name";

            /**
             * 新闻图片地址键
             */
            public static final String RESPONSE_JSON_RESULT_NEWS_PICTURE_PATH = "thumbnail_pic_s";

            /**
             * 新闻地址键
             */
            public static final String RESPONSE_JSON_RESULT_NEWS_URL = "url";

            /**
             * 新闻唯一识别码键
             */
            public static final String RESPONSE_JSON_RESULT_NEWS_UNIQUE_KEY = "uniquekey";

            /**
             * 新闻真正的类型键
             */
            public static final String RESPONSE_JSON_RESULT_NEWS_REALTYPE = "realtype";
        }

        /**
         * 接口返回的状态码
         */
        public class ResponseCode {
            /**
             * json数据正常返回码
             */
            public static final int RESPONSE_JSON_NORMALL_CODE = 0;

            /**
             * 接口维护返回码
             */
            public static final int RESPONSE_JSON_API_INTERFACE_MAINTAIN = 10020;

            /**
             * 接口停用返回码
             */
            public static final int RESPONSE_JSON_API_INTERFACE_STOP = 10021;

            /**
             * 返回码大于200000,服务器发生错误
             */
            public static final int RESPONSE_JSON_SERVER_ERROR = 200000;

        }
    }




}
