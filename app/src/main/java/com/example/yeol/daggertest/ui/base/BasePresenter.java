package com.example.yeol.daggertest.ui.base;

import com.example.yeol.daggertest.data.DataManager;

import javax.inject.Inject;

/**
 * Created by yeol on 17. 4. 19.
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {


    private final DataManager mDataManager;
  //  private final CompositeDisposable mCompositeDisposable;
    private V mMvpView;

    @Inject
    public BasePresenter(DataManager dataManager){
        mDataManager = dataManager;
        //mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
     //   mCompositeDisposable.dispose();
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


}
