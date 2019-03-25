package com.example.cattoapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cattoapp.R;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    private String[] cats = {"Abyssinian", "Aegean", "American Bobtail", "American Curl", "American Shorthair", "American Wirehair","Arabian Mau",
                            "Australian Mist", "Balinese", "Bambino", "Bengal", "Birman", "Bombay", "British Longhair", "British Shorthair",
                            "Burmese", "Burmilla", "California Spangled", "Chantilly-Tiffany", "Chartreux", "Chausie", "Cheetoh", "Colorpoint Shorthair",
                            "Cornish Rex" ,"Cymric", "Cyprus", "Devon Rex", "Donskoy", "Dragon Li", "Egyptian Mau", "European Burmese", "Exotic Shorthair",
                            "Havana Brown", "Himalayan", "Japanese Bobtail", "Javanese","Khao Manee","Korat", "Kurilian", "LaPerm", "Maine Coon",
                            "Malayan", "Manx","Munchkin", "Nebelung", "Norwegian Forest Cat", "Ocicat", "Oriental", "Persian", "Pixie-bob", "Ragamuffin", "Ragdoll",
                            "Russian Blue", "Savannah", "Scottish Fold", "Selkirk Rex", "Siamese", "Siberian", "Singapura", "Snowshoe", "Somali",
                            "Sphynx", "Tonkinese", "Toyger", "Turkish Angora", "Turkish Van", "York Chocolate"};

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
            "https://cdn.shopify.com/s/files/1/0997/4496/files/Capture_099e7ffd-2e2a-4ad9-8a87-cb1de94d94fa_grande.PNG?v=1538422473.jpg",//california
            "https://catspro.com/wp-content/uploads/2018/01/Shorty-black-hair-cat-1024x640.jpg",//chantilly
            "https://cdn2.thecatapi.com/images/8cXEkQQwc.jpg",//chartreux
            "https://cdn2.thecatapi.com/images/VT9NOyJqk.jpg",//chausie
            "https://www.petguide.com/wp-content/uploads/2018/02/cheetoh.jpg",//cheetoh
            "https://cdn1-www.cattime.com/assets/uploads/gallery/colorpoint-shorthair-cats-and-kittens/colorpoint-shorthair-cats-kittens-1.jpg",//colorpoint
            "https://cdn2.thecatapi.com/images/DmP9GCClC.jpg", //cornish
            "https://vetstreet-brightspot.s3.amazonaws.com/47/02/4e7e071c45959ad31884a8358cf5/Cymric-AP-C3AGGL-645sm3614.jpg",//cymric
            "https://upload.wikimedia.org/wikipedia/commons/b/b9/CyprusShorthair.jpg",//cyprus
            "https://cdn2.thecatapi.com/images/uUGt0UBzF.jpg",//devonrex
            "https://cdn2.thecatapi.com/images/KWVenr3Pq.jpg",//donksoy
            "https://www.mascotarios.org/wp-content/uploads/2011/07/dragon.jpg",//dragonli
            "http://www.pethealthnetwork.com/sites/default/files/content/images/eqyptian-mau185646620.png",//egyptmau
            "https://cdn2.thecatapi.com/images/YOjBThApG.jpg",//europburmese
            "https://cdn2.thecatapi.com/images/FCNqMC83P.jpg",//exotic
            "https://cdn2.thecatapi.com/images/gQggWSR5I.jpg",//havana
            "https://cdn2.thecatapi.com/images/kg7nc0poR.jpg",//himalayan
            "https://cdn2.thecatapi.com/images/-tm9-znzl.jpg",//japbobtail
            "https://cdn2.thecatapi.com/images/V00qLe4Gw.jpg",//javanese
            "https://cdn2.thecatapi.com/images/165ok6ESN.jpg",//khao
            "https://cdn2.thecatapi.com/images/1TcC-kiI1.jpg",//korat
            "https://cdn.shopify.com/s/files/1/0997/4496/files/Kurilian_Bobtail_Cat_grande.png?v=1535134457.jpg",//kurilian
            "http://catsplace.org/wp-content/uploads/2015/01/LaPerm-cat-breed.jpg",//laperm
            "https://cdn2.thecatapi.com/images/PKblw2RPe.jpg",//mainecoon
            "http://legionfront.me/wp-content/uploads/2018/06/malayan-cat-malay-man-catcher-how-it-works.jpg",//malayan
            "https://cdn2.thecatapi.com/images/AoDtRhYcL.jpg",//manx
            "https://cdn2.thecatapi.com/images/8LxU2Gwmo.jpg",//munchkin
            "https://cdn2.thecatapi.com/images/OUfeISEoi.jpg",//nebelung
            "https://cdn2.thecatapi.com/images/JnD5BF9Uq.jpg",//norwegian
            "https://cdn2.thecatapi.com/images/HksHrR8-9.jpg",//ocicat
            "https://cdn2.thecatapi.com/images/Mt-cUeiUY.jpg",//oriental
            "https://cdn2.thecatapi.com/images/28JWnlpYH.jpg",//persian
            "https://cdn2.thecatapi.com/images/4MEAQffKS.jpg",//pixiebob
            "https://cdn2.thecatapi.com/images/SMuZx-bFM.jpg",//ragamuffin
            "https://cdn2.thecatapi.com/images/-JE1XgBFt.jpg",//ragdoll
            "https://cdn2.thecatapi.com/images/tHKLZkKZG.jpg",//russian
            "https://cdn2.thecatapi.com/images/Od-McTDZU.jpg",//savannah
            "https://cdn2.thecatapi.com/images/6P42aYVha.jpg",//scottish
            "https://cdn2.thecatapi.com/images/kcDyctLTZ.jpg",//selkirk
            "https://cdn2.thecatapi.com/images/stVqmJmi7.jpg",//siamese
            "https://cdn2.thecatapi.com/images/6KCUyqE4v.jpg",//siberian
            "https://cdn2.thecatapi.com/images/JBkP_EJm9.jpg",//singapura
            "https://cdn2.thecatapi.com/images/9cbCzlbJt.jpg",//snowshoe
            "https://cdn2.thecatapi.com/images/klJJYDl2B.jpg",//somali
            "https://cdn2.thecatapi.com/images/0c9_EEtqQ.jpg",//sphynx
            "https://cdn2.thecatapi.com/images/6vPgXY9tb.jpg",//tonkinese
            "https://cdn2.thecatapi.com/images/Zi4jfH3c6.jpg",//toyger
            "https://cdn2.thecatapi.com/images/oR3LMBqEZ.jpg",//turkishangora
            "http://pontus.mentalfloss.com/sites/default/files/turkishvanmama.jpg",//turkishvan
            "https://cdn2.thecatapi.com/images/LzVDEMYIv.jpg"//yorkchocolate


    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getIncomingIntent();

        final ImageView image = findViewById(R.id.detailimage);
        final String name = getIntent().getStringExtra("detail_name"); //name of selected cat

        for(Integer i = 0; i < cats.length; i++){
            if(name.equals(cats[i])){
                showImg(images[i]);
            }
        }


        final Integer affectionlevel = getIntent().getIntExtra("detail_affection_level", 0); //affection  of selected cat
        final Integer energylevel = getIntent().getIntExtra("detail_energy_level", 0); //energy level of selected cat
        final Integer intelligence = getIntent().getIntExtra("detail_intelligence", 0); //intelligence  of selected cat


        ImageView paw1 = findViewById(R.id.paw1); //affection
        ImageView paw2 = findViewById(R.id.paw2);
        ImageView paw3 = findViewById(R.id.paw3);
        ImageView paw4 = findViewById(R.id.paw4);
        ImageView paw5 = findViewById(R.id.paw5);

        ImageView paw6 = findViewById(R.id.paw6); //energy
        ImageView paw7 = findViewById(R.id.paw7);
        ImageView paw8 = findViewById(R.id.paw8);
        ImageView paw9 = findViewById(R.id.paw9);
        ImageView paw10 = findViewById(R.id.paw10);

        ImageView paw11 = findViewById(R.id.paw11); //intelligence
        ImageView paw12 = findViewById(R.id.paw12);
        ImageView paw13 = findViewById(R.id.paw13);
        ImageView paw14 = findViewById(R.id.paw14);
        ImageView paw15 = findViewById(R.id.paw15);



        switch (affectionlevel) {

            case 1:
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw1);
                break;

            case 2:
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw1);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw2);
                break;

            case 3:
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw1);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw2);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw3);
                break;

            case 4:
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw1);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw2);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw3);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw4);
                break;

            case 5:
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw1);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw2);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw3);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw4);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw5);
                break;

            }

        switch (energylevel) {

            case 1:
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw6);
                break;

            case 2:
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw6);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw7);
                break;

            case 3:
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw6);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw7);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw8);
                break;

            case 4:
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw6);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw7);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw8);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw9);
                break;

            case 5:
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw6);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw7);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw8);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw9);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw10);
                break;

        }


        switch (intelligence) {

            case 1:
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw11);
                break;

            case 2:
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw11);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw12);
                break;

            case 3:
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw11);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw12);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw13);
                break;

            case 4:
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw11);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw12);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw13);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw14);
                break;

            case 5:
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw11);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw12);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw13);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw14);
                Picasso.with(getApplicationContext()).load(R.drawable.pawblack).into(paw15);
                break;

        }

}

    private void getIncomingIntent(){

        if(getIntent().hasExtra("detail_description")&& getIntent().hasExtra("detail_temperament")
                && getIntent().hasExtra("detail_affection_level")
                && getIntent().hasExtra("detail_energy_level")
                && getIntent().hasExtra("detail_intelligence")){

            String detaildescription = getIntent().getStringExtra("detail_description");
            String detailtemperament = getIntent().getStringExtra("detail_temperament");

            Integer affection = getIntent().getIntExtra("detail_affection_level",0);
            Integer energy = getIntent().getIntExtra("detail_energy_level",0);
            Integer intelligence = getIntent().getIntExtra("detail_intelligence",0);

            SetText(detaildescription, detailtemperament, affection, energy, intelligence);
        }

    }

    private void SetText(String detail_description, String detail_temperament, Integer aff, Integer ene, Integer inte){

        TextView description = findViewById(R.id.description);
        description.setText(detail_description);

        TextView temperament = findViewById(R.id.temperament);
        temperament.setText(detail_temperament);

    }

    //private void SetValues()

   public void showImg(String url){

        ImageView image = findViewById(R.id.detailimage);
        Picasso.with(getApplicationContext())
            .load(url).placeholder(R.drawable.nyancaticon).into(image);
}

}
