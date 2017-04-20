package com.example.yeol.daggertest.ui.databind;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yeol.daggertest.R;
import com.example.yeol.daggertest.databinding.RecyclerViewBinding;
import com.example.yeol.daggertest.ui.base.BaseFragment;

/**
 * Created by yeol on 17. 4. 17.
 */

public class DataBindingFragment extends BaseFragment
        implements DataBindingMvpView {

    RecyclerViewBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(this, R.layout.recycler_view);
        binding.setActivity(this);
    }

    @Override
    protected void setUp(View view) {

    }


    private void setRecyclerView() {
        DataBindingAdapter adapter = new DataBindingAdapter();
        binding.recyclerView.setAdapter(adapter);

    }



    public void onButtonClick(View view){
        Toast.makeText(this,"Button Click", Toast.LENGTH_SHORT).show();
    }

}
