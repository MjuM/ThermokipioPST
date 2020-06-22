package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Singletons {
    private static Gson gsonInstance;

    private static SharedPreferences sharedPreferencesInstance;
    public static Gson getGson(){
        if(gsonInstance == null){
            gsonInstance = new GsonBuilder()
                    .setLenient()
                    .create();
        }
        return gsonInstance;
    }
    private static final String BASE_URL = "https://raw.githubusercontent.com/MjuM/FirstMobApp/master/";

    public static SharedPreferences getSharedPreferencesInstance(Context context){
        if(sharedPreferencesInstance == null){
            sharedPreferencesInstance = context.getSharedPreferences("app_Esiea", Context.MODE_PRIVATE);
        }
        return sharedPreferencesInstance;
    }
}
