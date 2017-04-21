package com.example.yeol.daggertest.adapter.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yeol.daggertest.R;
import com.example.yeol.daggertest.data.db.model.User;
import com.example.yeol.daggertest.databinding.RecyclerViewItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeol on 17. 4. 17.
 */

public class DataBindingAdapter extends RecyclerView.Adapter<DataBindingAdapter.ViewHolder>{

    private List<User> Users = new ArrayList<User>();

    @Override
    public DataBindingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user= Users.get(position);
        holder.binding.setUser(user);

    }

    @Override
    public int getItemCount() {
        return Users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        RecyclerViewItemBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
