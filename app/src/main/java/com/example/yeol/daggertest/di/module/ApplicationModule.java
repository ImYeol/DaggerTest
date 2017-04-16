package com.example.yeol.daggertest.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.yeol.daggertest.di.ApplicationContext;
import com.example.yeol.daggertest.di.DatabaseInfo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gyl115 on 17. 4. 16.
 */
@Module
public class ApplicationModule {
    private final Application mApplication;

    // we pass an Application instance to support dependencies(DataManager) MyApplication has.
    // with this instance It provide context,Application Context
    // that dependencies(DataManager,DbHelper) need to make their own instance
    public ApplicationModule(Application app){
        mApplication = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext(){
        return mApplication;
    }

    @Provides
    Application provideApplication(){
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName(){
        return "demo-dagger.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion(){
        return 1;
    }

    @Provides
    SharedPreferences provideSharedPreferences(){
        return mApplication.getSharedPreferences("demo-prefs",Context.MODE_PRIVATE);
    }
}
