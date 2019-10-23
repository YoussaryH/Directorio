package com.example.yhernandez.directorio.Api;

import com.example.yhernandez.directorio.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service
{

    String token = "f8191aac0a741a2a61be9187042995a2";
    String API_ROUTE = "/3/genre/28/movies?api_key=" + token;


    @GET(API_ROUTE)
    Call<ItemResponse> getItems();
}
