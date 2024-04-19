package co.edu.unipiloto.drinks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class DrinkCategoryActivity extends AppCompatActivity {
        private SQLiteDatabase db;

        private Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);

        SQLiteOpenHelper StarbuzzDataBaseHelper = new StarbuzzDataBaseHelper(DrinkCategoryActivity.this);
        ListView listDrink = (ListView) findViewById(R.id.listaBebidas);
        try {
            db = StarbuzzDataBaseHelper.getReadableDatabase();
            cursor = db.query("DRINK",
                    new String[]{"_id, NAME"}, null, null, null, null, null);
            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(DrinkCategoryActivity.this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"NAME"},
                    new int[]{android.R.id.text1},
                    0);
            listDrink.setAdapter(listAdapter);

        } catch (SQLException e) {
            Toast toast = Toast.makeText(this, "epa, como que no funciono mani...", Toast.LENGTH_SHORT);
            toast.show();
        }

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {
                Intent  intent = new Intent(DrinkCategoryActivity.this,DrinkActivity.class);
                intent.putExtra(DrinkActivity.EXTRA_DRINK,(int)id);
                startActivity(intent);
            }
        };
        listDrink.setOnItemClickListener(itemClickListener);

    }

    public void onDestroy(){
        super.onDestroy();
        cursor.close();
        db.close();
    }
}