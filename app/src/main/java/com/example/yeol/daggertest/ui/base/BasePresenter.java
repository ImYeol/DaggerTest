package com.example.yeol.daggertest.ui.base;

import android.provider.ContactsContract;

import com.example.yeol.daggertest.data.DataManager;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by yeol on 17. 4. 19.
 */

public abstract class BasePresenter<V extends MvpView> implements MvpPresenter<V> {


    private final DataManager mDataManager;
    private final CompositeDisposable mCompositeDisposable;
    private V mMvpView;

    @Inject
    public BasePresenter(DataManager dataManager, CompositeDisposable compositeDisposable){
        mDataManager = dataManager;
        mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        mMvpView = null;
    }

    public boolean isViewAttached(){
        return mMvpView != null;
    }

    public V getMvpView(){
        return mMvpView;
    }

    public DataManager getDataManager(){
        return mDataManager;
    }

    public CompositeDisposable getCompositeDisposable(){
        return mCompositeDisposable;
    }
}
