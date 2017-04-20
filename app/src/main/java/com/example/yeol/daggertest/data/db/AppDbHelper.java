package com.example.yeol.daggertest.data.db;

import android.content.Context;

import com.example.yeol.daggertest.di.ApplicationContext;
import com.example.yeol.daggertest.di.DatabaseInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by gyl115 on 17. 4. 20.
 */

@Singleton
public class AppDbHelper implements DbHelper {

    public static final String USER_TABLE_NAME = "users";
    public static final String USER_COLUMN_USER_ID = "id";
    public static final String USER_COLUMN_USER_NAME = "usr_name";
    public static final String USER_COLUMN_USER_CREATED_AT = "created_at";
    public static final String USER_COLUMN_USER_UPDATED_AT = "updated_at";

    @Inject
    public AppDbHelper(@ApplicationContext Context context,
                    @DatabaseInfo String dbName,
                    @DatabaseInfo Integer version) {

    }
}
