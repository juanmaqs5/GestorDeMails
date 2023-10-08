package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;

public class Mail {
    private String asunto;
    private String contenido;
    public Contact remitente;
    public List<Contact> para;

    public Mail(){
        this.remitente = new Contact();
        this.para = new ArrayList<>();
    }

    public Mail(String asunto, String contenido, Contact remitente, List<Contact> para){
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

    public Contact getRemitente(){
        return remitente;
    }

    public List<Contact> getPara(){
        return para;
    }
}