package com.example.yeol.daggertest.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yeol.daggertest.MyApplication;
import com.example.yeol.daggertest.R;
import com.example.yeol.daggertest.data.DataManager;
import com.example.yeol.daggertest.di.components.ActivityComponent;
import com.example.yeol.daggertest.di.components.DaggerActivityComponent;
import com.example.yeol.daggertest.di.module.ActivityModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    DataManager dataManager;

    private ActivityComponent activityComponent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);
    }

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(MyApplication.get(this).getComponent())
                    .build();

            // for easy to read , method to get application instance is in application class
        }
        return activityComponent;
    }
}