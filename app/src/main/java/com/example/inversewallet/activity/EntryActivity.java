package com.example.inversewallet.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.inversewallet.R;
import com.google.android.material.button.MaterialButton;

public class EntryActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton buttonBackEntry;
    private EditText editEmailEntry, editPasswordEntry;
    private MaterialButton buttonEntry;
    private TextView forgotPasswordEntry, clickTextRegEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    private void init(){
        buttonBackEntry = findViewById(R.id.buttonBackEntry);
        buttonBackEntry.setOnClickListener(this);
        editEmailEntry = findViewById(R.id.editEmailEntry);
        editPasswordEntry = findViewById(R.id.editPasswordEntry);
        buttonEntry = findViewById(R.id.buttonEntry);
        buttonEntry.setOnClickListener(this);
        forgotPasswordEntry = findViewById(R.id.forgotPasswordEntry);
        forgotPasswordEntry.setOnClickListener(this);
        clickTextRegEntry = findViewById(R.id.clickTextRegEntry);
        clickTextRegEntry.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonBackEntry:
                buttonBackEntry.startAnimation(AnimationUtils.loadAnimation(this, R.anim.image_click));
                Intent intent = new Intent(EntryActivity.this, RegistrationActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.buttonEntry:
                //Click entry
                break;
            case R.id.forgotPasswordEntry:
                Intent intent2 = new Intent(EntryActivity.this, ForgotPasswordActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.clickTextRegEntry:
                Intent intent1 = new Intent(EntryActivity.this, RegistrationActivity.class);
                startActivity(intent1);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(EntryActivity.this, RegistrationActivity.class);
        startActivity(intent);
        finish();
    }
}