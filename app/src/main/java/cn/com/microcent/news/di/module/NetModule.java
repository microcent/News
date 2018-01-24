package cn.com.microcent.news.di.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import cn.com.microcent.news.app.Constant;
import cn.com.microcent.news.data.remote.http.HeaderInterceptor;
import cn.com.microcent.news.data.remote.http.LoggingInterceptor;
import cn.com.microcent.news.data.remote.http.LoginService;
import cn.com.microcent.news.di.qualifier.Url;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Administrator on 2017/12/29.
 */

@Module
public class NetModule {

    /**
     * 连接超时时间，单位s
     */
    private static final byte DEFAULT_CONNECT_TIMEOUT = 10;
    /**
     * 读超时时间，单位s
     */
    private static final int DEFAULT_READ_TIMEOUT = 10;
    /**
     * 写超时时间，单位s
     */
    private static final int DEFAULT_WRITE_TIMEOUT = 10;

    @Provides
    @Singleton
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Provides
    @Singleton
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Provides
    @Singleton
    @Url
    Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient okHttpClient, Gson gson) {
        return createRetrofit(builder, okHttpClient, gson, Constant.API_HOST);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return builder.create();
    }

    @Provides
    @Singleton
    LoginService provideLoginService(@Url Retrofit retrofit) {
        return retrofit.create(LoginService.class);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        if (Constant.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }
        builder.addInterceptor(loggingInterceptor);

        if (Constant.DEBUG) {
            builder.addInterceptor(new LoggingInterceptor());
//            builder.addNetworkInterceptor(new StethoInterceptor());
        }

        builder.addInterceptor(new HeaderInterceptor());

//        File cacheFile = new File(Constant.PATH_CACHE);
//        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);//50 MiB
//        builder.cache(cache);

        //设置超时
        builder.connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS);

        //错误重连
        builder.retryOnConnectionFailure(true);

        return builder.build();
    }

    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient okHttpClient, Gson gson, String baseUrl) {
        return builder.baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}
