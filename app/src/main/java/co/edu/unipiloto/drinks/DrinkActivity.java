package co.edu.unipiloto.drinks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {
    public static final String EXTRA_DRINK="drinkId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        int Drinkid= (Integer) getIntent().getExtras().get(EXTRA_DRINK);
        Drink bebida = Drink.drinks[Drinkid];
        TextView nombre = (TextView) findViewById(R.id.name);
        nombre.setText(bebida.getName());

        TextView desc = (TextView) findViewById(R.id.description);
        desc.setText(bebida.getDescription());

        ImageView foto = (ImageView) findViewById(R.id.photo);
        foto.setImageResource(bebida.getImgResourceId());
        foto.setContentDescription(bebida.getName());




    }
}