package com.example.inversewallet.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.inversewallet.R;
import com.google.android.material.button.MaterialButton;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton buttonBackForgotPassword;
    private EditText editEmailForgot;
    private MaterialButton buttonForgotContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    private void init(){
        buttonBackForgotPassword = findViewById(R.id.buttonBackForgotPassword);
        buttonBackForgotPassword.setOnClickListener(this);
        editEmailForgot = findViewById(R.id.editEmailForgot);
        buttonForgotContinue = findViewById(R.id.buttonForgotContinue);
        buttonForgotContinue.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonBackForgotPassword:
                buttonBackForgotPassword.startAnimation(AnimationUtils.loadAnimation(this, R.anim.image_click));
                Intent intent = new Intent(ForgotPasswordActivity.this, EntryActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.buttonForgotContinue:
                Intent intent1 = new Intent(ForgotPasswordActivity.this, LetterActivity.class);
                startActivity(intent1);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ForgotPasswordActivity.this, EntryActivity.class);
        startActivity(intent);
        finish();
    }
}