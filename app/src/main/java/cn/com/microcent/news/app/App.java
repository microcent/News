package cn.com.microcent.news.app;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.blankj.utilcode.util.Utils;

import cn.com.microcent.news.di.component.AppComponent;
import cn.com.microcent.news.di.component.DaggerAppComponent;
import cn.com.microcent.news.di.module.AppModule;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃  神兽保佑
 * 　　　　┃　　　┃  代码无bug
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 */
public class App extends MultiDexApplication {

    private AppComponent appComponent;

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger2();
        instance = this;
        Utils.init(this);
    }

    /**
     * 初始化Dagger2
     */
    private void initDagger2() {
        this.appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    /**
     * 获取AppComponent
     */
    public AppComponent getAppComponent() {
        return appComponent;
    }

}
