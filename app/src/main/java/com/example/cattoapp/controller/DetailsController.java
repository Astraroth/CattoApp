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

public class DetailsController {

    private final DetailsActivity detailsActivity;
    private static DetailsController instance = null;

    //Exemple Singleton
    public static DetailsController getInstance(DetailsActivity detailsActivity){
        if(instance == null){
            instance = new DetailsController(detailsActivity);
        }
        return instance;
    }

    public DetailsController(DetailsActivity detailsActivity) {
        this.detailsActivity = detailsActivity;
    }

    public void onCreate() {

        Gson gson = new GsonBuilder().setLenient().create();

        //On crée un objet retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thecatapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
              .build();

        //On crée notre interface
        CatRestApi catRestApi = retrofit.create(CatRestApi.class);

        CatImageApi catImageApi = retrofit.create(CatImageApi.class);
        Call<List<CatImage>> call2 = catRestApi.getCatImageById("breed_id");

        call2.enqueue(new Callback<List<CatImage>>() {
            @Override
            public void onResponse(Call<List<CatImage>> call2, Response<List<CatImage>> response2) {

                List<CatImage> listCatImage = response2.body();

                detailsActivity.showImg(listCatImage.get(0).getUrl());
            }

            @Override
            public void onFailure(Call<List<CatImage>> call2, Throwable t2) {
                Log.d("Erreur", "API ERROR");
            }
        });

    }

}

