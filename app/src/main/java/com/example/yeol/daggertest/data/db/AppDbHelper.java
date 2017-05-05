package com.example.yeol.daggertest.data.db;

import com.example.yeol.daggertest.data.db.model.DaoMaster;
import com.example.yeol.daggertest.data.db.model.DaoSession;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by gyl115 on 17. 4. 20.
 */

@Singleton
public class AppDbHelper implements DbHelper {

    private final DaoSession mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

}
