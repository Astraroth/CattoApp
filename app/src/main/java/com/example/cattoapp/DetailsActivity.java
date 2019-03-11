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

    private String[] cats = {"Abyssinian", "Aegean", "American Bobtail", "American Curl", "American Shorthair", "American Wirehair","Arabian Mau",
                            "Australian Mist", "Balinese", "Bambino", "Bengal", "Birman", "Bombay", "British Longhair", "British Shorthair",
                            "Burmese", "Burmilla", "California Spangled", /*"Chantilly-Tiffany", "Chartreux", "Chausie", "Cheetoh", "Colorpoint Shorthair",
                            "Cornish Rex", "Cymric", "Cyprus", "Devon Rex", "Donskoy", "Dragon li", "Egyptian Mau", "European Burmese", "Excotic Shorthair",
                            "Havana Brown", "Himalayan", "Japanese Bobtail", "Javanese", "Khao Manee","Korat", "Kurilian", "LaPerm", "Maine Coon", "Manx",
                            "Munchkin", "Nebelung", "Norwegian Forest Cat", "Ocicat", "Oriental", "Persian", "Pixie-bob", "Ragamuffin", "Ragdoll",
                            "Russian Blue", "Savannah", "Scottish Fold", "Selkirk Rex", "Siamese", "Siberian", "Singapura", "Snowshoe", "Somali",
                            "Sphynx", "Tonkinese", "Toyger", "Turkish Angora", "Turkish Van", "York Chocolate"*/};

    private String [] images = {"https://cdn2.thecatapi.com/images/9x1zk_Qdr.jpg", //abys
            "https://cdn2.thecatapi.com/images/ozEvzdVM-.jpg", //aegean
            "https://mag.bullebleue.fr/sites/mag/files/img/races/chat/american-bobtail.jpg", //ambobtail
            "https://cdn2.thecatapi.com/images/vJB8rwfdX.jpg", //amcurl
            "https://cdn2.thecatapi.com/images/SCHe-SekW.jpg", //amshorthair
            "https://cdn2.thecatapi.com/images/Q6TDnfM_O.jpg", //amwirehair
            "https://cdn2.thecatapi.com/images/zlpgGWqN7.jpg", //arabmau
            "https://cdn2.thecatapi.com/images/zTiuUpmqf.jpg", //austmist
            "https://vetstreet.brightspotcdn.com/dims4/default/4582c28/2147483647/thumbnail/645x380/quality/90/?url=https%3A%2F%2Fvetstreet-brightspot.s3.amazonaws.com%2Fa3%2F81%2Fa3e95fcf434eb8012b201d57da81%2FBalinese-AP-1TMNL9-645sm3614.jpg", //balinese
            "https://www.omlet.fr/images/cache/1024/682/Cat-Bambino-The_short_legged_bambino_cat_with_golden_eyes.jpg",  //bambino
            "https://cdn2.thecatapi.com/images/iWyIaja-G.jpg", //bengal
            "https://www.chatterieleclosdelorme.eu/ressources/images/177d70966a6c.jpg",//birman
            "https://cdn2.thecatapi.com/images/Z6mrcccZv.jpg",//bombay
            "https://cdn2.thecatapi.com/images/YZGOUtRQ1.jpg",//britishlong
            "https://cdn2.thecatapi.com/images/ZdhQh9wc9.jpg",//britishshort
            "https://www.thehappycatsite.com/wp-content/uploads/2017/09/burmese.jpg",//burmese
            "https://cdn2.thecatapi.com/images/jvg3XfEdC.jpg",//burmilla
            "http://www.catbreedslist.com/uploads/allimg/cat_anim-pictures/California-Spangled-Cat-2.jpg"//california
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getIncomingIntent();

        final ImageView image = findViewById(R.id.detailimage);
        final String name = getIntent().getStringExtra("detail_name"); //name of cat_anim

        for(Integer i = 0; i < cats.length; i++){
            if(name.equals(cats[i])){
                showImg(images[i]);
            }
        }
    }

    private void getIncomingIntent(){

        Log.d("DETAILS ACTIVITY", "checking for incoming intents");

        if(getIntent().hasExtra("detail_description")&& getIntent().hasExtra("detail_temperament")
                                                            && getIntent().hasExtra("detail_name")){

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

   public void showImg(String url){

        ImageView image = findViewById(R.id.detailimage);

        Picasso.with(getApplicationContext())
            .load(url)
                .placeholder(R.drawable.nyancaticon)
                .into(image);
}

}
