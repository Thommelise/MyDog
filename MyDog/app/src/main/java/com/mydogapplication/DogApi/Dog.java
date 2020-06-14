package com.mydogapplication.DogApi;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import retrofit2.http.Header;

public class Dog {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("temperament")
    private String temperament;
    @SerializedName("life_span")
    private String life_span;
    @SerializedName("alt_names")
    private String alt_names;
    @SerializedName("origin")
    private String origin;
    @SerializedName("wikipedia_url")
    private String wikipedia_url;
    @SerializedName("weight")
    private Weight weight;
    @SerializedName("country_cod")
    private String country_code;
    @SerializedName("height")
    private Height height;

    public Dog(int id,String name,String temperament,String life_span, String alt_names, String origin,String wikipedia_url, Weight weight, String country_code, Height height) {
        this.id = id;
        this.name = name;
        this.temperament = temperament;
        this.life_span = life_span;
        this.alt_names = alt_names;
        this.origin = origin;
        this.wikipedia_url = wikipedia_url;
        this.weight = weight;
        this.country_code = country_code;
        this.height = height;
    }

    public Weight getWeight() {
        return weight;
    }

    public Height getHeight() {
        return height;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTemperament() {
        return temperament;
    }

    public String getLife_span() {
        return life_span;
    }

    public String getAlt_names() {
        return alt_names;
    }

    public String getOrigin() {
        return origin;
    }

    public String getWikipedia_url() {
        return wikipedia_url;
    }

    public String getCountry_code() {
        return country_code;
    }


    public class Height {
        private String metric;
    }

    public class Weight {

        private String metric;
    }
}
