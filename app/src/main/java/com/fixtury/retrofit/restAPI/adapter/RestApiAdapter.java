package com.fixtury.retrofit.restAPI.adapter;

import com.fixtury.retrofit.restAPI.ConstantesRestApi;
import com.fixtury.retrofit.restAPI.EndpointsApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {
    public EndpointsApi establecerConexionRestApi(){
       Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit.create(EndpointsApi.class);
    }
}
