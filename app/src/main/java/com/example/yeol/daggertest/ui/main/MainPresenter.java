package com.example.yeol.daggertest.ui.main;

import com.example.yeol.daggertest.data.DataManager;
import com.example.yeol.daggertest.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by yeol on 17. 4. 19.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V>  {


    @Inject
    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onViewInitialized() {

    }

    @Override
    public void onNavMenuCreated() {
        if (!isViewAttached()) {
            return;
        }
        getMvpView().updateAppVersion();

        final String currentUserName = getDataManager().getCurrentUserName();
        if (currentUserName != null && !currentUserName.isEmpty()) {
            getMvpView().updateUserName(currentUserName);
        }

        final String currentUserEmail = getDataManager().getCurrentUserEmail();
        if (currentUserEmail != null && !currentUserEmail.isEmpty()) {
            getMvpView().updateUserEmail(currentUserEmail);
        }

        final String profilePicUrl = getDataManager().getCurrentUserProfilePicUrl();
        if (profilePicUrl != null && !profilePicUrl.isEmpty()) {
            getMvpView().updateUserProfilePic(profilePicUrl);
        }
    }

    @Override
    public void onDrawerOptionAboutClick() {
        getMvpView().showAboutFragment();
    }

    @Override
    public void onDrawerOptionDataBindingExampleClick() {

    }

    @Override
    public void onDrawerOptionGallaryClick() {

        getMvpView().showGallaryFragment();

    }
}
