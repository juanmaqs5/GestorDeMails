package com.correo.ucp;

public class Contacto {
    private String nombre;
    public String mail;
 
    public Contacto(){
    }

    public Contacto(String nombre, String mail){
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