package com.fixtury.retrofit.restAPI.model;

import com.fixtury.retrofit.model.Contacto;

import java.util.ArrayList;

public class ContactoResponse {
    ArrayList<Contacto> contactos;

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
}
