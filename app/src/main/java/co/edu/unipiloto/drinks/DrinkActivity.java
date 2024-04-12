package co.edu.unipiloto.drinks;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkActivity extends AppCompatActivity {
    public static final String EXTRA_DRINK="drinkId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        int Drinkid= (Integer) getIntent().getExtras().get(EXTRA_DRINK);

        SQLiteOpenHelper StarbuzzDataBaseHelper = new StarbuzzDataBaseHelper(DrinkActivity.this);
        try {
            SQLiteDatabase db = StarbuzzDataBaseHelper.getReadableDatabase();
            Cursor cursor = db.query("DRINK",
                    new String[]{"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
                    "_id=?",
                    new String[]{Integer.toString(Drinkid)},
                    null, null, null
            );

            if (cursor.moveToFirst()) {
                String nombreText = cursor.getString(0);
                String descrText = cursor.getString(1);
                int imagenId = cursor.getInt(2);


                TextView nombre = (TextView) findViewById(R.id.name);
                nombre.setText(nombreText);

                TextView desc = (TextView) findViewById(R.id.description);
                desc.setText(descrText);

                ImageView foto = (ImageView) findViewById(R.id.photo);
                foto.setImageResource(imagenId);
                foto.setContentDescription(nombreText);
            }
        } catch (SQLException e) {
            Toast toast = Toast.makeText(this, "epa, como que no funciono mani...", Toast.LENGTH_SHORT);
            toast.show();
        }


    }
}