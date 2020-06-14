package com.mydogapplication.DogApi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;


public class DogViewModel extends ViewModel {
    DogRepository repository;

    public DogViewModel() {

        repository = DogRepository.getInstance();
    }

    public LiveData<Dog> getDog() {
        return repository.getDog();
    }

    public void updateDog(String dogBreed, String apiKey) {
        repository.updateDog(dogBreed,apiKey);
    }
}
