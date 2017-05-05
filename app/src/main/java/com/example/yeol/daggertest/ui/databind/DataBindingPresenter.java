package com.example.yeol.daggertest.ui.databind;

import com.example.yeol.daggertest.adapter.databinding.DataBindingAdapterConstract;
import com.example.yeol.daggertest.data.DataManager;
import com.example.yeol.daggertest.data.db.model.User;
import com.example.yeol.daggertest.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by gyl115 on 17. 4. 20.
 */

public class DataBindingPresenter<V extends DataBindingMvpView> extends BasePresenter<V>
                                        implements DataBindingMvpPresenter<V>{

    private DataBindingAdapterConstract.View adapterView;
    private DataBindingAdapterConstract.Model adapterModel;


    @Inject
    public DataBindingPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onViewInitialized() {

    }

    @Override
    public void notifyAdapter() {
        adapterView.notifyAdapter();
    }

    @Override
    public void addItem(User user) {
        adapterModel.addItem(user);
    }

    @Override
    public void clearItem() {
        adapterModel.clearItem();
    }

    @Override
    public void setAdapterModel(DataBindingAdapterConstract.Model model) {
        adapterModel = model;
    }

    @Override
    public void setAdapterView(DataBindingAdapterConstract.View view) {
        adapterView = view;
    }
}
