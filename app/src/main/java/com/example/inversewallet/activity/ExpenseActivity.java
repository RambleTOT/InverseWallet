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
import com.example.inversewallet.models.DataExpense;
import com.example.inversewallet.models.IncomeAdapter;
import com.google.android.material.button.MaterialButton;

public class ExpenseActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton buttonBacExpence;
    private Spinner spinner;
    private IncomeAdapter incomeAdapter;
    private LinearLayout layoutQRCodeExpence;
    private MaterialButton buttonNextExpence;
    private String getQRCode;
    public static EditText editExpenceNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    private void init(){
        buttonBacExpence = findViewById(R.id.buttonBacExpence);
        buttonBacExpence.setOnClickListener(this);
        spinner = findViewById(R.id.spinnerExpence);
        incomeAdapter = new IncomeAdapter(ExpenseActivity.this, DataExpense.getCategoriesExpence());
        spinner.setAdapter(incomeAdapter);
        layoutQRCodeExpence = findViewById(R.id.layoutQRCodeExpence);
        layoutQRCodeExpence.setOnClickListener(this);
        buttonNextExpence = findViewById(R.id.buttonNextExpence);
        buttonNextExpence.setOnClickListener(this);
        editExpenceNumber = findViewById(R.id.editExpenceNumber);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ExpenseActivity.this, MainMenuActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonBacExpence:
                buttonBacExpence.startAnimation(AnimationUtils.loadAnimation(this, R.anim.image_click));
                Intent intent = new Intent(ExpenseActivity.this, MainMenuActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.buttonNextExpence:
                getQRCode = editExpenceNumber.getText().toString();
                putData();
                Intent intent1 = new Intent(ExpenseActivity.this, MainMenuActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.layoutQRCodeExpence:
                layoutQRCodeExpence.startAnimation(AnimationUtils.loadAnimation(this, R.anim.image_click));
                startActivity(new Intent(getApplicationContext(), ScannerViewActivity.class));
                break;
        }
    }

    private void putData(){
        SharedPreferences sPref = getSharedPreferences("saveExpense", MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString("expenseSave", getQRCode);
        editor.commit();
    }

}