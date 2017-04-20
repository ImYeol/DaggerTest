package com.example.yeol.daggertest.ui.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.yeol.daggertest.MyApplication;
import com.example.yeol.daggertest.R;
import com.example.yeol.daggertest.data.DataManager;
import com.example.yeol.daggertest.databinding.ActivityMainBinding;
import com.example.yeol.daggertest.di.components.ActivityComponent;
import com.example.yeol.daggertest.di.components.DaggerActivityComponent;
import com.example.yeol.daggertest.di.module.ActivityModule;
import com.example.yeol.daggertest.ui.base.BaseActivity;
import com.example.yeol.daggertest.ui.databind.DataBindingActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMvpView{

    @Inject
    DataManager dataManager;

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    private ActivityComponent activityComponent;
    // generated Binding class by DataBinding
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindAndAttach();
        setUp();
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

    public void onClick(View view){
        Intent intent = new Intent(this, DataBindingActivity.class);
        startActivity(intent);
    }

    @Override
    protected void setUp() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void bindAndAttach() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // DataBinding to set activity value in activity_main.xml
        binding.setActivity(this);
    }
}
