package com.rayyeung.library.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.rayyeung.library.R;


/**
 * Created by RayYeung on 2016/7/11.
 */
public class ImageLoader {


    public static void displayImage(String uri, ImageView view) {
        Glide.with(view.getContext()).load(uri).placeholder(R.drawable.image_loading).diskCacheStrategy(DiskCacheStrategy.ALL).into(view);
    }

    public static void displayAvatar(String uri, ImageView view) {
        Glide.with(view.getContext()).load(uri).placeholder(R.drawable.image_loading).into(view);
    }

    public static void displayBigImage(String uri, ImageView view) {
        Glide.with(view.getContext()).load(uri).into(view);
    }


    public interface LoadingListener {
        void onLoadingComplete(Bitmap loadedImage);
    }
}
