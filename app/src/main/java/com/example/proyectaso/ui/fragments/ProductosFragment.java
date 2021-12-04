package com.example.proyectaso.ui.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectaso.R;

import java.util.ArrayList;
import java.util.List;

public class ProductosFragment extends Fragment {

    List<ListElement> elements;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_productos, container, false);

        init();

        elements = new ArrayList<>();
        elements.add(new ListElement(R.drawable.sombrero, "Diseño alto y elegante", "Sombrero PL", "Modelo en diseño crema", "500"));
        elements.add(new ListElement(R.drawable.lentes, "Colores: Rojo y azul", "Lentes de sol", "Con protección UVH", "75"));
        elements.add(new ListElement(R.drawable.camisa,"Tallas: M, L y XL", "Camisa celeste", "Bordado de seda", "250"));
        elements.add(new ListElement(R.drawable.pantalones, "Tallas: 28-38", "Pantalones marrones", "Bolsillos inferiores", "185"));
        elements.add(new ListElement(R.drawable.zapatillas, "Estilo deportivas y casual", "Zapatillas negras", "Zapatillas negras", "150"));

        ListAdapter listAdapter = new ListAdapter(elements, getActivity().getApplication(), new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListElement item) {
                moveToDescription(item);

            }
        });
        RecyclerView recyclerView = view.findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplication()));
        recyclerView.setAdapter(listAdapter);


        return view;

    }

    public void init(){}

    public void moveToDescription(ListElement item) {
        Intent intent = new Intent(getActivity().getApplication(), DescriptionActivity.class);
        intent.putExtra("ListElement", item);
        startActivity(intent);

    }


}