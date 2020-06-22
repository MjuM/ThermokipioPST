package com.example.myapplication.presentation.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.Singletons;
import com.example.myapplication.presentation.model.Plant;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private TextView txtDetail;
    private TextView txtDetail2;
    private TextView txtDetail3;
    private TextView txtDetail4;
    private TextView txtDetail5;
    private Plant plant;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.detail_activity );
        txtDetail = findViewById(R.id.detail_txt);
        txtDetail2= findViewById(R.id.detail_txt2);
        txtDetail3 = findViewById(R.id.detail_txt3);
        txtDetail4 = findViewById(R.id.detail_txt4);
        txtDetail5 = findViewById(R.id.detail_txt5);
        Intent intent = getIntent();
        String IngrJson = intent.getStringExtra("FoodKey");

         plant = Singletons.getGson().fromJson(IngrJson, Plant.class);

        Context context = getApplicationContext();





        showDetail(plant);
    }


    private void showDetail(Plant plant) {
        txtDetail.setText("Nom de la plante : "+plant.getName());
       txtDetail2.setText("Origine de la plante: "+plant.getOrigine());
        txtDetail3.setText("Temperature Minimum : "+plant.getTemperatureMin()+"C");
        txtDetail4.setText("Temperature Maximale: "+plant.getTemperatureMax()+"C");
        txtDetail5.setText("Frequence d'arosage: "+plant.getFrequence());


    }



}
