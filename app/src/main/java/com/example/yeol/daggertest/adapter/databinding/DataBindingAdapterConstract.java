package com.example.yeol.daggertest.adapter.databinding;

/**
 * Created by yeol on 17. 4. 21.
 */

public interface DataBindingAdapterConstract {

    interface View {
        void notifyAdapter();
    }

    interface Model {
        void addItem();
        void clearItem();
    }
}
