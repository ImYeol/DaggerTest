package com.example.yeol.daggertest.di.components;

import com.example.yeol.daggertest.di.PerActivity;
import com.example.yeol.daggertest.di.module.ActivityModule;
import com.example.yeol.daggertest.ui.main.MainActivity;
import dagger.Component;

/**
 * Created by gyl115 on 17. 4. 17.
 */

// As scope It tells Dagger that context,Activity provided by Activity Module will be instantiated
// each time Activity is created. dependencies instance should be changed depending on Context,Activity creation
// But DataManager in MainActivity is instantiated only one time ( @Singlton )
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
