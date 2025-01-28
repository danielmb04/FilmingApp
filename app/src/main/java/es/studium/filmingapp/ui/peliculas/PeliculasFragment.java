package es.studium.filmingapp.ui.peliculas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.studium.filmingapp.R;
import es.studium.filmingapp.databinding.FragmentPeliculasBinding;

public class PeliculasFragment extends Fragment {

    private FragmentPeliculasBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PeliculasViewModel peliculasViewModel =
                new ViewModelProvider(this).get(PeliculasViewModel.class);

        binding = FragmentPeliculasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Lista de películas
        List<Pelicula> peliculas = new ArrayList<>();

       peliculas.add(new Pelicula(R.drawable.warhorse,
               requireContext().getString(R.string.titulo_pelicula1),
               requireContext().getString(R.string.director_pelicula1),
               requireContext().getString(R.string.reparto_pelicula1),
               4.5f,
               requireContext().getString(R.string.sinopsis_pelicula1)

       ));

        peliculas.add(new Pelicula(R.drawable.lobo,
                requireContext().getString(R.string.titulo_pelicula2),
                requireContext().getString(R.string.director_pelicula2),
                requireContext().getString(R.string.reparto_pelicula2),
                4.5f,
                requireContext().getString(R.string.sinopsis_pelicula2)

        ));

       peliculas.add(new Pelicula(R.drawable.mi,
               requireContext().getString(R.string.titulo_pelicula3),
               requireContext().getString(R.string.director_pelicula3),
               requireContext().getString(R.string.reparto_pelicula3),
               4f,
               requireContext().getString(R.string.sinopsis_pelicula3)

       ));

       peliculas.add(new Pelicula(R.drawable.scarface,
            requireContext().getString(R.string.titulo_pelicula4),
            requireContext().getString(R.string.director_pelicula4),
            requireContext().getString(R.string.reparto_pelicula4),
            4.5f,
            requireContext().getString(R.string.sinopsis_pelicula4)

       ));

       peliculas.add(new Pelicula(R.drawable.spirit,
        requireContext().getString(R.string.titulo_pelicula5),
        requireContext().getString(R.string.director_pelicula5),
        requireContext().getString(R.string.reparto_pelicula5),
        4f,
        requireContext().getString(R.string.sinopsis_pelicula5)

       ));

        // Configurar RecyclerView
        RecyclerView recyclerView = binding.recyclerPeliculas;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new PeliculaAdapter(getContext(), peliculas));

        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}