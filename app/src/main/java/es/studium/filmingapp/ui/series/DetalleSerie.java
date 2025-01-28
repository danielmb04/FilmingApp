package es.studium.filmingapp.ui.series;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.studium.filmingapp.R;

public class DetalleSerie extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serie_detalle);

        Intent intent = getIntent();
        String titulo = intent.getStringExtra("titulo");
        String director = intent.getStringExtra("director");
        String reparto = intent.getStringExtra("reparto");
        float clasificacion = intent.getFloatExtra("clasificacion", 0.0f);
        String descripcion = intent.getStringExtra("sinopsis");
        int imagen = intent.getIntExtra("imagen", 0);

        TextView textTituloSerie = findViewById(R.id.textTituloSerie);
        TextView textDirectorSerie = findViewById(R.id.textDirectorSerie);
        TextView textRepartoSerie = findViewById(R.id.textRepartoSerie);
        RatingBar ratingBarSerie = findViewById(R.id.ratingBarSerie);
        TextView textDescripcionSerie = findViewById(R.id.textDescripcionSerie);
        ImageView imageSerie = findViewById(R.id.imageSerie);


        textTituloSerie.setText(titulo);
        textDirectorSerie.setText(director);
        textRepartoSerie.setText(reparto);
        ratingBarSerie.setRating(clasificacion);
        textDescripcionSerie.setText(descripcion);
        imageSerie.setImageResource(imagen);


        imageSerie.setOnClickListener(v -> {
            Intent intentImagen = new Intent(DetalleSerie.this, ImagenSerie.class);
            intentImagen.putExtra("imagen", imagen); // Pasamos la imagen
            startActivity(intentImagen);
        });

        Button buttonVolver = findViewById(R.id.buttonVolver2);
        buttonVolver.setOnClickListener(v -> {
            // Finaliza la actividad actual y vuelve a la actividad anterior
            finish();
        });
    }
}
