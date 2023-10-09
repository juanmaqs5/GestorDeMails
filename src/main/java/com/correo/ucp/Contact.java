package com.correo.ucp;

public class Contact {
    private String nombre;
    public String mail;
 
    public Contact(String nombre, String mail) {
        if (mail == null || mail.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.nombre = nombre;
        this.mail = mail;
    }

    public String getNombre(){
        return nombre;
    }

    public String getMail(){
        return mail;
    }
}