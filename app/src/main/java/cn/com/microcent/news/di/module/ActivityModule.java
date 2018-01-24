package cn.com.microcent.news.di.module;

import android.app.Activity;
import android.content.Context;


import javax.inject.Singleton;

import cn.com.microcent.news.di.scope.ActivityScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/1/3.
 */
@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @ActivityScope
    Context provideContext() {
        return activity;
    }

}
