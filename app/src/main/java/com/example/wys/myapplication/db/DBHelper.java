package com.example.wys.myapplication.db;

import android.content.Context;

import com.example.wys.myapplication.Conf.Conf;
import com.example.wys.myapplication.bean.DaoMaster;
import com.example.wys.myapplication.bean.UserDao;

/**
 * Created by wys on 2016/4/14.
 */
public class DBHelper {
    private DaoMaster daoMaster;
    public DBHelper(Context ct){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(ct, Conf.DB_NAME,
                null);
        daoMaster = new DaoMaster(helper.getWritableDatabase());
    }
    public DBHelper(Context ct, String dbName) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(ct, dbName,
                null);
        daoMaster = new DaoMaster(helper.getWritableDatabase());
    }

    public UserDao getUserDao(){
        return daoMaster.newSession().getUserDao();
    }
}
