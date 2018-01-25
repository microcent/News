package cn.com.microcent.news.ui.contract;

import java.util.List;

import cn.com.microcent.news.ui.base.IPresenter;
import cn.com.microcent.news.ui.base.IView;

/**
 * Created by Administrator on 2018/1/24.
 */

public interface PhotoContract {
    interface View extends IView {
        void loadSuccess(List<String> list);
    }

    interface Presenter extends IPresenter<View> {
        void load();
    }
}
