package es.studium.filmingapp.ui.peliculas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.studium.filmingapp.R;

public class DetallePelicula extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pelicula_detalle);

        Intent intent = getIntent();
        String titulo = intent.getStringExtra("titulo");
        String director = intent.getStringExtra("director");
        String reparto = intent.getStringExtra("reparto");
        float clasificacion = intent.getFloatExtra("clasificacion", 0.0f);
        String descripcion = intent.getStringExtra("sinopsis");
        int imagen = intent.getIntExtra("imagen", 0);

        TextView textTitulo = findViewById(R.id.textTitulo);
        TextView textDirector = findViewById(R.id.textDirector);
        TextView textReparto = findViewById(R.id.textReparto);
        RatingBar rtclasificacion = findViewById(R.id.ratingBar);
        TextView textDescripcion = findViewById(R.id.textDescripcion);
        ImageView imagePelicula = findViewById(R.id.imagePelicula);


        textTitulo.setText(titulo);
        textDirector.setText(director);
        textReparto.setText(reparto);
        rtclasificacion.setRating(clasificacion);
        textDescripcion.setText(descripcion);
        imagePelicula.setImageResource(imagen);


        imagePelicula.setOnClickListener(v -> {
            Intent intentImagen = new Intent(DetallePelicula.this, ImagenPelicula.class);
            intentImagen.putExtra("imagen", imagen);
            startActivity(intentImagen);
        });

        Button buttonVolver = findViewById(R.id.buttonVolver);
        buttonVolver.setOnClickListener(v -> {

            finish();
        });
    }
}
