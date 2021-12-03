package com.example.proyectaso.ui.fragments.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectaso.R;

import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarViewHolder>
{
    private final ArrayList<String> dayOfMonth;

    public CalendarAdapter(ArrayList<String> dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.calendar_cell, parent,false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height= (int)(parent.getHeight()*1.66666666);
        return  new CalendarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
