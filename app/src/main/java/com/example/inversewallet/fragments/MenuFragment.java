package com.example.inversewallet.fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inversewallet.R;

public class MenuFragment extends Fragment{

    private TextView menuTextIncome, menuTextExpence;


    private void init(){
        menuTextIncome = getActivity().findViewById(R.id.menuTextIncome);
        menuTextExpence = getActivity().findViewById(R.id.menuTextExpence);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        getData();
    }

    private void getData(){
        SharedPreferences sPref1 = getActivity().getSharedPreferences("saveExpense", MODE_PRIVATE);
        String expense = sPref1.getString("expenseSave", "0");
        menuTextExpence.setText("₽" + (int)Double.parseDouble(expense));
        SharedPreferences sPref2 = getActivity().getSharedPreferences("saveIncome", MODE_PRIVATE);
        String income = sPref2.getString("incomeSave", "0");
        menuTextIncome.setText("₽" + (int)Double.parseDouble(income));
    }

}