package cn.com.microcent.news.ui.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.com.microcent.news.R;
import cn.com.microcent.news.app.App;
import cn.com.microcent.news.di.component.ActivityComponent;
import cn.com.microcent.news.di.component.DaggerActivityComponent;
import cn.com.microcent.news.di.module.ActivityModule;

/**
 * Created by Administrator on 2017/11/14.
 */

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IView {

    protected App mApplication;
    protected Context mContext;

    private Unbinder mUnbinder;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mApplication = (App) getApplication();
        mContext = this;

        setContentView(getLayout());
        mUnbinder = ButterKnife.bind(this);

        setInject();
        if (mPresenter != null)
            mPresenter.attachView(this);

        initView();
        initData();
//        AppManager.getAppManager().addActivity(this);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        AppManager.getAppManager().finishActivity(this);
        if (mUnbinder != Unbinder.EMPTY) mUnbinder.unbind();
        this.mUnbinder = null;
        this.mApplication = null;
        if (mPresenter != null)
            mPresenter.detachView();
    }

    //得到当前界面的布局文件id(由子类实现)
    protected abstract int getLayout();

    protected abstract void setInject();

    protected abstract void initView();

    protected abstract void initData();

    public ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(App.getInstance().getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    private ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    public void jumpToActivity(Intent intent) {
        startActivity(intent);
    }

    public void jumpToActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    public void jumpToActivityAndClearTask(Class activity) {
        Intent intent = new Intent(this, activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    public void jumpToActivityAndClearTop(Class activity) {
        Intent intent = new Intent(this, activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
