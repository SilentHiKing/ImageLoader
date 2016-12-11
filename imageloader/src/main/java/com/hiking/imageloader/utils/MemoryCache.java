package com.hiking.imageloader.utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

/**
 * Created by H on 2016/12/10.
 */
public class MemoryCache {

    private static MemoryCache imageCache;
    // 􀁜􀂟 LRU 􀂻􀁦
    LruCache<String, Bitmap> mImageCache;
    private MemoryCache() {
        initImageCache();
    }

    public static MemoryCache getInstance(){
        if(imageCache == null){
            imageCache = new MemoryCache();
        }
        return imageCache;
    }

    private void initImageCache() {
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxMemory / 4;
        mImageCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    public void put(String url, Bitmap bitmap) {
        mImageCache.put(url, bitmap) ;
    }

    public Bitmap get(String url) {
        return mImageCache.get(url) ;
    }
}
