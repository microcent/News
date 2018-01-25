package cn.com.microcent.news.ui.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import cn.com.microcent.news.R;
import cn.com.microcent.news.ui.adapter.PhotoAdapter;
import cn.com.microcent.news.ui.base.BaseActivity;
import cn.com.microcent.news.ui.contract.PhotoContract;
import cn.com.microcent.news.ui.presenter.PhotoPresenter;

public class PhotoActivity extends BaseActivity<PhotoPresenter> implements PhotoContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.rv_photo)
    RecyclerView rvPhoto;

    @Inject
    PhotoAdapter photoAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_photo;
    }

    @Override
    protected void setInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initView() {
        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_news) {
                    startActivity(new Intent(PhotoActivity.this, MainActivity.class));
                    overridePendingTransition(0, 0);
                } else if (id == R.id.nav_photo) {
                    startActivity(new Intent(PhotoActivity.this, PhotoActivity.class));
                    overridePendingTransition(0, 0);
                } else if (id == R.id.nav_video) {

                } else if (id == R.id.nav_night_mode) {

                }

                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        rvPhoto.setHasFixedSize(true);
        rvPhoto.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rvPhoto.setItemAnimator(new DefaultItemAnimator());

        rvPhoto.setAdapter(photoAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.load();
    }

    @Override
    public void loadSuccess(List<String> list) {
        photoAdapter.setList(list);
        photoAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
