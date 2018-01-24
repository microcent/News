package cn.com.microcent.news.ui.presenter;

import javax.inject.Inject;

import cn.com.microcent.news.data.remote.http.LoginService;
import cn.com.microcent.news.ui.base.BasePresenter;
import cn.com.microcent.news.ui.contract.AboutContract;

/**
 * Created by Administrator on 2018/1/24.
 */

public class AboutPresenter extends BasePresenter<AboutContract.View> implements AboutContract.Presenter {

    private static final String TAG = AboutPresenter.class.getSimpleName();

    private LoginService loginService;

    @Inject
    public AboutPresenter(LoginService loginService) {
        this.loginService = loginService;
    }

}
