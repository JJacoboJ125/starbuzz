package co.edu.unipiloto.drinks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Drink {
    private String name;
    private String description;
    private  int imgResourceId;

    public static final Drink[] drinks = {
            new Drink("Latte", "un café expresso con un shot de leche", R.drawable.latte),
            new Drink("cappucino", "un café expresso con leche y espuma de leche", R.drawable.cappuccino),
            new Drink("filter", "cafe con la mejor seleccion de granos", R.drawable.filter)

};
    public Drink(String name, String description, int imgResourceId) {
        this.name = name;
        this.description = description;
        this.imgResourceId = imgResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImgResourceId() {
        return imgResourceId;
    }

    @Override
    public String toString() {
        return this.name;

    }
}