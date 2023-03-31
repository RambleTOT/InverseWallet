package com.example.inversewallet.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inversewallet.R;
import com.example.inversewallet.models.ViewPagerAdapter;
import com.google.android.material.button.MaterialButton;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager slideWelcome;
    private LinearLayout indicatorLayout;
    private MaterialButton buttonRegistrationWelcome, buttonEntryWelcome;
    private TextView[] dots;
    private ViewPagerAdapter viewPagerAdapter;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    private void init(){
        slideWelcome = findViewById(R.id.slideWelcome);
        indicatorLayout = findViewById(R.id.indicatorLayout);
        buttonRegistrationWelcome = findViewById(R.id.buttonRegistrationWelcome);
        buttonRegistrationWelcome.setOnClickListener(this);
        buttonEntryWelcome = findViewById(R.id.buttonEntryWelcome);
        buttonEntryWelcome.setOnClickListener(this);
        viewPagerAdapter = new ViewPagerAdapter(this);
        slideWelcome.setAdapter(viewPagerAdapter);
        setupIndicator(0);
        slideWelcome.addOnPageChangeListener(viewListener);
    }

    public void setupIndicator(int position){
        dots = new TextView[3];
        indicatorLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(45);
            dots[i].setTextColor(getResources().getColor(R.color.color_second));
            indicatorLayout.addView(dots[i]);
        }
        dots[position].setTextColor(getResources().getColor(R.color.color_main));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonRegistrationWelcome:
                Intent intent = new Intent(WelcomeActivity.this, RegistrationActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.buttonEntryWelcome:
                Intent intent1 = new Intent(WelcomeActivity.this, EntryActivity.class);
                startActivity(intent1);
                finish();
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setupIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
            backToast = Toast.makeText(getBaseContext(), "Нажмите ещё раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}