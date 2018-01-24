package cn.com.microcent.news.data.local.db;

import android.content.Context;

import javax.inject.Inject;

import cn.com.microcent.news.data.local.db.gen.DaoSession;
import cn.com.microcent.news.data.local.db.gen.UserDao;


/**
 * Created by Administrator on 2018/1/10.
 */

public class UserManager {

    private UserDao userDao;

    private Context context;

    @Inject
    public UserManager(Context context, DaoSession daoSession) {
        context = context;
        userDao = daoSession.getUserDao();
    }

    public String getAccessToken() {
        return "Access Token";
    }

}
