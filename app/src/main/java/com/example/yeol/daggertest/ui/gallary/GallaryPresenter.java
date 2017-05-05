package com.example.yeol.daggertest.ui.gallary;

import com.example.yeol.daggertest.adapter.gallery.GalleryAdapterConstract;
import com.example.yeol.daggertest.data.DataManager;
import com.example.yeol.daggertest.data.db.model.PictureInfo;
import com.example.yeol.daggertest.service.BluetoothSyncService;
import com.example.yeol.daggertest.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by yeol on 17. 4. 21.
 */

public class GallaryPresenter<V extends GallaryMvpView> extends BasePresenter<V>
                                                    implements GallaryMvpPresenter<V>,BluetoothSyncService.Callback{

    private GalleryAdapterConstract.Model model;
    private GalleryAdapterConstract.View view;

    @Inject
    public GallaryPresenter(DataManager dataManager){
        super(dataManager);
    }

    @Override
    public void insertImage(byte[] image) {

    }

    @Override
    public void sync() {

    }

    @Override
    public void setAdapterModel(GalleryAdapterConstract.Model model) {
        this.model = model;
    }

    @Override
    public void setAdapterView(GalleryAdapterConstract.View view) {
        this.view = view;
    }

    @Override
    public void clear() {
        model.clearItem();
    }

    @Override
    public void onRecevied(PictureInfo picture) {
        model.addItem(picture);
        view.notifyAdapter();
    }
}
