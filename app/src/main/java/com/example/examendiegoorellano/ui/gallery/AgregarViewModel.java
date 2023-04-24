package com.example.examendiegoorellano.ui.gallery;

import androidx.lifecycle.ViewModel;

import com.example.examendiegoorellano.Modelo.Actividad;

import java.util.List;

public class AgregarViewModel extends ViewModel {

        private GalleryViewModel mGalleryViewModel;


        public AgregarViewModel(GalleryViewModel galleryViewModel) {
            mGalleryViewModel = galleryViewModel;
        }

        public void agregarActividad(String titulo, String descripcion) {

            List<Actividad> listaActual = mGalleryViewModel.getListaActividades().getValue();


            Actividad nuevaActividad = new Actividad(titulo, descripcion);


            listaActual.add(nuevaActividad);


            mGalleryViewModel.getListaActividades().setValue(listaActual);
        }
    }

}