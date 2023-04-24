package com.example.examendiegoorellano.ui.gallery;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examendiegoorellano.Modelo.Actividad;

import java.util.ArrayList;
import java.util.List;

    public class GalleryViewModel extends AndroidViewModel {
        private MutableLiveData<List<Actividad>> listaActividadesLiveData = new MutableLiveData<>();

        public GalleryViewModel(@NonNull Application application) {
            super(application);
        }

        public LiveData<List<Actividad>> getListaActividades() {

            if (listaActividadesLiveData.getValue() == null) {

                ArrayList<Actividad> lista = new ArrayList<>();
                lista.add(new Actividad("Yoga en el parque", "Clase de yoga al aire libre en el parque"));
                lista.add(new Actividad("Concierto en vivo", "Concierto de música rock en vivo"));
                lista.add(new Actividad("Cine bajo las estrellas", "Proyección de película al aire libre"));
                lista.add(new Actividad("Tour de arte urbano", "Recorrido por los murales y graffitis de la ciudad"));
                lista.add(new Actividad("Clases de cocina", "Taller de cocina italiana"));
                listaActividadesLiveData.setValue(lista);
            }
            return listaActividadesLiveData;
        }




    }





}