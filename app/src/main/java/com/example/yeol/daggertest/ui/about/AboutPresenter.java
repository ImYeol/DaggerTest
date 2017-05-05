package com.example.yeol.daggertest.ui.about;

import com.example.yeol.daggertest.data.DataManager;
import com.example.yeol.daggertest.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by yeol on 17. 4. 20.
 */

public class AboutPresenter<V extends AboutMvpView> extends BasePresenter<V>
        implements AboutMvpPresenter<V> {

    @Inject
    public AboutPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onNavClick() {

        // getMvpView returns AboutMvpView
        // because template V is set to AboutMvpView and
        getMvpView().onDisappeared();
    }
}
