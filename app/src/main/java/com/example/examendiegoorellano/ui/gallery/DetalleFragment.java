package com.example.examendiegoorellano.ui.gallery;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.examendiegoorellano.Modelo.Actividad;
import com.example.examendiegoorellano.R;
import com.example.examendiegoorellano.databinding.FragmentDetalleBinding;

public class DetalleFragment extends Fragment {

    private DetalleViewModel mViewModel;
    private FragmentDetalleBinding binding;
    private TextView tvTitulo;
    private TextView tvDescricion;


    public static DetalleFragment newInstance() {
        return new DetalleFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root  =  inflater.inflate(R.layout.fragment_detalle, container, false);
        tvTitulo = root.findViewById(R.id.tvTitulo);
        tvDescricion = root.findViewById(R.id.tvDescricion);

        mViewModel = new ViewModelProvider(this).get(DetalleViewModel.class);

        binding = FragmentDetalleBinding.inflate(inflater, container, false);
        root = binding.getRoot();

        if (getArguments() != null) {
            Actividad actividad = (Actividad) getArguments().getSerializable("actividad");
            mViewModel.CargarListaConDetalle(binding,actividad);
        }
        return root;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DetalleViewModel.class);
        // TODO: Use the ViewModel
    }

}