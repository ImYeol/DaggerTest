package com.example.yeol.daggertest.util;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by yeol on 17. 4. 17.
 */

public class ImageUtil {

    public static void loadImage(ImageView imageView, String URL, Drawable errorDrawable){
        Glide.with(imageView.getContext()).load(URL).error(errorDrawable).into(imageView);
    }
}
