package com.example.cattoapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;
import com.example.cattoapp.controller.ImageController;
import com.squareup.picasso.Picasso;

public class ImageActivity extends Activity {

    private ImageController controller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_image);
        controller = new ImageController(this);
        controller.onCreate();

    }

    public void showImg(String url){

        ImageView image = findViewById(R.id.catImage);
        Picasso.with(getApplicationContext()).load(url).into(image);

    }
}

