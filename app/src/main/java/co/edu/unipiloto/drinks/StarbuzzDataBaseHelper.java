package co.edu.unipiloto.drinks;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteTransactionListener;

import androidx.annotation.Nullable;

public class StarbuzzDataBaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME="Starbuzz";
    public static final int DB_VERSION=1;

    public StarbuzzDataBaseHelper(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDataBase(db, 0,DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDataBase(db, oldVersion, newVersion);

    }

    private void updateMyDataBase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion<1){
            db.execSQL("CREATE TABLE DRINK("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "NAME TEXT," +
                    "DESCRIPTION TEXT," +
                    "IMAGE_RESOURCE_ID INTEGER);");

            insertDrink(db,"Latte", "un café expresso con un shot de leche", R.drawable.latte);
            insertDrink(db,"cappucino", "un café expresso con leche y espuma de leche", R.drawable.cappuccino);
            insertDrink(db,"filter", "cafe con la mejor seleccion de granos", R.drawable.filter);
        }
        if(oldVersion<2){
            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC");
        }

    }

    public static void insertDrink(SQLiteDatabase db, String nombre, String descr, int source){

        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME",nombre);
        drinkValues.put("DESCRIPTION", descr);
        drinkValues.put("IMAGE_RESOURCE_ID INTEGER",source);

    }
}

