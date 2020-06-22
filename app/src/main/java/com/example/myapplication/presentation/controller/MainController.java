package com.example.myapplication.presentation.controller;

import android.content.SharedPreferences;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.myapplication.Singletons;
import com.example.myapplication.presentation.model.Plant;
import com.example.myapplication.presentation.view.MainActivity;
import com.example.myapplication.presentation.view.MyAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainController {

    private RecyclerView recyclerView;

    private MyAdapter mAdapter;

    private RecyclerView.LayoutManager layoutManager;

    private SwipeRefreshLayout mySwipeRefreshLayout;

    private SharedPreferences sharedPreferences;

    private Gson gson;

    private MainActivity view;
    public MainController(MainActivity mainActivity, Gson gson, SharedPreferences sharedPreferences){
        this.view = mainActivity;
        this.gson = gson;
        this.sharedPreferences = sharedPreferences;

    }
    public void onStart(){

        //showList();



        List<Plant> myList = new ArrayList<>();
        Plant uno = new Plant("Le Kentia", 1, 10, 24, "1 à 3 fois par semaine",  "L’Ile Lord Howe ( Pacifique )");
        Plant duo = new Plant("Le Lierre",2,5,18,"1 fois par semaine","Sous-bois d'Europe");
        Plant tre = new Plant("Echinocactus",3,5,25,"1 fois par mois", "Mexique");
        Plant quatro = new Plant("Le Piléa",4,12,22,"2 fois par semaine","Porto Rico");
        Plant cinquo = new Plant("Zamioculcas",5,10,22,"3 fois par semaine","Tanzanie");
        System.out.println("what"+uno.getOrigine());
        myList.add(uno);
        myList.add(duo);
        myList.add(tre);
        myList.add(quatro);
        myList.add(cinquo);


       // List<Plant> plantList = myList;
        if(myList != null){

            view.showList(myList);
        }else {
            view.showList(myList);
        }
    }

    public void onItemClick(Plant plant){
        view.navigateToDetails(plant);
    }



}
