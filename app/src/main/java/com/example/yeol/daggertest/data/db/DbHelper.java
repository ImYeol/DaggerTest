package com.example.yeol.daggertest.data.db;

import com.example.yeol.daggertest.data.db.model.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by gyl115 on 17. 4. 16.
 */

public interface DbHelper {
    Observable<Long> insertUser(final User user);

    Observable<List<User>> getAllUsers();

}
