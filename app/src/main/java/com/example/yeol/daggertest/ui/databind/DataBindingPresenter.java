package com.example.yeol.daggertest.ui.databind;

import com.example.yeol.daggertest.data.DataManager;
import com.example.yeol.daggertest.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by gyl115 on 17. 4. 20.
 */

public class DataBindingPresenter<V extends DataBindingMvpView> extends BasePresenter<V>
                                        implements DataBindingMvpPresenter<V>{

    @Inject
    public DataBindingPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

}
