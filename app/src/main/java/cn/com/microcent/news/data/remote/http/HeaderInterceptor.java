package cn.com.microcent.news.data.remote.http;

import android.os.SystemClock;

import java.io.IOException;

import cn.com.microcent.news.app.App;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * header配置
 */
public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
//        String timestamp = String.valueOf(App.serverTime + SystemClock.elapsedRealtime() - App.currentTime);
//        String sign = MD5.encrypt(Constant.APP_KEY + Constant.APP_SECRET + timestamp);
        Request.Builder builder = chain.request()
                .newBuilder();
        builder.addHeader("Content-Type", "application/json");
        builder.addHeader("User-Agent", "Android");
//        builder.addHeader("APP_KEY", Constant.APP_KEY);
//        builder.addHeader("TIMESTAMP", timestamp);
//        builder.addHeader("SIGN", sign);
        builder.addHeader("Authorization", "");
//                .addHeader("Content-Type", "application/json; charset=utf-8")
//                .addHeader("Accept-Encoding", "gzip, deflate")
//                .addHeader("Connection", "keep-alive")
//                .addHeader("Accept", "*/*")
//                .addHeader("Cookie", "add cookies here")
        Request request = builder.build();
        return chain.proceed(request);
    }
}
