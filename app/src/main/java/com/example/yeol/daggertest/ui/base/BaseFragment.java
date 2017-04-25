package com.example.yeol.daggertest.ui.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.yeol.daggertest.di.components.ActivityComponent;

/**
 * Created by yeol on 17. 4. 20.
 */

public abstract class BaseFragment extends Fragment implements MvpView {

    private BaseActivity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if( context instanceof BaseActivity){
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
        }
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void showLoading() {
        if(mActivity != null)
            mActivity.showLoading();
    }

    @Override
    public void hideLoading() {
        if(mActivity != null)
            mActivity.hideLoading();
    }

    @Override
    public void onError(String message) {
        if(mActivity != null)
            mActivity.onError(message);
    }

    @Override
    public void hideKeyboard() {
        if(mActivity != null)
            mActivity.showLoading();
    }

    @Override
    public boolean isNetworkConnected() {
        if(mActivity != null)
            return mActivity.isNetworkConnected();
        return false;
    }

    public ActivityComponent getActivityComponent() {
        return mActivity.getActivityComponent();
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    protected abstract void setUp(View view);

    public interface CallBack {

        void onFragmentAttach();
        void onFragmentDetach(String tag);
    }
}
