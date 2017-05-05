package com.example.yeol.daggertest.data;

import com.example.yeol.daggertest.data.db.DbHelper;
import com.example.yeol.daggertest.data.sharedprefs.PreferencesHelper;
import com.example.yeol.daggertest.service.BluetoothSyncService;

/**
 * Created by gyl115 on 17. 4. 16.
 */

public interface DataManager extends PreferencesHelper,DbHelper {

    void startBtSyncService();

    void setBluetoothCallback(BluetoothSyncService.Callback callback);
}
