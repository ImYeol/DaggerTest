package com.example.yeol.daggertest.di.components;

import android.app.Application;
import android.content.Context;

import com.example.yeol.daggertest.MyApplication;
import com.example.yeol.daggertest.data.DataManager;
import com.example.yeol.daggertest.data.DbHelper;
import com.example.yeol.daggertest.data.SharedPrefsHelper;
import com.example.yeol.daggertest.di.ApplicationContext;
import com.example.yeol.daggertest.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by gyl115 on 17. 4. 16.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    // arg is a instance that should be filled by dependencies supported from the module
    void inject(MyApplication myApplication);

    // need to write get method to get dependencies from the module

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPrefsHelper();

    DbHelper getDbHelper();

}
