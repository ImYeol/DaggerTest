package com.example.yeol.daggertest.data;

import com.example.yeol.daggertest.data.db.model.User;

/**
 * Created by gyl115 on 17. 4. 16.
 */

public interface DataManager {

    void saveAccessToken(String accessToken);

    String getAccessToken();

    Long createUser(User user);

    User getUser(Long userId);
}
