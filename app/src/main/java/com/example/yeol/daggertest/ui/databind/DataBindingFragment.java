package com.example.yeol.daggertest.ui.databind;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yeol.daggertest.R;
import com.example.yeol.daggertest.adapter.databinding.DataBindingAdapter;
import com.example.yeol.daggertest.databinding.RecyclerViewBinding;
import com.example.yeol.daggertest.ui.base.BaseFragment;

import javax.inject.Inject;

/**
 * Created by yeol on 17. 4. 17.
 */

public class DataBindingFragment extends BaseFragment
        implements DataBindingMvpView {

    public static final String TAG="DataBindingFragment";
    RecyclerViewBinding binding;

    @Inject
    DataBindingMvpPresenter<DataBindingMvpView> mPresenter;

    public static DataBindingFragment newInstance(){
        Bundle args = new Bundle();
        DataBindingFragment dataBindingFragment = new DataBindingFragment();
        dataBindingFragment.setArguments(args);
        return dataBindingFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       /* binding = DataBindingUtil.setContentView(this, R.layout.recycler_view);
        binding.setFragment(this);
        View view = binding.getRoot();*/
        View view = inflater.inflate(R.layout.recycler_view,container,false);
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
        setRecyclerView();
        return view;
    }

    @Override
    protected void setUp(View view) {

    }


    private void setRecyclerView() {
        DataBindingAdapter adapter = new DataBindingAdapter();
        binding.recyclerView.setAdapter(adapter);
        mPresenter.setAdapterModel(adapter);
        mPresenter.setAdapterView(adapter);
    }

}
