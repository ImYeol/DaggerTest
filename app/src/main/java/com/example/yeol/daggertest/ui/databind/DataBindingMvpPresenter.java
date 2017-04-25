package com.example.yeol.daggertest.ui.databind;

import com.example.yeol.daggertest.adapter.databinding.DataBindingAdapterConstract;
import com.example.yeol.daggertest.data.db.model.User;
import com.example.yeol.daggertest.ui.base.MvpPresenter;

/**
 * Created by yeol on 17. 4. 20.
 */

public interface DataBindingMvpPresenter<V extends DataBindingMvpView>
        extends MvpPresenter<V> {

    void onViewInitialized();

    void notifyAdapter();
    void addItem(User user);
    void clearItem();

    void setAdapterModel(DataBindingAdapterConstract.Model model);

    void setAdapterView(DataBindingAdapterConstract.View view);

}
