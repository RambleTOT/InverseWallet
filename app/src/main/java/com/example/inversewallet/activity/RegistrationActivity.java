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

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton buttonBackRegistration;
    private EditText editRegName, editEmailReg, editPasswordReg;
    private MaterialButton buttonRegistration;
    private TextView textClickEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    private void init(){
        buttonBackRegistration = findViewById(R.id.buttonBackRegistration);
        buttonBackRegistration.setOnClickListener(this);
        editRegName = findViewById(R.id.editRegName);
        editEmailReg = findViewById(R.id.editEmailReg);
        editPasswordReg = findViewById(R.id.editPasswordReg);
        buttonRegistration = findViewById(R.id.buttonRegistration);
        buttonRegistration.setOnClickListener(this);
        textClickEntry = findViewById(R.id.textClickEntry);
        textClickEntry.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonBackRegistration:
                buttonBackRegistration.startAnimation(AnimationUtils.loadAnimation(this, R.anim.image_click));
                Intent intent = new Intent(RegistrationActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.textClickEntry:
                Intent intent1 = new Intent(RegistrationActivity.this, EntryActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.buttonRegistration:
                Intent intent2 = new Intent(RegistrationActivity.this, SuccessRegistryActivity.class);
                startActivity(intent2);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(RegistrationActivity.this, WelcomeActivity.class);
        startActivity(intent);
        finish();
    }
}