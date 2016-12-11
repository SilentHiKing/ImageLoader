package com.hiking.imageloader.utils;

import android.graphics.Bitmap;

public class ImageCache {

    MemoryCache mMemoryCache = MemoryCache.getInstance();
    DiskCache mDiskCache = DiskCache.getInstance();

    public Bitmap get(String url) {
        Bitmap bitmap = mMemoryCache.get(url);
        if (bitmap == null) {
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }

    public void put(String url, Bitmap bmp) {
        mMemoryCache.put(url, bmp);
        mDiskCache.put(url, bmp);
    }
}