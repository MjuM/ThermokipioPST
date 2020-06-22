package com.example.myapplication.presentation.model;

public class Plant {


    public String getName() {
        return name;
    }
    public int getId(){ return id;}
    public int getTemperatureMin() {
        return temperatureMin;
    }
    public int getTemperatureMax() {
        return temperatureMax;
    }
    private String name;
    private int id;
    private int temperatureMin;

    private int temperatureMax;
    private String frequence;
    private String origine;



    public String getFrequence() {
        return frequence;
    }

    public String getOrigine() {
        return origine;
    }

    public Plant(String name, int id, int temperatureMin, int temperatureMax, String frequence, String origine){
         this.name = name;
        this.id = id;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.frequence = frequence;
        this.origine = origine;
    }



}
