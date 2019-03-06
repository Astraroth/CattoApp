package com.example.cattoapp.model;

import com.example.cattoapp.model.CatBreed;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface CatRestApi {

    @Headers("x-api-key: " + "c445322a-430a-4c33-ac6c-85c0a459fs97")
    @GET("breeds")
    Call<List<CatBreed>> getListCatBreeds();

    @GET("images/search/")
    Call<List<CatImage>> getCatImageById(@Query("breed") String breed_id);
}
