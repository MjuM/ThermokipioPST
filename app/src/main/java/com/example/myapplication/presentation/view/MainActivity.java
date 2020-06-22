package com.example.myapplication.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.Singletons;
import com.example.myapplication.presentation.controller.MainController;
import com.example.myapplication.presentation.model.Plant;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout mySwipeRefreshLayout;
    private SharedPreferences sharedPreferences;
    private Gson gson;
    public static String PACKAGE_NAME;
    private MainController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PACKAGE_NAME = getApplicationContext().getPackageName();
        controller = new MainController(this, Singletons.getGson(),Singletons.getSharedPreferencesInstance(getApplicationContext()));
        controller.onStart();

    }



    public void showList(final List<Plant> plantList
    ) {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mySwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(plantList, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Plant item) {
                controller.onItemClick(item);
            }
        });
        recyclerView.setAdapter(mAdapter);

    }

    private static final String BASE_URL = "https://raw.githubusercontent.com/MjuM/ProjectAndroid/master/";


    public void showError() {
        Context context = getApplicationContext();

        Toast myToast = Toast.makeText(context, "Error API", Toast.LENGTH_SHORT);
        myToast.show();
    }

    public void navigateToDetails(Plant plant) {
        Intent myIntent = new Intent(MainActivity.this, DetailActivity.class);

        myIntent.putExtra("FoodKey",Singletons.getGson().toJson(plant));
       startActivity(myIntent);

    }
}
