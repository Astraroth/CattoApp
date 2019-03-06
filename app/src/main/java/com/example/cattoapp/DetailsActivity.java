package com.example.cattoapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);
        getIncomingIntent();

    }

    private void getIncomingIntent(){

        Log.d("DETAILS ACTIVITY", "checking for incoming intents");

        if(getIntent().hasExtra("detail_description")&& getIntent().hasExtra("detail_temperament")){

            String detaildescription = getIntent().getStringExtra("detail_description");
            String detailtemperament = getIntent().getStringExtra("detail_temperament");
            setText(detaildescription, detailtemperament);
        }
    }

    private void setText(String detail_description, String detail_temperament){

        TextView description = findViewById(R.id.description);
        description.setText(detail_description);

        TextView temperament = findViewById(R.id.temperament);
        temperament.setText(detail_temperament);

    }

   /*public void showImg(String url){

        ImageView image = findViewById(R.id.detailimage);
        //TextView urlTxt = findViewById(R.id.url);
        //urlTxt.setText(url);
        Picasso.with(getApplicationContext()).load(url).into(image);

    }*/

}
