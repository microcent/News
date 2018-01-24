package cn.com.microcent.news.di.component;

import cn.com.microcent.news.di.module.FragmentModule;
import cn.com.microcent.news.di.scope.FragmentScope;
import cn.com.microcent.news.ui.fragment.NewsFragment;
import dagger.Component;

/**
 * Created by Administrator on 2018/1/3.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(NewsFragment newsFragment);

}
