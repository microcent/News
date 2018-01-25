package cn.com.microcent.news.ui.presenter;

import javax.inject.Inject;

import cn.com.microcent.news.ui.base.BasePresenter;
import cn.com.microcent.news.ui.contract.MainContract;

/**
 * Created by Administrator on 2018/1/24.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private static final String TAG = MainPresenter.class.getSimpleName();


    @Inject
    public MainPresenter() {

    }

    public void load(){

    }

}
