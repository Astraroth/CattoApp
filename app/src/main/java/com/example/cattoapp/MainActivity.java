package com.example.cattoapp;

import com.example.cattoapp.controller.MainController;
import com.example.cattoapp.model.CatBreed;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;
import java.util.Random;


public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar loader;
    private MainController controller;
    private Integer counter = 0;
    private Random rand = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer[] sounds = {
                MediaPlayer.create(getApplicationContext(), R.raw.cat_meow),
                MediaPlayer.create(getApplicationContext(), R.raw.nyancat),
                MediaPlayer.create(getApplicationContext(), R.raw.cat_meow2),
                MediaPlayer.create(getApplicationContext(), R.raw.bongo_cat),
        };
        FloatingActionButton playCatSound = (FloatingActionButton) this.findViewById(R.id.buttonSound);
        playCatSound.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Meow ! (Sound on)", Toast.LENGTH_SHORT).show();
                sounds[rand.nextInt(sounds.length)].start();
            }
        });


        FloatingActionButton playCatImage = (FloatingActionButton) this.findViewById(R.id.buttonImage);
        playCatImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Random Kitty Image !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ImageActivity.class);
                getApplicationContext().startActivity(intent);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        loader = findViewById(R.id.progressBar);

        controller = new MainController(this);
        controller.onCreate();

    }

    public void showLoader(){
        loader.setVisibility(View.VISIBLE);
    }
    public void hideLoader(){
        loader.setVisibility(View.GONE);
    }

    public void showList(List<CatBreed> list){

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new RecyclerViewAdapter(list,

                new OnItemClickListener() {
                    @Override
                    public void onItemClick(CatBreed item) {

                        Toast.makeText(getApplicationContext(), item.getName(), Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                        intent.putExtra("detail_description",  item.getDescription());
                        intent.putExtra("detail_temperament",  item.getTemperament());
                        intent.putExtra("detail_name",  item.getName());

                        getApplicationContext().startActivity(intent);
                    }
                });



        recyclerView.setAdapter(mAdapter);

    }


}