package com.example.yeol.daggertest.di.module;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.yeol.daggertest.di.ActivityContext;
import com.example.yeol.daggertest.di.ApplicationContext;
import com.example.yeol.daggertest.di.DatabaseInfo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gyl115 on 17. 4. 16.
 */
@Module
public class ActivityModule {
    private final Activity mActivity;

    // we pass an Activity instance to support dependencies(DataManager) MyApplication has.
    // with this instance It provide context,Application Context
    // that dependencies(DataManager,DbHelper) need to make their own instance.
    // Also Activity is super class, We can change the sub class whenever we need
    public ActivityModule(Activity activity){
        mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return mActivity;
    }

    @Provides
    Activity provideActivity(){ return mActivity; }

}
