package com.mydogapplication.DogApi;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mydogapplication.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DogRepository {
   View v;
   EditText test;

    private static DogRepository instance;
    private MutableLiveData<Dog> dog;

    private DogRepository() {
        dog = new MutableLiveData<>();

    }

    public static synchronized DogRepository getInstance() {
        if (instance == null) {
            instance = new DogRepository();
        }
        return instance;
    }

    public LiveData<Dog> getDog() {
        return dog;
    }

    public void updateDog(String dogBreed,String apiKey )  {
        DogsApi dogApi = ServiceGenerator.getDogApi();
        Call<Dog> call = dogApi.getDog(dogBreed,apiKey);
        call.enqueue(new Callback<Dog>() {
            @Override
            public void onResponse(Call<Dog> call, Response<Dog> response) {
                if (response.code() == 200) {
                    dog.setValue(response.body());
                }
                }

            @Override
            public void onFailure(Call<Dog> call, Throwable t) {

            }


        });
    }
}
