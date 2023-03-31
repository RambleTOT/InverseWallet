package com.example.inversewallet.models;

import java.util.ArrayList;
import java.util.List;

public class DataExpense {

    public static List<Categories> getCategoriesExpence(){
        List<Categories> list = new ArrayList<>();
        list.add(new Categories("Категории"));
        list.add(new Categories("Образование"));
        list.add(new Categories("Транспорт"));
        list.add(new Categories("Игры"));
        list.add(new Categories("Путешествия"));
        list.add(new Categories("Услуги банка"));
        list.add(new Categories("Развлечения"));
        list.add(new Categories("Продукты"));
        list.add(new Categories("Фастфуд"));
        list.add(new Categories("Электроника"));
        list.add(new Categories("Переводы"));
        list.add(new Categories("Рестораны"));
        list.add(new Categories("Другое"));
        return list;
    }

}
