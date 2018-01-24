package cn.com.microcent.news.di.component;

import cn.com.microcent.news.di.module.ActivityModule;
import cn.com.microcent.news.di.scope.ActivityScope;
import cn.com.microcent.news.ui.activity.AboutActivity;
import cn.com.microcent.news.ui.activity.MainActivity;
import cn.com.microcent.news.ui.activity.PhotoActivity;
import cn.com.microcent.news.ui.activity.SplashActivity;
import dagger.Component;

/**
 * Created by Administrator on 2018/1/3.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity splashActivity);

    void inject(MainActivity mainActivity);

    void inject(PhotoActivity photoActivity);

    void inject(AboutActivity aboutActivity);

}
