package cn.com.microcent.news.di.component;


import javax.inject.Singleton;

import cn.com.microcent.news.app.App;
import cn.com.microcent.news.data.local.PreferencesManager;
import cn.com.microcent.news.data.local.db.gen.DaoSession;
import cn.com.microcent.news.data.remote.http.LoginService;
import cn.com.microcent.news.di.module.AppModule;
import cn.com.microcent.news.di.module.NetModule;
import dagger.Component;

/**
 * Created by Administrator on 2017/12/28.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        NetModule.class
})
public interface AppComponent {

    void inject(App application);

    App APP();

    PreferencesManager PREFERENCES_MANAGER();

    LoginService LOGIN_SERVICE();

    DaoSession DAO_SESSION();

}
