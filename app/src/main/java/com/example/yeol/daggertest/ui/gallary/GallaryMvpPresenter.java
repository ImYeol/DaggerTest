package com.example.yeol.daggertest.ui.gallary;

import com.example.yeol.daggertest.adapter.gallery.GalleryAdapterConstract;
import com.example.yeol.daggertest.ui.base.MvpPresenter;

/**
 * Created by yeol on 17. 4. 21.
 */

public interface GallaryMvpPresenter<V extends GallaryMvpView> extends MvpPresenter<V> {

    void insertImage(byte[] image);

    void sync();

    void setAdapterModel(GalleryAdapterConstract.Model model);

    void setAdapterView(GalleryAdapterConstract.View view);

    void clear();
}
