package com.example.yeol.daggertest.ui.databind.example;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.yeol.daggertest.R;
import com.example.yeol.daggertest.databinding.RecyclerViewBinding;

/**
 * Created by yeol on 17. 4. 17.
 */

public class DataBindingActivity extends AppCompatActivity {

    RecyclerViewBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.recycler_view);
        binding.setActivity(this);
        setRecyclerView();

    }


    private void setRecyclerView() {
        DataBindingAdapter adapter = new DataBindingAdapter();
        binding.recyclerView.setAdapter(adapter);

    }



    public void onButtonClick(View view){
        Toast.makeText(this,"Button Click", Toast.LENGTH_SHORT).show();
    }

}
