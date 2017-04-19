package com.example.yeol.daggertest.di.module;

import android.app.Service;

import dagger.Module;

/**
 * Created by yeol on 17. 4. 19.
 */

@Module
public class ServiceModule {

    private final Service mService;

    public ServiceModule(Service service){
        this.mService = service;
    }

}
