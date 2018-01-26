package cn.com.microcent.news.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import cn.com.microcent.news.R;
import cn.com.microcent.news.app.App;
import cn.com.microcent.news.model.News;
import cn.com.microcent.news.ui.adapter.NewsAdapter;
import cn.com.microcent.news.ui.base.BaseFragment;
import cn.com.microcent.news.ui.contract.NewsContract;
import cn.com.microcent.news.ui.presenter.NewsPresenter;

/**
 * Created by Administrator on 2018/1/24.
 */

public class NewsFragment extends BaseFragment<NewsPresenter> implements NewsContract.View {

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.rv_news)
    RecyclerView rvNews;
    @BindView(R.id.tv_empty)
    TextView tvEmpty;

    @Inject
    App app;

    @Inject
    NewsAdapter newsAdapter;

    private int channelId;

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void setInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initView(View view) {
        rvNews.setHasFixedSize(true);
        rvNews.setLayoutManager(new LinearLayoutManager(app.getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rvNews.setItemAnimator(new DefaultItemAnimator());
        rvNews.setAdapter(newsAdapter);

        if (getArguments() != null) {
            channelId = getArguments().getInt("CHANNEL_ID");
        }

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.load(channelId);
            }
        });
    }

    @Override
    protected void initData() {
        swipeRefreshLayout.setRefreshing(true);
        mPresenter.load(channelId);
    }

    @Override
    public void loadSuccess(List<News> list) {
        swipeRefreshLayout.setRefreshing(false);
        if (list != null && !list.isEmpty()) {
            newsAdapter.setList(list);
            newsAdapter.notifyDataSetChanged();
            rvNews.setVisibility(View.VISIBLE);
            tvEmpty.setVisibility(View.GONE);
        } else {
            rvNews.setVisibility(View.GONE);
            tvEmpty.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.tv_empty)
    public void onClick() {
        swipeRefreshLayout.setRefreshing(true);
        mPresenter.load(channelId);
    }

}
