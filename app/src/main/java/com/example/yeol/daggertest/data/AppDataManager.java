package com.example.yeol.daggertest.data;

import android.content.Context;
import android.content.res.Resources;
import com.example.yeol.daggertest.data.db.DbHelper;
import com.example.yeol.daggertest.data.db.model.User;
import com.example.yeol.daggertest.data.sharedprefs.SharedPrefsHelper;
import com.example.yeol.daggertest.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by gyl115 on 17. 4. 20.
 */

@Singleton
public class AppDataManager implements DataManager {

    private Context mContext;
    private DbHelper mDbHelper;
    private SharedPrefsHelper mSharedPrefsHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          SharedPrefsHelper sharedPrefsHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mSharedPrefsHelper = sharedPrefsHelper;
    }

    public void saveAccessToken(String accessToken) {
        mSharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public String getAccessToken(){
        return mSharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }

    public Long createUser(User user) throws Exception {
        return mDbHelper.insertUser(user);
    }

    public User getUser(Long userId) throws Resources.NotFoundException, NullPointerException {
        return mDbHelper.getUser(userId);
    }
}
