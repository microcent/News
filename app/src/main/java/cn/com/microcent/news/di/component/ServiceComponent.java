package cn.com.microcent.news.di.component;

import android.app.Service;

import cn.com.microcent.news.di.module.ServiceModule;
import cn.com.microcent.news.di.scope.ServiceScope;
import dagger.Component;

/**
 * Created by Administrator on 2017/12/28.
 */

@ServiceScope
@Component(dependencies = AppComponent.class, modules = {
        ServiceModule.class
})
public interface ServiceComponent {

}
