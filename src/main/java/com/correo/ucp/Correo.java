package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;

public class Correo {
    private String Asunto;
    private String Contenido;
    private Contacto Remitente;
    private List<Contacto> Para = new ArrayList<>();
    private List<Correo> BandejaDeEnviado = new ArrayList<>();

    public Correo(String Asunto, String Contenido, Contacto Remitente) {
        this.Asunto = Asunto;
        this.Contenido = Contenido;
        this.Remitente = Remitente;
    }
    
    public void agregarContactos(Contacto contact){
        Para.add(contact);
    }

    public List<Contacto> getPara(){
        return Para;
    }

}