package com.example.yeol.daggertest.ui.databind;

import com.example.yeol.daggertest.ui.base.BasePresenter;

/**
 * Created by yeol on 17. 4. 20.
 */

public interface DataBindingMvpPresenter<V extends DataBindingMvpView>
        extends BasePresenter<V> {

    void onViewInitialized();

}
