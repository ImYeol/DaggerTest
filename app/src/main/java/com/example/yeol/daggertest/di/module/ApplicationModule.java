package com.example.yeol.daggertest.di.module;

import android.app.Application;
import android.content.Context;

import com.example.yeol.daggertest.data.AppDataManager;
import com.example.yeol.daggertest.data.DataManager;
import com.example.yeol.daggertest.data.db.AppDbHelper;
import com.example.yeol.daggertest.data.db.DbHelper;
import com.example.yeol.daggertest.data.sharedprefs.AppPreferencesHelper;
import com.example.yeol.daggertest.data.sharedprefs.PreferencesHelper;
import com.example.yeol.daggertest.di.ApplicationContext;
import com.example.yeol.daggertest.di.DatabaseInfo;
import com.example.yeol.daggertest.di.PreferenceInfo;
import com.example.yeol.daggertest.util.AppConstants;

import javax.inject.Singleton;

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
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion(){
        return 1;
    }


    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager){
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper){
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

}
