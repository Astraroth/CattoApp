package com.example.cattoapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cattoapp.R;
import com.example.cattoapp.controller.ImageController;
import com.squareup.picasso.Picasso;

public class ImageActivity extends Activity {

    private ImageController controller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_image);
        //getIncomingIntent();

        controller = new ImageController(this);
        controller.onCreate();



    }
    private void getIncomingIntent(){

        Log.d("DETAILS ACTIVITY", "checking for incoming intents");

        if(getIntent().hasExtra("detail_description")&& getIntent().hasExtra("detail_temperament")){

            String detaildescription = getIntent().getStringExtra("detail_description");
            String detailtemperament = getIntent().getStringExtra("detail_temperament");
            //setText(detaildescription, detailtemperament);
        }
    }
    /*private void setText(String image_url){

        TextView url = findViewById(R.id.url);
        url.setText(image_url);

    }*/

    public void showImg(String url){

        ImageView image = findViewById(R.id.catImage);
        //TextView urlTxt = findViewById(R.id.imageUrl);
        //urlTxt.setText(url);
        Picasso.with(getApplicationContext()).load(url).into(image);

    }
}

