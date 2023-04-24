package com.example.examendiegoorellano.ui.gallery;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examendiegoorellano.Modelo.Actividad;
import com.example.examendiegoorellano.R;

import java.util.List;

public class ActividadAdarter extends RecyclerView.Adapter {

    private List<Actividad> listaActividades;
    private LayoutInflater inflater;
    private Context context;
    private GalleryViewModel viewModel;


    public ActividadAdarter(Context context,List<Actividad> listaActividades, LayoutInflater inflater, GalleryViewModel viewModel) {
        this.listaActividades = listaActividades;
        this.inflater = inflater;
        this.context = context;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.actividaditem, parent, false);
        return new ActividadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Actividad actividad = listaActividades.get(position);

        ActividadViewHolder actividadViewHolder = (ActividadViewHolder) holder;
        actividadViewHolder.tvTitulo.setText(actividad.getTitulo());
        actividadViewHolder.tvDescripcion.setText(actividad.getDescricion());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class ActividadViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitulo;
        public TextView tvDescripcion;

        public Button btnDetalleActividad;

        public ActividadViewHolder(View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvDescripcion = itemView.findViewById(R.id.tvDescricion);
            btnDetalleActividad = itemView.findViewById(R.id.btnDetalles);

            btnDetalleActividad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Abrir la vista de detalles de la actividad

                    Bundle args = new Bundle();
                    args.putSerializable("actividad", listaActividades.get(getAdapterPosition()));
                    Log.d("ruebas" , args+"");
                    Navigation.findNavController((Activity) context, R.id.action_nav_gallery_to_detalleFragment).navigate(R.id.action_nav_gallery_to_detalleFragment, args);
                }
            });
        }

    }
}
