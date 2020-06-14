package com.mydogapplication.DogApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface DogsApi {


        @GET("search?")
        Call<Dog> getDog(@Query("q") String dogBreed, @Query("x-api-key")String apiKey);


    }



