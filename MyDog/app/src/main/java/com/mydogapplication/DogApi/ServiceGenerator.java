package com.mydogapplication.DogApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://api.thedogapi.com/v1/breeds/")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static DogsApi dogApi = retrofit.create(DogsApi.class);

    public static DogsApi getDogApi() {
        return dogApi;
    }


}
