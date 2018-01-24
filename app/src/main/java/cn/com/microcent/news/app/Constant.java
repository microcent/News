package cn.com.microcent.news.app;

import cn.com.microcent.news.BuildConfig;

/**
 * Created by Administrator on 2018/1/24.
 */

public class Constant {

    public static final String API_HOST = BuildConfig.API_HOST;

    /**
     * 本地数据库名称
     */
    public static final String DB_NAME = "im-db";

    /**
     * 是否在debug模式
     */
    public static final boolean DEBUG = BuildConfig.DEBUG;

    public static final class Code {
        //请求成功状态码
        public static final int SUCCESS = 0;

        //签名错误
        //签名过期

        //AccessToken错误或已过期

    }

}
