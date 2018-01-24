package cn.com.microcent.news.data.local.db;

import javax.inject.Inject;

import cn.com.microcent.news.app.App;
import cn.com.microcent.news.app.Constant;
import cn.com.microcent.news.data.local.db.gen.DaoMaster;
import cn.com.microcent.news.data.local.db.gen.DaoSession;

/**
 * Created by Administrator on 2017/12/20.
 */

public class DaoManager {

    private DbUpgradeHelper helper;

    @Inject
    public DaoManager(App context) {
        helper = new DbUpgradeHelper(context.getApplicationContext(), Constant.DB_NAME);
    }

    /**
     * 获取操作数据库的Session
     */
    public DaoSession getDaoSession() {
        //该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        DaoMaster mDaoMaster = new DaoMaster(helper.getWritableDatabase());
        return mDaoMaster.newSession();
    }

}
