package com.example.yeol.daggertest.ui.about;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yeol.daggertest.R;
import com.example.yeol.daggertest.databinding.FragmentAboutBinding;
import com.example.yeol.daggertest.ui.base.BaseFragment;

import javax.inject.Inject;

/**
 * Created by yeol on 17. 4. 20.
 */

public class AboutFragment extends BaseFragment implements AboutMvpView {

    public static final String TAG = "AboutFragment";

    @Inject
    private AboutMvpPresenter<AboutMvpView> mPresenter;

    private FragmentAboutBinding binding;

    public static AboutFragment newInstance(){
        Bundle args = new Bundle();
        AboutFragment fragment = new AboutFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_about,container,false);
        View view = binding.getRoot();

        // Attach AboutFragment to V in presenter that depends on presenters template V.
        mPresenter.onAttach(this);

        return view;
    }

    protected void onNavClick(){
        mPresenter.onNavClick();
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void onDisappeared() {
        getBaseActivity().onFragmentDetach(AboutFragment.class.getSimpleName());
    }
}
