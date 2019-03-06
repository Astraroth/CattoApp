package com.example.cattoapp.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface CatImageApi {

    @Headers("x-api-key: " + "c445322a-430a-4c33-ac6c-85c0a459fs97")
    @GET("images/search")
    Call<List<CatImage>> getCatImageById(@Query("breed_id") String breed_id);
}
