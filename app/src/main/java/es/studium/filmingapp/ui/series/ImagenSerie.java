package es.studium.filmingapp.ui.series;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import es.studium.filmingapp.R;

public class ImagenSerie extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serie_imagen);
        Intent intent = getIntent();
        int imagen = intent.getIntExtra("imagen", 0);
        ImageView imageView3 = findViewById(R.id.imageView3);
        imageView3.setImageResource(imagen);
        imageView3.setOnClickListener(v -> {
            finish();
        });
    }

}
