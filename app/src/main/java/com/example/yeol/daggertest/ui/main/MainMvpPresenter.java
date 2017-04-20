package com.example.yeol.daggertest.ui.main;

import com.example.yeol.daggertest.di.PerActivity;
import com.example.yeol.daggertest.ui.base.MvpPresenter;
import com.example.yeol.daggertest.ui.base.MvpView;

/**
 * Created by yeol on 17. 4. 19.
 */
@PerActivity
public interface MainMvpPresenter<v extends MvpView> extends MvpPresenter<v> {

    void onViewInitialized();

    void onNavMenuCreated();

    void onDrawerOptionDataBindingExampleClick();

    void onDrawerOptionBluetoothExampleClick();
}
