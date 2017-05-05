package com.example.yeol.daggertest;

import android.app.Application;
import android.content.Context;

import com.example.yeol.daggertest.data.DataManager;
import com.example.yeol.daggertest.di.components.ApplicationComponent;
import com.example.yeol.daggertest.di.components.DaggerApplicationComponent;
import com.example.yeol.daggertest.di.module.ApplicationModule;

import javax.inject.Inject;

/**
 * Created by gyl115 on 17. 4. 16.
 */

public class MyApplication extends Application {

    protected ApplicationComponent mApplicationComponent;

    @Inject
    DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        // first pass this instance is for supporting dependencies(dataManager)
        // which MyApplication has
        mApplicationComponent = DaggerApplicationComponent.builder()
                                .applicationModule(new ApplicationModule(this)).build();
        // second pass is for assigning MyApplication dependencies(dataManager)
        mApplicationComponent.inject(this);
        dataManager.startBtSyncService();
    }

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent(){
        return mApplicationComponent;
    }
}
