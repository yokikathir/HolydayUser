package com.kathir.holyday.utils;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


/**
 *
 */
public class GlideUtil {

    private static final String TAG = "GlideUtil";
    private static GlideUtil glideUtil = new GlideUtil();
    private GlideUtil() {

    }

    public static GlideUtil getInstance() {
        return glideUtil;
    }

    public void loadImage(Context context, ImageView imageView, String url) {
        if (null != context && null != imageView && null != url) {
            try {

                Glide.with(context).load(url)
                        .thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL)//DiskCacheStrategy.NONE --> If you dont want cache
                        .into(imageView);
            } catch (Exception e) {
                Log.e(TAG, "loadImage: ", e);
            }

        }
    }

    public void loadImage(Context context, ImageView imageView, String url, int placeHolder) {
        if (null != context && null != imageView && null != url) {

            Glide.with(context).load(url)
                    .thumbnail(0.5f)
                    .placeholder(placeHolder)
                    .dontAnimate()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//DiskCacheStrategy.NONE --> If you dont want cache
                    .into(imageView);
        }
    }

}
