package com.oa.computerclub.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.oa.computerclub.MainActivity;
import com.oa.computerclub.R;


public class SplashActivity extends AppCompatActivity {
ImageView logoIv;
TextView logoTv;
Animation topAnim,downAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logoIv = findViewById(R.id.logoIv);
        logoTv = findViewById(R.id.logoTv);

topAnim= AnimationUtils.loadAnimation(SplashActivity.this,R.anim.slide_up);
downAnim = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.slide_down);
logoTv.setAnimation(topAnim);
logoIv.setAnimation(downAnim);

new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
},3000);
    }
}