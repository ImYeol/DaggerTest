package com.example.yeol.daggertest.di.module;

import android.app.Activity;
import android.content.Context;

import com.example.yeol.daggertest.di.ActivityContext;
import com.example.yeol.daggertest.di.PerActivity;
import com.example.yeol.daggertest.ui.about.AboutMvpPresenter;
import com.example.yeol.daggertest.ui.about.AboutMvpView;
import com.example.yeol.daggertest.ui.about.AboutPresenter;
import com.example.yeol.daggertest.ui.databind.DataBindingMvpPresenter;
import com.example.yeol.daggertest.ui.databind.DataBindingMvpView;
import com.example.yeol.daggertest.ui.databind.DataBindingPresenter;
import com.example.yeol.daggertest.ui.gallary.GallaryMvpPresenter;
import com.example.yeol.daggertest.ui.gallary.GallaryMvpView;
import com.example.yeol.daggertest.ui.gallary.GallaryPresenter;
import com.example.yeol.daggertest.ui.main.MainMvpPresenter;
import com.example.yeol.daggertest.ui.main.MainMvpView;
import com.example.yeol.daggertest.ui.main.MainPresenter;

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


    @Provides
    AboutMvpPresenter<AboutMvpView> provideAboutPresenter(AboutPresenter<AboutMvpView> presenter){
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter){
        return presenter;
    }

    @Provides
    DataBindingMvpPresenter<DataBindingMvpView> provideDataBindingPresenter(DataBindingPresenter<DataBindingMvpView> presenter){
        return presenter;
    }

    @Provides
    GallaryMvpPresenter<GallaryMvpView> provideGallaryPresenter(GallaryPresenter<GallaryMvpView> presenter) {
        return presenter;
    }

}
