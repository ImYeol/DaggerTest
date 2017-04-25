package com.example.yeol.daggertest.data.db;

import com.example.yeol.daggertest.data.db.model.DaoMaster;
import com.example.yeol.daggertest.data.db.model.DaoSession;
import com.example.yeol.daggertest.data.db.model.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

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

    @Override
    public Observable<Long> insertUser(User user) {
        return null;
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return null;
    }
}
