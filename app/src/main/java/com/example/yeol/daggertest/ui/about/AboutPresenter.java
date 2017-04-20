package com.example.yeol.daggertest.ui.about;

import com.example.yeol.daggertest.data.DataManager;
import com.example.yeol.daggertest.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by yeol on 17. 4. 20.
 */

public class AboutPresenter<V extends AboutMvpView> extends BasePresenter<V>
        implements AboutMvpPresenter<V> {

    @Inject
    public AboutPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onNavClick() {

        // getMvpView returns AboutMvpView
        // because template V is set to AboutMvpView and
        getMvpView().onDisappeared();
    }
}
