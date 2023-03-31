package com.example.inversewallet.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.inversewallet.R;

import java.util.List;

public class IncomeAdapter extends BaseAdapter {

    private Context context;
    private List<Categories> list;

    public IncomeAdapter(Context context, List<Categories> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_categories, viewGroup, false);
        TextView txt = rootView.findViewById(R.id.textItemSpinner);
        txt.setText(list.get(i).getName());

        return rootView;
    }
}
