package cn.com.microcent.news.di.module;

import android.support.v4.app.Fragment;

import cn.com.microcent.news.di.scope.FragmentScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/1/3.
 */
@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    Fragment provideFragment() {
        return fragment;
    }

}
