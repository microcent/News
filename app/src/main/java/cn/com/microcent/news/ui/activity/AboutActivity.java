package cn.com.microcent.news.ui.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import cn.com.microcent.news.R;
import cn.com.microcent.news.ui.base.BaseActivity;
import cn.com.microcent.news.ui.contract.AboutContract;
import cn.com.microcent.news.ui.presenter.AboutPresenter;

public class AboutActivity extends BaseActivity<AboutPresenter> implements AboutContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayout() {
        return R.layout.activity_about;
    }

    @Override
    protected void setInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initView() {
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {

    }

}
