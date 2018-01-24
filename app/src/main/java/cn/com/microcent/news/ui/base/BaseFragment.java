package cn.com.microcent.news.ui.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.com.microcent.news.app.App;
import cn.com.microcent.news.di.component.DaggerFragmentComponent;
import cn.com.microcent.news.di.component.FragmentComponent;
import cn.com.microcent.news.di.module.FragmentModule;

/**
 * Created by Administrator on 2017/11/14.
 */

public abstract class BaseFragment<P extends IPresenter> extends Fragment implements IView {

    protected View mView;
    protected Context mContext;

    @Inject
    protected P mPresenter;
    private Unbinder mUnbinder;

    @Override
    public void onAttach(Context mContext) {
        super.onAttach(mContext);
        if (mContext != null) {
            this.mContext = mContext;
        } else {
            this.mContext = getActivity();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(getLayout(), null);
            //绑定到butterknife
            mUnbinder = ButterKnife.bind(this, mView);
            setInject();
            initView(inflater);
        }
        ViewGroup parent = (ViewGroup) mView.getParent();
        if (parent != null) {
            parent.removeView(mView);
        }
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mPresenter != null) mPresenter.attachView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != Unbinder.EMPTY) mUnbinder.unbind();
        this.mUnbinder = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();
        this.mPresenter = null;
        this.mView = null;
    }

    protected abstract int getLayout();

    protected abstract void setInject();

    protected abstract void initView(LayoutInflater inflater);

    public FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(App.getInstance().getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    private FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

}