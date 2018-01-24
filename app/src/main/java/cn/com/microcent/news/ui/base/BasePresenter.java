package cn.com.microcent.news.ui.base;

/**
 * Created by Administrator on 2017/12/14.
 */

public class BasePresenter<V extends IView> implements IPresenter<V> {

    protected V mView;

    @Override
    public void attachView(V view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }
}
