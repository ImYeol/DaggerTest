package com.example.yeol.daggertest.adapter.gallery;

import com.example.yeol.daggertest.data.db.model.PictureInfo;

/**
 * Created by yeol on 17. 4. 21.
 */

public interface GalleryAdapterConstract {

    interface View {
        void notifyAdapter();
    }

    interface Model {
        void addItem(PictureInfo picture);
        void clearItem();
    }
}
