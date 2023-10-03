package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;

public class Mail {
    private String asunto;
    private String contenido;
    public Contacto remitente;
    public List<Contacto> para;

    public Mail(){
        this.remitente = new Contacto();
        this.para = new ArrayList<>();
    }

    public Mail(String asunto, String contenido, Contacto remitente, List<Contacto> para){
        this.asunto = asunto;
        this.contenido = contenido;
        this.para = para;
        this.remitente = remitente;
    }

    public String getAsunto(){
        return asunto;
    }

    public String getContenido(){
        return contenido;
    }

    public Contacto getRemitente(){
        return remitente;
    }

    public List<Contacto> getPara(){
        return para;
    }
}