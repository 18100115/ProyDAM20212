package com.example.proyectaso.ui.fragments.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectaso.R;

public class CalendarViewHolder extends RecyclerView.ViewHolder {
    private final TextView dayOfMonth;
    public CalendarViewHolder(@NonNull View itemView) {
        super(itemView);
        dayOfMonth = itemView.findViewById(R.id.cellDaytext);
    }
}
