package cn.com.microcent.news.di.module;

import android.app.Service;

import dagger.Module;

/**
 * Created by xingwen on 2018/1/18.
 */

@Module
public class ServiceModule {

    private Service service;

    public ServiceModule(Service service) {
        this.service = service;
    }

}
