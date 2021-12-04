package com.example.proyectaso.ui.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectaso.R;

public class DescriptionActivity extends AppCompatActivity {

    ImageView ivProductaso;
    TextView titleDescriptionTextView;
    TextView cityDescriptionTextView;
    TextView descDescriptionTextView;
    ImageView ivMoneda;
    TextView statusDescriptionTextView;

    Button comprarProductoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        comprarProductoButton = (Button)findViewById(R.id.comprarProductoButton);

        ListElement element = (ListElement) getIntent().getSerializableExtra("ListElement");

        ivProductaso = findViewById(R.id.ivProductaso);

        titleDescriptionTextView = findViewById(R.id.titleDescriptionTextView);
        cityDescriptionTextView = findViewById(R.id.cityDescriptionTextView);
        descDescriptionTextView = findViewById(R.id.descDescriptionTextView);
        statusDescriptionTextView = findViewById(R.id.statusDescriptionTextView);
        ivMoneda = findViewById(R.id.ivMoneda);

        ivProductaso.setImageResource(element.getImage());

        titleDescriptionTextView.setText(element.getName());
        titleDescriptionTextView.setTextColor(Color.GRAY);

        cityDescriptionTextView.setText(element.getCity());

        descDescriptionTextView.setText(element.getColor());

        statusDescriptionTextView.setText(element.getStatus());
        statusDescriptionTextView.setTextColor(Color.GRAY);

        comprarProductoButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent i = new Intent(DescriptionActivity.this, MainActivity.class);
                Toast.makeText(DescriptionActivity.this, "La compra se ha realizado con éxito. " +
                        "La información fue proporcionada a su correo", Toast.LENGTH_SHORT).show();
            }
        });


    }
}