package com.correo.ucp;

public class Mail {
    private String Asunto;
    private String Contenido;
    public Usuario Remitente;
    public Contactos Para;

    public Mail(){
        this.Para = new Contactos();
        this.Remitente = new Usuario();
    }

    public Mail(String Asunto, String Contenido, Usuario Remitente, Contactos Para){
        this.Asunto = Asunto;
        this.Contenido = Contenido;
        this.Para = Para;
        this.Remitente = Remitente;
    }

    public String getAsunto(){
        return Asunto;
    }

    public String getContenido(){
        return Contenido;
    }

    public Usuario getRemitente(){
        return Remitente;
    }

    public Contactos getPara(){
        return Para;
    }
}