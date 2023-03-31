package com.example.inversewallet.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.inversewallet.R;
import com.example.inversewallet.models.DataIncome;
import com.example.inversewallet.models.IncomeAdapter;
import com.google.android.material.button.MaterialButton;

public class IncomeActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton buttonBacIncome;
    private Spinner spinner;
    private IncomeAdapter incomeAdapter;
    private LinearLayout layoutQRCode;
    private MaterialButton buttonNextIncome;
    private String sh;
    private EditText editIncomeNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    private void init(){
        buttonBacIncome = findViewById(R.id.buttonBacIncome);
        buttonBacIncome.setOnClickListener(this);
        spinner = findViewById(R.id.spinnerIncome);
        incomeAdapter = new IncomeAdapter(IncomeActivity.this, DataIncome.getCategoriesIncome());
        spinner.setAdapter(incomeAdapter);
        layoutQRCode = findViewById(R.id.layoutQRCode);
        layoutQRCode.setOnClickListener(this);
        buttonNextIncome = findViewById(R.id.buttonNextIncome);
        buttonNextIncome.setOnClickListener(this);
        editIncomeNumber = findViewById(R.id.editIncomeNumber);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonBacIncome:
                buttonBacIncome.startAnimation(AnimationUtils.loadAnimation(this, R.anim.image_click));
                Intent intent = new Intent(IncomeActivity.this, MainMenuActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.buttonNextIncome:
                sh = editIncomeNumber.getText().toString();
                putData();
                Intent intent1 = new Intent(IncomeActivity.this, MainMenuActivity.class);
                startActivity(intent1);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(IncomeActivity.this, MainMenuActivity.class);
        startActivity(intent);
        finish();
    }

    private void putData(){
        SharedPreferences sPref = getSharedPreferences("saveIncome", MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString("incomeSave", sh);
        editor.commit();
    }
}