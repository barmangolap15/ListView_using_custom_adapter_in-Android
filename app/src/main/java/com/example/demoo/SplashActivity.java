package com.example.demoo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    //Animations
    Animation topAnimation, bottomAnimation, middleAnimation;

    //hooks
    ImageView logo;
    TextView title, desc;

    public static int SPLASH_TIMEOUT = 4000; // stay for 4 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        middleAnimation = AnimationUtils.loadAnimation(this,R.anim.middle_animation);

        //hooks
        logo = findViewById(R.id.logo);
        title = findViewById(R.id.title);
        desc = findViewById(R.id.description);

        //set the animation in the elements
        logo.setAnimation(topAnimation);
        title.setAnimation(middleAnimation);
        desc.setAnimation(bottomAnimation);

        //splash screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),SecondActivity.class));
                finish();
            }
        },SPLASH_TIMEOUT);
    }
}



