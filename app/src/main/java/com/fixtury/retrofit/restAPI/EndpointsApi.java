package com.fixtury.retrofit.restAPI;

import com.fixtury.retrofit.restAPI.model.ContactoResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointsApi {
    @GET( ConstantesRestApi.URL_GET_CONTACTOS)
    Call <ContactoResponse> getContactos();
}
