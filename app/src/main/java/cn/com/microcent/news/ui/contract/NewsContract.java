package cn.com.microcent.news.ui.contract;

import java.util.List;

import cn.com.microcent.news.model.News;
import cn.com.microcent.news.ui.base.IPresenter;
import cn.com.microcent.news.ui.base.IView;

/**
 * Created by Administrator on 2018/1/24.
 */

public interface NewsContract {
    interface View extends IView {
        void loadSuccess(List<News> list);
    }

    interface Presenter extends IPresenter<View> {
        void load(int channelId);
    }
}
