package com.example.yeol.daggertest.adapter.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.yeol.daggertest.R;
import com.example.yeol.daggertest.data.db.model.PictureInfo;
import com.example.yeol.daggertest.databinding.GalleryItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeol on 17. 4. 17.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder>
                                        implements GalleryAdapterConstract.Model,GalleryAdapterConstract.View{

    private List<PictureInfo> pictures = new ArrayList<PictureInfo>();
    private Context mContext;

    public GalleryAdapter(Context context){
        mContext = context;
    }

    @Override
    public GalleryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PictureInfo picture = pictures.get(position);
        Glide.with(mContext).load(picture.image).into(holder.binding.thumbnail);
        holder.binding.pictureName.setText(picture.fileName);
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public void addItem(PictureInfo picture) {
        pictures.add(picture);
    }

    @Override
    public void clearItem() {
        pictures.clear();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        GalleryItemBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            binding = GalleryItemBinding.bind(itemView);
        }
    }
}
