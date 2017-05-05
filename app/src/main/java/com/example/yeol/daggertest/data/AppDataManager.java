package com.example.yeol.daggertest.data;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.example.yeol.daggertest.data.db.DbHelper;
import com.example.yeol.daggertest.data.db.model.PictureInfo;
import com.example.yeol.daggertest.data.sharedprefs.PreferencesHelper;
import com.example.yeol.daggertest.di.ApplicationContext;
import com.example.yeol.daggertest.service.BluetoothSyncService;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by gyl115 on 17. 4. 20.
 */

@Singleton
public class AppDataManager implements DataManager,BluetoothSyncService.Callback {

    private Context mContext;
    private DbHelper mDbHelper;
    private PreferencesHelper mSharedPrefsHelper;
    private BluetoothSyncService mBluetoothService;
    private BluetoothSyncService.Callback callback;
    private boolean isServiceOn = false;

    private ServiceConnection mConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BluetoothSyncService.btBinder binder = (BluetoothSyncService.btBinder)service;
            mBluetoothService = binder.getService();
            mBluetoothService.setCallback(AppDataManager.this);
            isServiceOn = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isServiceOn = false;
        }
    };

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper sharedPrefsHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mSharedPrefsHelper = sharedPrefsHelper;
    }


    @Override
    public Long getCurrentUserId() {
        return mSharedPrefsHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long userId) {
        mSharedPrefsHelper.setCurrentUserId(userId);
    }

    @Override
    public String getCurrentUserName() {
        return mSharedPrefsHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        mSharedPrefsHelper.setCurrentUserName(userName);
    }

    @Override
    public String getCurrentUserEmail() {
        return mSharedPrefsHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mSharedPrefsHelper.setCurrentUserEmail(email);
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return mSharedPrefsHelper.getCurrentUserProfilePicUrl();
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
        mSharedPrefsHelper.setCurrentUserProfilePicUrl(profilePicUrl);
    }

    @Override
    public String getAccessToken() {
        return null;
    }

    @Override
    public void setAccessToken(String accessToken) {

    }

    @Override
    public void onRecevied(PictureInfo picture) {
        callback.onRecevied(picture);
    }

    @Override
    public void startBtSyncService() {
        Intent intent = new Intent(mContext, BluetoothSyncService.class);
        mContext.bindService(intent,mConn,Context.BIND_AUTO_CREATE);
    }

    @Override
    public void setBluetoothCallback(BluetoothSyncService.Callback callback) {
        this.callback = callback;
    }
}
