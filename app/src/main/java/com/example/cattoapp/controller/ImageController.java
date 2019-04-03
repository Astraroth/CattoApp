
package com.example.cattoapp.controller;

import android.util.Log;
import com.example.cattoapp.view.ImageActivity;
import com.example.cattoapp.model.CatImage;
import com.example.cattoapp.model.CatRestApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImageController {

    private final ImageActivity imageActivity;
    private static ImageController instance = null;

    //Exemple Singleton
    public static ImageController getInstance(ImageActivity imageActivity) {
        if (instance == null) {
            instance = new ImageController(imageActivity);
        }
        return instance;
    }

    public ImageController(ImageActivity imageActivity) {
        this.imageActivity = imageActivity;
    }

    public void onCreate() {

        Gson gson = new GsonBuilder().setLenient().create();

        //On crée un objet retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thecatapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CatRestApi catRestApi = retrofit.create(CatRestApi.class);
        Call<List<CatImage>> call2 = catRestApi.getCatImageById();

        call2.enqueue(new Callback<List<CatImage>>() {
            @Override
            public void onResponse(Call<List<CatImage>> call2, Response<List<CatImage>> response2) {

                List<CatImage> listCatImage = response2.body();
                imageActivity.showImg(listCatImage.get(0).getUrl());
            }

            @Override
            public void onFailure(Call<List<CatImage>> call2, Throwable t2) {
                Log.d("Erreur", "API ERROR");
            }
        });
    }
}