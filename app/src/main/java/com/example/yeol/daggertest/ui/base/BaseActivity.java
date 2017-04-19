package com.example.yeol.daggertest.ui.base;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by yeol on 17. 4. 19.
 */

public abstract class BaseActivity extends AppCompatActivity implements MvpView {

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void hideKeyboard() {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    abstract void setup();
}
