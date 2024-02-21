package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    ImageView imgTicTacToe;
    TextView txtMyName;
    Animation animLogo,animMyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Initialization of all views or variables
        init();

        //Initialization of animations of name and logo.
        animLogo = AnimationUtils.loadAnimation(this,R.anim.logo_animation);
        animMyName = AnimationUtils.loadAnimation(this,R.anim.myname_animation);

        //Setting this animations on views
        imgTicTacToe.setAnimation(animLogo);
        txtMyName.setAnimation(animMyName);

        //Switching to Main Activity
        Intent iHome = new Intent(SplashActivity.this, MainActivity.class);

        //Setting delay to start the main Activity for completing the animations on Splash Activity.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(iHome);
                finish();
            }
        },8000);

    }

    public void init() {
        imgTicTacToe = findViewById(R.id.imgTicTacToe);
        txtMyName = findViewById(R.id.txtMyName);
    }
}