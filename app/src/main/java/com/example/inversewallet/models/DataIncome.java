package com.example.inversewallet.models;

import java.util.ArrayList;
import java.util.List;

public class DataIncome{
        public static List<Categories> getCategoriesIncome(){
            List<Categories> list = new ArrayList<>();
            list.add(new Categories("Категории"));
            list.add(new Categories("Зарплата"));
            list.add(new Categories("Перевод"));
            list.add(new Categories("Бонусы"));
            list.add(new Categories("Возврат"));
            return list;
        }
}
