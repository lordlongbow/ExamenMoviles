package com.example.examendiegoorellano.ui.gallery;

import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.examendiegoorellano.R;

public class AgregarFragment extends Fragment {

    private AgregarViewModel mViewModel;
    private Button btnAgregar;
    private EditText etTitulo;
    private EditText etDescripcion;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_agregar, container, false);

        btnAgregar = root.findViewById(R.id.btnAgregar);
        etTitulo = root.findViewById(R.id.etTitulo);
        etDescripcion = root.findViewById(R.id.etDescricion);


        btnAgregar.setOnClickListener(v -> {

            String titulo = etTitulo.getText().toString();
            String descripcion = etDescripcion.getText().toString();
            mViewModel.agregarActividad(titulo, descripcion);
            etTitulo.setText("");
            etDescripcion.setText("");
        });


        return root;
    }


}