package com.example.yeol.daggertest.data;

import com.example.yeol.daggertest.data.db.DbHelper;
import com.example.yeol.daggertest.data.db.model.User;
import com.example.yeol.daggertest.data.sharedprefs.PreferencesHelper;

/**
 * Created by gyl115 on 17. 4. 16.
 */

public interface DataManager extends PreferencesHelper,DbHelper {

    void saveAccessToken(String accessToken);

    String getAccessToken();

    Long createUser(User user);

    User getUser(Long userId);
}
