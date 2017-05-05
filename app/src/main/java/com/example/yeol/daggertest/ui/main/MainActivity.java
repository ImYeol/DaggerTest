package com.example.yeol.daggertest.ui.main;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.yeol.daggertest.MyApplication;
import com.example.yeol.daggertest.R;
import com.example.yeol.daggertest.data.DataManager;
import com.example.yeol.daggertest.databinding.ActivityMainBinding;
import com.example.yeol.daggertest.di.components.ActivityComponent;
import com.example.yeol.daggertest.di.components.DaggerActivityComponent;
import com.example.yeol.daggertest.di.module.ActivityModule;
import com.example.yeol.daggertest.ui.about.AboutFragment;
import com.example.yeol.daggertest.ui.base.BaseActivity;
import com.example.yeol.daggertest.ui.custom.RoundedImageView;
import com.example.yeol.daggertest.ui.databind.DataBindingFragment;
import com.example.yeol.daggertest.ui.gallary.GallaryFragment;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    DataManager dataManager;

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    Toolbar mToolbar;

    DrawerLayout mDrawer;

    private TextView mNameTextView;

    private TextView mEmailTextView;

    private RoundedImageView mProfileImageView;

    private ActionBarDrawerToggle mDrawerToggle;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        switch (item.getItemId()) {
            case R.id.action_cut:
                return true;
            case R.id.action_copy:
                return true;
            case R.id.action_share:
                return true;
            case R.id.action_delete:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void setUp() {

        getActivityComponent().inject(this);
        mPresenter.onAttach(this);

        setSupportActionBar(binding.toolbar);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                binding.drawerView,
                binding.toolbar,
                R.string.open_drawer,
                R.string.close_drawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                hideKeyboard();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        binding.drawerView.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        setUpNavMenu();
        mPresenter.onNavMenuCreated();
        mPresenter.onViewInitialized();
    }

    @Override
    protected void bindAndAttach() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // DataBinding to set activity value in activity_main.xml
        binding.setActivity(this);
    }

    @Override
    protected void onDestroy() {
        mPresenter = null;
        super.onDestroy();
    }

    @Override
    public void onFragmentAttach() {
        if (binding.drawerView != null)
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    @Override
    public void onFragmentDetach(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .remove(fragment)
                    .commitNow();
            if (binding.drawerView != null)
                binding.drawerView.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }
    }

    @Override
    public void showAboutFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .add(R.id.cl_root_view, AboutFragment.newInstance(), AboutFragment.TAG)
                .commit();
    }

    @Override
    public void showDatabindingFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .add(R.id.cl_root_view, DataBindingFragment.newInstance(), DataBindingFragment.TAG)
                .commit();
    }

    @Override
    public void showGallaryFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .add(R.id.cl_root_view, GallaryFragment.newInstance(), AboutFragment.TAG)
                .commit();
    }

    @Override
    public void updateUserName(String currentUserName) {
        mNameTextView.setText(currentUserName);
    }

    @Override
    public void updateUserEmail(String currentUserEmail) {
        mEmailTextView.setText(currentUserEmail);
    }

    @Override
    public void updateUserProfilePic(String currentUserProfilePicUrl) {

    }

    @Override
    public void updateAppVersion() {

    }

    void setUpNavMenu(){
        View headerLayout = binding.navigationView.getHeaderView(0);
        mProfileImageView = (RoundedImageView) headerLayout.findViewById(R.id.iv_profile_pic);
        mNameTextView = (TextView) headerLayout.findViewById(R.id.tv_name);
        mEmailTextView = (TextView) headerLayout.findViewById(R.id.tv_email);

        binding.navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        binding.drawerView.closeDrawer(GravityCompat.START);
                        switch (item.getItemId()) {
                            case R.id.nav_item_about:
                                mPresenter.onDrawerOptionAboutClick();
                                return true;
                            case R.id.nav_item_databinding:
                                mPresenter.onDrawerOptionDataBindingExampleClick();
                                return true;
                            case R.id.nav_item_gallary:
                                mPresenter.onDrawerOptionGallaryClick();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
    }
}
