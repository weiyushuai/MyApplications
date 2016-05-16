package com.example.wys.myapplication.bean;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.example.wys.myapplication.bean.DataCache;
import com.example.wys.myapplication.bean.User;

import com.example.wys.myapplication.bean.DataCacheDao;
import com.example.wys.myapplication.bean.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig dataCacheDaoConfig;
    private final DaoConfig userDaoConfig;

    private final DataCacheDao dataCacheDao;
    private final UserDao userDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        dataCacheDaoConfig = daoConfigMap.get(DataCacheDao.class).clone();
        dataCacheDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        dataCacheDao = new DataCacheDao(dataCacheDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(DataCache.class, dataCacheDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        dataCacheDaoConfig.getIdentityScope().clear();
        userDaoConfig.getIdentityScope().clear();
    }

    public DataCacheDao getDataCacheDao() {
        return dataCacheDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}
