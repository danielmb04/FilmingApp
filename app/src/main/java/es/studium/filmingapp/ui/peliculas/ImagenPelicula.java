package es.studium.filmingapp.ui.peliculas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import es.studium.filmingapp.R;

public class ImagenPelicula extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pelicula_imagen);
        Intent intent = getIntent();
        int imagen = intent.getIntExtra("imagen", 0);
        ImageView imageView = findViewById(R.id.imageView2);
        imageView.setImageResource(imagen);

        imageView.setOnClickListener(v -> {

            finish();
        });
    }
    }

