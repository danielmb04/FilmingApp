package es.studium.filmingapp.ui.series;

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

public class SerieAdapter extends RecyclerView.Adapter<SerieAdapter.SerieViewHolder> {

    private List<Serie> series;
    private Context context; // Necesitamos el contexto para iniciar la nueva actividad

    // Constructor actualizado
    public SerieAdapter(Context context, List<Serie> series) {
        this.context = context;
        this.series = series;
    }

    @NonNull
    @Override
    public SerieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_series, parent, false);
        return new SerieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SerieViewHolder holder, int position) {
        Serie serie = series.get(position);
        holder.titulo.setText(serie.getTitulo());
        holder.imagen.setImageResource(serie.getImagen());

///        holder.ratingBar.setRating(pelicula.getClasificacion());

        // Configurar el clic en el elemento
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetalleSerie.class);
            // Pasar datos de la película a la actividad de detalles
            intent.putExtra("titulo", serie.getTitulo());
            intent.putExtra("director", serie.getDirector());
            intent.putExtra("reparto", serie.getReparto());
            intent.putExtra("clasificacion", serie.getClasificacion());
            intent.putExtra("sinopsis", serie.getSinopsis());
            intent.putExtra("imagen", serie.getImagen());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return series.size();
    }

    static class SerieViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        ImageView imagen;
        RatingBar ratingBar;

        public SerieViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.textTituloSerie);
            imagen = itemView.findViewById(R.id.imageSerie);
            ratingBar = itemView.findViewById(R.id.ratingBarSerie);
        }
    }
}
