package com.example.cattoapp.controller;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.cattoapp.model.CatRestApi;
import com.example.cattoapp.view.MainActivity;
import com.example.cattoapp.model.CatBreed;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {

    private final MainActivity mainActivity;
    private static MainController instance = null;
    private static String key = "key";
    private SharedPreferences sharedPreferences;

    public static MainController getInstance(MainActivity mainActivity, SharedPreferences sharedPreferences){
        if(instance == null){
            instance = new MainController(mainActivity, sharedPreferences);
        }
        return instance;
    }

    public MainController(MainActivity mainActivity, SharedPreferences sharedPreferences) {
        this.mainActivity = mainActivity;
        this.sharedPreferences = sharedPreferences;
    }

    public void onCreate() {

        if(sharedPreferences.contains(key)){
            mainActivity.showLoader();
            String cache = sharedPreferences.getString(key, null);
            Type listType = new TypeToken<List<CatBreed>>(){}.getType();
            List<CatBreed> listcatbreed = new Gson().fromJson(cache, listType);
            mainActivity.showList(listcatbreed);
            mainActivity.hideLoader();


        }
        else{
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

                    Gson gson1 = new Gson();
                    String cache = gson1.toJson(listCatBreed);

                    sharedPreferences
                            .edit()
                            .putString(key, cache)
                            .apply();


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

}

