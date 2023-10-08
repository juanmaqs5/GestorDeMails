package com.correo.ucp;

public class Contact {
    private String nombre;
    public String mail;
 
    public Contact(){
    }

    public Contact(String nombre, String mail){
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