package com.example.examendiegoorellano.ui.gallery;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examendiegoorellano.Modelo.Actividad;
import com.example.examendiegoorellano.R;
import com.example.examendiegoorellano.databinding.FragmentGalleryBinding;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private Context context;
    private RecyclerView rv;
    private TextView actividadTitulo;
    private TextView actividadDescricion;
    private Button btnAgregarActividad;
    private GalleryViewModel mViewModel;
    private RecyclerView rvLista;

    public static GalleryFragment newInstance() {
        return new GalleryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        rvLista = root.findViewById(R.id.rvLista);

        btnAgregarActividad = root.findViewById(R.id.btnAgregarActividad);

        btnAgregarActividad.setOnClickListener(v -> {
            // Navega al AgregarFragment utilizando el NavController
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_nav_gallery_to_agregarFragment);
        });


        GridLayoutManager grilla = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
        rvLista.setLayoutManager(grilla);

        mViewModel.getListaActividades().observe(getViewLifecycleOwner(), listaActividades -> {
            ActividadAdarter adapter = new ActividadAdarter(getContext(),listaActividades, getLayoutInflater(), mViewModel);
            rvLista.setAdapter(adapter);
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(GalleryViewModel.class);
        // TODO: Use the ViewModel
    }

    }
