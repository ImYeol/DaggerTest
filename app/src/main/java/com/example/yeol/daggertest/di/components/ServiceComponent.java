package com.example.yeol.daggertest.di.components;

import android.app.Service;

import com.example.yeol.daggertest.di.module.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by yeol on 17. 4. 19.
 */
@Singleton
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

    void inject(Service service);
}
