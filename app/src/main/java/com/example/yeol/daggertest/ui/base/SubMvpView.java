package com.example.yeol.daggertest.ui.base;

/**
 * Created by yeol on 17. 4. 20.
 */

public interface SubMvpView extends MvpView {

    void onCreate();

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void attachParentMvpView(MvpView mvpView);
}
