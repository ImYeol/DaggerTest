package com.example.yeol.daggertest.ui.base;

import javax.inject.Inject;

/**
 * Created by yeol on 17. 4. 21.
 */

public class AdapterPresenter<V extends MvpView> implements MvpPresenter<V>  {


    @Inject
    public AdapterPresenter()
    @Override
    public void onAttach(V mvpView) {

    }

    @Override
    public void onDetach() {

    }
}
