package com.example.yeol.daggertest.ui.base;

/**
 * Created by yeol on 17. 4. 19.
 */

public interface MvpView {

    void bindAndAttach();

    void showLoading();

    void hideLoading();

    void onError(String message);

    void hideKeyboard();

    boolean isNetworkConnected();

}
