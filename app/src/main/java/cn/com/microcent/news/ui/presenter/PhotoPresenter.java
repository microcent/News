package cn.com.microcent.news.ui.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import cn.com.microcent.news.ui.base.BasePresenter;
import cn.com.microcent.news.ui.contract.PhotoContract;

/**
 * Created by Administrator on 2018/1/24.
 */

public class PhotoPresenter extends BasePresenter<PhotoContract.View> implements PhotoContract.Presenter {

    private static final String TAG = PhotoPresenter.class.getSimpleName();


    @Inject
    public PhotoPresenter() {

    }

    @Override
    public void load() {
        List<String> list = new ArrayList<>();
        list.add("http://www.pdsxww.com/images/attachement/jpg/site2/20160620/c03fd570564318d1e31506.jpg");
        list.add("http://www.pdsxww.com/images/attachement/jpg/site2/20160620/c03fd570564318d1e33b0b.jpg");
        list.add("http://www.pdsxww.com/images/attachement/jpg/site2/20160620/c03fd570564318d1e37315.jpg");
        list.add("http://www.pdsxww.com/images/attachement/jpg/site2/20160620/c03fd570564318d1e37315.jpg");
        mView.loadSuccess(list);
    }
}
