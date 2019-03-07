package com.example.cattoapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cattoapp.R;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    private Context context;
    private String url = "https://cdn2.thecatapi.com/images/0c9_EEtqQ.jpg";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);
        getIncomingIntent();

        final ImageView image = findViewById(R.id.detailimage);
        Picasso.with(getApplicationContext())
                .load(url)
                .placeholder(R.drawable.nyancaticon)
                .into(image);
        showImg(url);
    }

    private void getIncomingIntent(){

        Log.d("DETAILS ACTIVITY", "checking for incoming intents");

        if(getIntent().hasExtra("detail_description")&& getIntent().hasExtra("detail_temperament")
                                                            && getIntent().hasExtra("detail_name")){

            String detaildescription = getIntent().getStringExtra("detail_description");
            String detailtemperament = getIntent().getStringExtra("detail_temperament");
            String detailname = getIntent().getStringExtra("detail_name");
            setText(detaildescription, detailtemperament, detailname);
        }

    }

    private void setText(String detail_description, String detail_temperament, String detail_name){

        TextView description = findViewById(R.id.description);
        description.setText(detail_description);

        TextView temperament = findViewById(R.id.temperament);
        temperament.setText(detail_temperament);

        TextView name = findViewById(R.id.name);
        name.setText(detail_name);

    }

   public void showImg(String url){

        ImageView image = findViewById(R.id.detailimage);
        Picasso.with(getApplicationContext())
            .load(url)
                .placeholder(R.drawable.nyancaticon)
                .into(image);
}

}
