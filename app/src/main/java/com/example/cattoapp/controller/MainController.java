package com.example.cattoapp.controller;

import android.app.Activity;
import android.util.Log;

import com.example.cattoapp.DetailsActivity;
import com.example.cattoapp.model.CatImage;
import com.example.cattoapp.model.CatImageApi;
import com.example.cattoapp.model.CatRestApi;
import com.example.cattoapp.MainActivity;
import com.example.cattoapp.model.CatBreed;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {

    private final MainActivity mainActivity;
    private static MainController instance = null;

    public static MainController getInstance(MainActivity mainActivity){
        if(instance == null){
            instance = new MainController(mainActivity);
        }
        return instance;
    }

    public MainController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void onCreate() {

        mainActivity.showLoader();

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thecatapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CatRestApi catRestApi = retrofit.create(CatRestApi.class);
        Call<List<CatBreed>> call = catRestApi.getListCatBreeds();

        call.enqueue(new Callback<List<CatBreed>>() {
            @Override
            public void onResponse(Call<List<CatBreed>> call, Response<List<CatBreed>> response) {

                List<CatBreed> listCatBreed = response.body();
                mainActivity.showList(listCatBreed);
                mainActivity.hideLoader();
            }

            @Override
            public void onFailure(Call<List<CatBreed>> call, Throwable t) {
                Log.d("Erreur", "API ERROR");
            }
        });

    }

}

