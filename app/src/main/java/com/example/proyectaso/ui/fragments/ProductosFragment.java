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
        elements.add(new ListElement(R.drawable.camisa, "Pedro", "México", "Soltero", "dssad"));
        elements.add(new ListElement(R.drawable.sombrero, "Luis", "Peru", "Activo", "dssad"));
        elements.add(new ListElement(R.drawable.lentes,"Ricard", "Argentina", "Casado", "dssad"));
        elements.add(new ListElement(R.drawable.zapatillas, "Alvaro", "Colombia", "Divorciado", "dssad"));
        elements.add(new ListElement(R.drawable.sombrero, "Gustavo", "Venezuela", "Viudo", "dssad"));

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