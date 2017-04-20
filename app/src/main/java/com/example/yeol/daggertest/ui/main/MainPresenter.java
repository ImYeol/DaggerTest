package com.example.yeol.daggertest.ui.main;

import com.example.yeol.daggertest.data.DataManager;
import com.example.yeol.daggertest.ui.base.BasePresenter;
import com.example.yeol.daggertest.ui.base.MvpView;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by yeol on 17. 4. 19.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V>  {


    @Inject
    public MainPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onViewInitialized() {

    }

    @Override
    public void onNavMenuCreated() {

    }

    @Override
    public void onDrawerOptionDataBindingExampleClick() {

    }

    @Override
    public void onDrawerOptionBluetoothExampleClick() {

    }
}
