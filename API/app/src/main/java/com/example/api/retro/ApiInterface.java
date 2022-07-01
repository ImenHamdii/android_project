package com.example.api.retro;

import com.example.api.model.Smartphone;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("smartphone.php")
    Call<List<Smartphone>> getSmartphone();
}
