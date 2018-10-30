package com.fixtury.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.fixtury.retrofit.model.Contacto;
import com.fixtury.retrofit.restAPI.EndpointsApi;
import com.fixtury.retrofit.restAPI.adapter.RestApiAdapter;
import com.fixtury.retrofit.restAPI.model.ContactoResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnObtenerDatos = findViewById(R.id.btnObtenerDatos);

        btnObtenerDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerDatos();

            }
        });


    }

    private void obtenerDatos() {
        Log.i("obtenerDatos", "Porceso de Conexión con retrofit");
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApi();

        Call<ContactoResponse> contactosResponseCall = endpointsApi.getContactos();

        contactosResponseCall.enqueue(new Callback<ContactoResponse>() { //Controla la respuesta
            @Override
            public void onResponse(Call<ContactoResponse> call, Response<ContactoResponse> response) {
                Log.i("obtenerDatos", "Conexión con retrofit establecida");
                ContactoResponse contactoResponse = response.body();

                ArrayList<Contacto> contactos = contactoResponse.getContactos();
                for (int i = 0; i < contactos.size() ; i++) {
                    Log.i("obtenerDatos", "Contacto = " +  contactos.get(i).getNombre() );

                }


            }

            @Override
            public void onFailure(Call<ContactoResponse> call, Throwable t) {
                Log.i("obtenerDatos", "Conexión con retrofit fallida");
            }
        });

    }
}
