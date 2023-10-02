package com.correo.ucp;

public class Usuario extends Bandeja{
    private String Nombre;
    private String Mail;
 
    public Usuario(){
    }

    public Usuario(String Nombre, String Mail){
        this.Nombre = Nombre;
        this.Mail = Mail;
    }

    public String getNombre(){
        return Nombre;
    }

    public String getMail(){
        return Mail;
    }
}
