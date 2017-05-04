package com.example.yeol.daggertest.ui.gallary;

import com.example.yeol.daggertest.data.DataManager;
import com.example.yeol.daggertest.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by yeol on 17. 4. 21.
 */

public class GallaryPresenter<V extends GallaryMvpView> extends BasePresenter<V>
                                                    implements GallaryMvpPresenter<V> {


    @Inject
    public GallaryPresenter(DataManager dataManager, CompositeDisposable compositeDisposable){
        super(dataManager,compositeDisposable);
    }

    @Override
    public void insertImage(byte[] image) {

    }

    @Override
    public void sync() {

    }
}
