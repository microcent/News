package cn.com.microcent.news.di.module;


import javax.inject.Singleton;

import cn.com.microcent.news.app.App;
import cn.com.microcent.news.data.local.PreferencesManager;
import cn.com.microcent.news.data.local.db.DaoManager;
import cn.com.microcent.news.data.local.db.gen.DaoSession;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/12/28.
 */

@Module
public class AppModule {

    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplication() {
        return this.application;
    }

    @Provides
    @Singleton
    PreferencesManager provideSharedPreferences() {
        return new PreferencesManager(application);
    }

    @Provides
    @Singleton
    DaoSession provideDaoSession(DaoManager daoManager) {
        return daoManager.getDaoSession();
    }

}
