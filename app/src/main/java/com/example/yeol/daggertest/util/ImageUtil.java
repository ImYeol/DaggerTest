package com.example.yeol.daggertest.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by yeol on 17. 4. 17.
 */

public class ImageUtil {

    public static void loadImage(ImageView imageView, String URL, Drawable errorDrawable){
        Glide.with(imageView.getContext()).load(URL).error(errorDrawable).into(imageView);
    }

    public static Bitmap getBitmapFromString(String stringPicture) {
    /*
     * This Function converts the String back to Bitmap
    * */
        byte[] decodedString = Base64.decode(stringPicture, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }
}
