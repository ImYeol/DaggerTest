package com.example.yeol.daggertest.ui.databind.example;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.example.yeol.daggertest.util.ImageUtil;
import android.databinding.BindingAdapter;

/**
 * Created by gyl115 on 17. 4. 17.
 */

public class BindingAdapterHelper {

    @BindingAdapter({"bind:imgURL", "bind:error"})
    public static void loadImage(ImageView imageView, String url, Drawable errorDrawable) {
        ImageUtil.loadImage(imageView, url, errorDrawable);
    }

}
