package cn.com.microcent.news.data.local.db;

import android.content.Context;

import com.github.yuweiguocn.library.greendao.MigrationHelper;

import org.greenrobot.greendao.database.Database;

import cn.com.microcent.news.data.local.db.gen.DaoMaster;
import cn.com.microcent.news.data.local.db.gen.UserDao;


/**
 * 管理表的升级
 * Created by Administrator on 2018/1/10.
 */
public class DbUpgradeHelper extends DaoMaster.OpenHelper {

    public DbUpgradeHelper(Context context, String name) {
        super(context, name);
    }


    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        //数据库升级
        MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {
            @Override
            public void onCreateAllTables(Database db, boolean ifNotExists) {
                DaoMaster.createAllTables(db, ifNotExists);
            }

            @Override
            public void onDropAllTables(Database db, boolean ifExists) {
                DaoMaster.dropAllTables(db, ifExists);
            }
        }, UserDao.class);
    }

}
