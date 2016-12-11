package com.hiking.imageloader.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by H on 2016/12/10.
 */
public class DiskCache {

    private String TAG = DiskCache.class.getSimpleName();

    String cacheDir = getCachePath();

    private static DiskCache diskCache;

    private DiskCache(){};

    public static DiskCache getInstance(){
        if (diskCache ==null){
            diskCache = new DiskCache();
        }
        return diskCache;
    }

    public Bitmap get(String url) {
        return BitmapFactory.decodeFile(cacheDir + "/"+url);
    }

    public void put(String url, Bitmap bmp) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(cacheDir + url);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public String getCachePath(){
        Log.d(TAG,Environment.getExternalStorageDirectory().getAbsolutePath());
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }
}
