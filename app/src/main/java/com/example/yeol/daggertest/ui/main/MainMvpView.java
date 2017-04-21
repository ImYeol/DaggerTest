package com.example.yeol.daggertest.ui.main;

import com.example.yeol.daggertest.ui.base.MvpView;

/**
 * Created by yeol on 17. 4. 19.
 */

public interface MainMvpView extends MvpView {

    void showAboutFragment();

    void showDatabindingFragment();

    void showGallaryFragment();

    void updateUserName(String currentUserName);

    void updateUserEmail(String currentUserEmail);

    void updateUserProfilePic(String currentUserProfilePicUrl);

    void updateAppVersion();

}
