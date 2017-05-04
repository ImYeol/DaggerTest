package com.example.yeol.daggertest.ui.gallary;

/**
 * Created by yeol on 17. 4. 21.
 */

/**
 * Glide.with(context)
 .load(imageByteArray)
 .asBitmap()
 .placeholder(R.drawable.ic_broken)
 .into(rowImageView);
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.yeol.daggertest.R;
import com.example.yeol.daggertest.databinding.FragmentGalleryBinding;
import com.example.yeol.daggertest.ui.base.BaseFragment;

import javax.inject.Inject;

/**
 *   https://github.com/martin90s/ImagePicker
 *   https://github.com/rezaamostafavi/Android-GalleryView
 *   https://github.com/lauw/Android-SnappingRecyclerView
 *   https://github.com/Suleiman19/Gallery
 *   https://github.com/suhanlee/recyclerview-image-gallery
 */

public class GallaryFragment extends BaseFragment implements GallaryMvpView{


    private FragmentGalleryBinding binding;

    @Inject
    private GallaryMvpPresenter<GallaryMvpView> mPresenter;

    public static GallaryFragment getInstance(){
        Bundle bundle = new Bundle();
        GallaryFragment fragment = new GallaryFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void setUp(View view) {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        /*binding = DataBindingUtil.inflate(inflater, R.layout.fragment_about,container,false);
        binding.setFragment(this);
        View view = binding.getRoot();*/
        View view = inflater.inflate(R.layout.fragment_gallery,container,false);
        getActivityComponent().inject(this);
        // Attach AboutFragment to V in presenter that depends on presenters template V.
        mPresenter.onAttach(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding = FragmentGalleryBinding.bind(getView());
        binding.setFragment(this);
    }

    @Override
    public void onDisappeared() {
        getBaseActivity().onFragmentDetach(GallaryFragment.class.getSimpleName());
    }

    @Override
    public void onDestroyView() {
        mPresenter = null;
        super.onDestroyView();
    }

}
