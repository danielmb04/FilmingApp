package es.studium.filmingapp.ui.peliculas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import es.studium.filmingapp.R;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.PeliculaViewHolder> {

    private List<Pelicula> peliculas;
    private Context context; // Necesitamos el contexto para iniciar la nueva actividad

    // Constructor actualizado
    public PeliculaAdapter(Context context, List<Pelicula> peliculas) {
        this.context = context;
        this.peliculas = peliculas;
    }

    @NonNull
    @Override
    public PeliculaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pelicula, parent, false);
        return new PeliculaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaViewHolder holder, int position) {
        Pelicula pelicula = peliculas.get(position);
        holder.titulo.setText(pelicula.getTitulo());
        holder.imagen.setImageResource(pelicula.getImagen());

///        holder.ratingBar.setRating(pelicula.getClasificacion());

        // Configurar el clic en el elemento
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetallePelicula.class);
            // Pasar datos de la película a la actividad de detalles
            intent.putExtra("titulo", pelicula.getTitulo());
            intent.putExtra("director", pelicula.getDirector());
            intent.putExtra("reparto", pelicula.getReparto());
            intent.putExtra("clasificacion", pelicula.getClasificacion());
            intent.putExtra("sinopsis", pelicula.getSinopsis());
            intent.putExtra("imagen", pelicula.getImagen());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    static class PeliculaViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        ImageView imagen;
        RatingBar ratingBar;

        public PeliculaViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.textTitulo);
            imagen = itemView.findViewById(R.id.imagePelicula);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }
    }
}
