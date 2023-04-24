package com.example.examendiegoorellano.ui.gallery;

import android.app.Application;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examendiegoorellano.Modelo.Actividad;
import com.example.examendiegoorellano.databinding.FragmentDetalleBinding;

import java.util.ArrayList;
import java.util.List;

public class DetalleViewModel extends ViewModel {
    private MutableLiveData<TextView> titulo = new MutableLiveData<>();
    private MutableLiveData<TextView> descricion = new MutableLiveData<>();

    public DetalleViewModel(@NonNull Application application) {
        super(application);
    }

         public void CargarListaConDetalle(FragmentDetalleBinding binding, Actividad actividad)
        {
            binding.tvTitulo.setText(actividad.getTitulo());
            binding.tvDescricion.setText(actividad.getDescricion());

        }


}