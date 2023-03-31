package com.example.inversewallet.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.inversewallet.R;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private int[] images = {
        R.drawable.image_welcome_first,
        R.drawable.image_welcome_second,
        R.drawable.image_welcome_third
    };
    private int[] title = {
            R.string.text_title_welcome_first,
            R.string.text_title_welcome_second,
            R.string.text_title_welcome_third
    };
    private int[] description = {
            R.string.text_description_welcome_first,
            R.string.text_description_welcome_second,
            R.string.text_description_welcome_third
    };

    public ViewPagerAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_item, container, false);
        ImageView slideImage = view.findViewById(R.id.itemImageWelcome);
        TextView slideTitle = view.findViewById(R.id.itemTextTitleWelcome);
        TextView slideDescription = view.findViewById(R.id.itemTextDescriptionWelcome);

        slideImage.setImageResource(images[position]);
        slideTitle.setText(title[position]);
        slideDescription.setText(description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
