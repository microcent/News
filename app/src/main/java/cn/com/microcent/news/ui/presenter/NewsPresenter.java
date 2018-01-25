package cn.com.microcent.news.ui.presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import cn.com.microcent.news.ui.base.BasePresenter;
import cn.com.microcent.news.ui.contract.NewsContract;

/**
 * Created by Administrator on 2018/1/24.
 */

public class NewsPresenter extends BasePresenter<NewsContract.View> implements NewsContract.Presenter {

    private static final String TAG = NewsPresenter.class.getSimpleName();

    @Inject
    public NewsPresenter() {

    }

    @Override
    public void load() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < new Random().nextInt(20); i++) {
            list.add("test" + i);
        }
        mView.loadSuccess(list);
    }
}
