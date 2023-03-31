package com.example.inversewallet.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inversewallet.R;

public class SuccessRegistryActivity extends AppCompatActivity {

    private ImageView imageSuccess;
    private TextView textSuccess;
    private static int SPLASH_SCREEN = 3000;
    private Animation topAnim, botAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_registr);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    private void init(){
        imageSuccess = findViewById(R.id.imageSuccess);
        textSuccess = findViewById(R.id.textSuccess);
        topAnim = AnimationUtils.loadAnimation(this, R.anim.splash_screen_animation_top2);
        botAnim = AnimationUtils.loadAnimation(this, R.anim.splash_screen_animation_bottom);
        imageSuccess.setAnimation(botAnim);
        textSuccess.setAnimation(topAnim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SuccessRegistryActivity.this, MainMenuActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }

}