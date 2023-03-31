package com.example.inversewallet.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.inversewallet.R;
import com.google.android.material.button.MaterialButton;

public class LetterActivity extends AppCompatActivity implements View.OnClickListener{

    private MaterialButton buttonLetterNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    private void init(){
        buttonLetterNext = findViewById(R.id.buttonLetterNext);
        buttonLetterNext.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(LetterActivity.this, ForgotPasswordActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonLetterNext:
                Intent intent = new Intent(LetterActivity.this, PasswordResetActivity.class);
                startActivity(intent);
                finish();
        }
    }
}