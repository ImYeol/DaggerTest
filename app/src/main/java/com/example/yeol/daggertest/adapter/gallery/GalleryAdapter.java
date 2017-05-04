package com.example.yeol.daggertest.adapter.gallery;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yeol.daggertest.R;
import com.example.yeol.daggertest.data.db.model.User;
import com.example.yeol.daggertest.databinding.GalleryItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeol on 17. 4. 17.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder>
                                        implements GalleryAdapterConstract.Model,GalleryAdapterConstract.View{

    private List<Uri> Users = new ArrayList<Uri>();
    private List<String> FileNames = new ArrayList<String>();

    public GalleryAdapter(){

    }

    @Override
    public GalleryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user= Users.get(position);
        holder.binding.setPicture();
    }

    @Override
    public int getItemCount() {
        return Users.size();
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public void addItem(User user) {
        Users.add(user);
    }

    @Override
    public void clearItem() {
        Users.clear();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        GalleryItemBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            binding = GalleryItemBinding.bind(itemView);
        }
    }
}
