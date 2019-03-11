package com.example.cattoapp;

import com.example.cattoapp.controller.MainController;
import com.example.cattoapp.model.CatBreed;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Context;
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

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;


public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar loader;
    private MainController controller;
    private Integer counter = 0;
    private Random rand = new Random();

    private SensorManager sm;
    private float acelVal;
    private float acelLast;
    private float shake;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Sound();
        //Animate();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        loader = findViewById(R.id.progressBar);

        controller = new MainController(this);
        controller.onCreate();


        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        acelVal = SensorManager.GRAVITY_EARTH;
        acelLast = SensorManager.GRAVITY_EARTH;
        shake = 0.00f;

    }
    private final SensorEventListener sensorListener = new SensorEventListener() {
        @Override

        public void onSensorChanged(SensorEvent sensorEvent) {

            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];
            acelLast = acelVal;
            acelVal = (float) Math.sqrt((double)(x*x + y*y + z*z));
            float delta = acelVal-acelLast;
            shake = shake*0.9f + delta;



            if (shake > 10) {
                ImageView background = findViewById(R.id.background);
                Picasso.with(getApplicationContext()).load(R.drawable.spacecatwp).into(background);

                Animate();
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    public void Sound_Animate(){

        MediaPlayer shootingstars =  MediaPlayer.create(getApplicationContext(), R.raw.shooting_stars);
        shootingstars.start();
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

    public void Sound(){

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
    }
    ///////ANIMATION
    public void Animate() {
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
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, -1.0f);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, -1.0f);

        translateAnimation.setInterpolator(new AccelerateInterpolator());
        translateAnimation.setDuration(4000);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);

        translateAnimation2.setInterpolator(new AccelerateInterpolator());
        translateAnimation2.setDuration(4000);
        translateAnimation2.setFillEnabled(true);
        translateAnimation2.setFillAfter(true);
        translateAnimation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                Sound_Animate();
                Spacecatanimation.start();
                Spacecatanimation2.start();
            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                Toast.makeText(getApplicationContext(), "Miaow", Toast.LENGTH_SHORT).show();

                ImageView background = findViewById(R.id.background);
                background.setImageResource(android.R.color.transparent);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        animation.startAnimation(translateAnimation);
        animation2.startAnimation(translateAnimation2);


    }

    public void showLoader(){
        loader.setVisibility(View.VISIBLE);
    }
    public void hideLoader(){
        loader.setVisibility(View.GONE);
    }





}