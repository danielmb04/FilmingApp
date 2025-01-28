package es.studium.filmingapp.ui.series;

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
import es.studium.filmingapp.databinding.FragmentSeriesBinding;

public class SeriesFragment extends Fragment {

    private FragmentSeriesBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SeriesViewModel seriessViewModel =
                new ViewModelProvider(this).get(SeriesViewModel.class);

        binding = FragmentSeriesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Lista de películas
        List<Serie> series = new ArrayList<>();

        series.add(new Serie(R.drawable.pekay,
                requireContext().getString(R.string.titulo_seri1),
                requireContext().getString(R.string.director_serie1),
                requireContext().getString(R.string.reparto_serie1),
                4.5f,
                requireContext().getString(R.string.sinopsis_serie1)

        ));

        series.add(new Serie(R.drawable.vikingos,
                requireContext().getString(R.string.titulo_seri2),
                requireContext().getString(R.string.director_serie2),
                requireContext().getString(R.string.reparto_serie2),
                4.5f,
                requireContext().getString(R.string.sinopsis_serie2)
                ));

        series.add(new Serie(R.drawable.suits,
                        requireContext().getString(R.string.titulo_serie3),
                        requireContext().getString(R.string.director_serie3),
                        requireContext().getString(R.string.reparto_serie3),
                        4f,
                        requireContext().getString(R.string.sinopsis_serie3)
        ));

        series.add(new Serie(R.drawable.prison,
                requireContext().getString(R.string.titulo_serie4),
                requireContext().getString(R.string.director_serie4),
                requireContext().getString(R.string.reparto_serie4),
                4f,
                requireContext().getString(R.string.sinopsis_serie4)
                ));

        series.add(new Serie(R.drawable.farina,
                        requireContext().getString(R.string.titulo_serie5),
                        requireContext().getString(R.string.director_serie5),
                        requireContext().getString(R.string.reparto_serie5),
                        4f,
                        requireContext().getString(R.string.sinopsis_serie5)
        ));




        // Configurar RecyclerView
        RecyclerView recyclerView = binding.recyclerSeries;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new SerieAdapter(getContext(), series));

        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}