package cn.com.microcent.news;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingwen on 2018/1/23.
 */

public class NewsFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<String> channelNames;
    private List<Fragment> fragments = new ArrayList<>();

    public NewsFragmentPagerAdapter(FragmentManager fm, List<String> channelNames, List<Fragment> fragments) {
        super(fm);
        this.channelNames = channelNames;
        this.fragments = fragments;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return channelNames.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
