package com.example.cattoapp;

import com.example.cattoapp.controller.MainController;
import com.example.cattoapp.model.CatBreed;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
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


        ImageView animation = (ImageView) findViewById(R.id.spacecat);
        ImageView animation2 = (ImageView) findViewById(R.id.spacecat2);
        animation.setBackgroundResource(R.drawable.cat_anim);
        animation2.setBackgroundResource(R.drawable.cat_anim);

        final AnimationDrawable Spacecatanimation = (AnimationDrawable) animation.getBackground();
        final AnimationDrawable Spacecatanimation2 = (AnimationDrawable) animation2.getBackground();

        animation.setScaleX(0.5f);
        animation.setScaleY(0.3f);
        animation.setY(600);

        animation2.setScaleX(0.3f);
        animation2.setScaleY(0.2f);
        animation2.setX(-300);
        animation2.setY(800);

        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF,0.0f, Animation.RELATIVE_TO_SELF, -1.0f);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF,0.0f, Animation.RELATIVE_TO_SELF, -1.0f);

        translateAnimation.setInterpolator(new AccelerateInterpolator());
        translateAnimation.setDuration(4000);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);

        translateAnimation2.setInterpolator(new AccelerateInterpolator());
        translateAnimation2.setDuration(2000);
        translateAnimation2.setFillEnabled(true);
        translateAnimation2.setFillAfter(true);
        translateAnimation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation)
            {
                // TODO Auto-generated method stub
                Spacecatanimation.start();
                Spacecatanimation2.start();
            }
            @Override
            public void onAnimationEnd(Animation arg0) {
                Toast.makeText(getApplicationContext(), "Miaow",Toast.LENGTH_SHORT).show();
                Spacecatanimation.stop();
                Spacecatanimation2.stop();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        animation.startAnimation(translateAnimation);
        animation2.startAnimation(translateAnimation2);


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