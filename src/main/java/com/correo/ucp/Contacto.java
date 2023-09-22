package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;

public class Contacto {
    private String Nombre;
    private String Mail;
    public List<Correo> BandejaDeEntrada = new ArrayList<>();
    public List<Correo> BandejaDeEnviado = new ArrayList<>();
 
    public Contacto(){
    }

    public List<Correo> getBandejaDeEnviado(){
        return BandejaDeEnviado;
    }

    public List<Correo> getBandejaDeEntrada(){
        return BandejaDeEntrada;
    }

    public Contacto(String Nombre, String Mail){
        this.Nombre = Nombre;
        this.Mail = Mail;
    }
}
