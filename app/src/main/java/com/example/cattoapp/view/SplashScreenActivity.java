package com.example.cattoapp.view;

import android.app.Activity;
import android.os.Bundle;
import com.example.cattoapp.R;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.Toast;

public class SplashScreenActivity extends Activity {

    private static Integer SPLASH_TIME_OUT = 3150;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        Toast.makeText(getApplicationContext(), "Welcome to Catpplication !", Toast.LENGTH_LONG).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
