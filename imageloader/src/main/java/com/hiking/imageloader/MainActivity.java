package com.hiking.imageloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.hiking.imageloader.utils.ImageLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv =(ImageView)findViewById(R.id.iv);
        ImageLoader imageLoader = new ImageLoader();
        imageLoader.displayImage("http://img.67.com/thumbs/upload/images/2016/10/28/c2hlbnppY2hhbzE0Nzc2MTg1MjE=_w570_t.jpg",iv);
    }


}
