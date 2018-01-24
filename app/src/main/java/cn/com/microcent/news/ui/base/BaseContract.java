package cn.com.microcent.news.ui.base;

/**
 * Created by Administrator on 2018/1/3.
 */

public interface BaseContract {

    interface BasePresenter<T> {

        void attachView(T view);

        void detachView();
    }

    interface BaseView {

        void showError();

        void complete();

    }

}
