package com.example.yeol.daggertest.ui.about;

import com.example.yeol.daggertest.di.PerActivity;
import com.example.yeol.daggertest.ui.base.MvpPresenter;

/**
 * Created by yeol on 17. 4. 20.
 */

@PerActivity
public interface AboutMvpPresenter<V extends AboutMvpView> extends MvpPresenter<V>{

    void onNavClick();
}
