package cn.com.microcent.news.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.com.microcent.news.Channel;
import cn.com.microcent.news.R;
import cn.com.microcent.news.ui.adapter.NewsFragmentPagerAdapter;
import cn.com.microcent.news.ui.base.BaseActivity;
import cn.com.microcent.news.ui.contract.MainContract;
import cn.com.microcent.news.ui.fragment.NewsFragment;
import cn.com.microcent.news.ui.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout tabs;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
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
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                    overridePendingTransition(0, 0);
                } else if (id == R.id.nav_photo) {
                    startActivity(new Intent(MainActivity.this, PhotoActivity.class));
                    overridePendingTransition(0, 0);
                } else if (id == R.id.nav_video) {
                    Toast.makeText(MainActivity.this, "施工准备中...", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_night_mode) {

                }

                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        initViewPager();
    }

    @Override
    protected void initData() {

    }

    private void initViewPager() {
        List<Channel> channels = new ArrayList<>();
        channels.add(new Channel(1, "Sport", 0));
        channels.add(new Channel(2, "News", 1));
        List<String> channelNames = new ArrayList<>();
        List<Fragment> fragments = new ArrayList<>();
        channels.forEach(m->{
            channelNames.add(m.getChannelName());
            NewsFragment fragment = new NewsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("CHANNEL_POSITION", 0);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        });
        NewsFragmentPagerAdapter pagerAdapter = new NewsFragmentPagerAdapter(getSupportFragmentManager(), channelNames, fragments);
        viewPager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
