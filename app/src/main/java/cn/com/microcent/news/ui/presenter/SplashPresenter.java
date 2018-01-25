package cn.com.microcent.news.ui.presenter;

import javax.inject.Inject;

import cn.com.microcent.news.ui.base.BasePresenter;
import cn.com.microcent.news.ui.contract.SplashContract;

/**
 * Created by Administrator on 2018/1/24.
 */

public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter {

    private static final String TAG = SplashPresenter.class.getSimpleName();


    @Inject
    public SplashPresenter() {

    }

}
