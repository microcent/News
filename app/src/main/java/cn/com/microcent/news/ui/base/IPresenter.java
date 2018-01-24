package cn.com.microcent.news.ui.base;

/**
 * Created by Administrator on 2018/1/3.
 */

public interface IPresenter<V extends IView> {
    void attachView(V view);

    void detachView();
}
