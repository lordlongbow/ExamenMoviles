package com.example.examendiegoorellano.ui.slideshow;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.examendiegoorellano.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public static SlideshowFragment newInstance() {
        return new SlideshowFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        mostrarDialogoDeConfirmacion();
        return binding.getRoot();
    }


    private void mostrarDialogoDeConfirmacion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("¿Salir?");
        builder.setMessage("¿Está seguro que desea salir?");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                getActivity().finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}

