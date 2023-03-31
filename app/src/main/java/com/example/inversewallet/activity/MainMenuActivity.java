package com.example.inversewallet.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.inversewallet.R;
import com.example.inversewallet.fragments.BudgetFragment;
import com.example.inversewallet.fragments.MenuFragment;
import com.example.inversewallet.fragments.PaymentsFragment;
import com.example.inversewallet.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomNavigationView bottomNavigationMenu;
    private FloatingActionButton fbPlus, fbIncome, fbExpense;
    private Animation fbOpen, fbClose, rotFor, rotBack;
    private boolean isOpen = false;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    private void init(){
        fbOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fbClose = AnimationUtils.loadAnimation(this, R.anim.fab_close);
        rotFor = AnimationUtils.loadAnimation(this, R.anim.rotate_forward);
        rotBack = AnimationUtils.loadAnimation(this, R.anim.rotate_backward);
        fbPlus = findViewById(R.id.imageButtonPlus);
        fbPlus.setOnClickListener(this);
        fbIncome = findViewById(R.id.imageButtonIncome);
        fbIncome.setOnClickListener(this);
        fbExpense = findViewById(R.id.imageButtonExpense);
        fbExpense.setOnClickListener(this);
        replaceFragment(new MenuFragment());
        bottomNavigationMenu = findViewById(R.id.bottomNavigationMenu);
        bottomNavigationMenu.setBackground(null);
        bottomNavigationMenu.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new MenuFragment());
                    break;
                case R.id.payments:
                    replaceFragment(new PaymentsFragment());
                    break;
                case R.id.budget:
                    replaceFragment(new BudgetFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameMainMenu, fragment);
        fragmentTransaction.commit();
    }

    private void animateFab(){
        if (isOpen){
            fbPlus.startAnimation(rotBack);
            fbIncome.startAnimation(fbClose);
            fbExpense.startAnimation(fbClose);
            fbIncome.setClickable(false);
            fbExpense.setClickable(false);
            isOpen = false;
        }else{
            fbPlus.startAnimation(rotFor);
            fbIncome.startAnimation(fbOpen);
            fbExpense.startAnimation(fbOpen);
            fbIncome.setClickable(true);
            fbExpense.setClickable(true);
            isOpen = true;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageButtonPlus:
                animateFab();
                break;
            case R.id.imageButtonIncome:
                Intent intent = new Intent(MainMenuActivity.this, IncomeActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.imageButtonExpense:
                Intent intent1 = new Intent(MainMenuActivity.this, ExpenseActivity.class);
                startActivity(intent1);
                finish();
                break;
        }
    }

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