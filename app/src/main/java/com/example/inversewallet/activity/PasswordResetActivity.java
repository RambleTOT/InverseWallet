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

public class PasswordResetActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton buttonBackResetPassword;
    private EditText editPasswordNewReset, editPasswordConfirmationReset;
    private MaterialButton buttonContinueReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    private void init(){
        buttonBackResetPassword = findViewById(R.id.buttonBackResetPassword);
        buttonBackResetPassword.setOnClickListener(this);
        editPasswordNewReset = findViewById(R.id.editPasswordNewReset);
        editPasswordConfirmationReset = findViewById(R.id.editPasswordConfirmationReset);
        buttonContinueReset = findViewById(R.id.buttonContinueReset);
        buttonContinueReset.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(PasswordResetActivity.this, LetterActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonBackResetPassword:
                buttonBackResetPassword.startAnimation(AnimationUtils.loadAnimation(this, R.anim.image_click));
                Intent intent = new Intent(PasswordResetActivity.this, LetterActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.buttonContinueReset:
                Intent intent1 = new Intent(PasswordResetActivity.this, EntryActivity.class);
                startActivity(intent1);
                finish();
                break;
        }
    }
}