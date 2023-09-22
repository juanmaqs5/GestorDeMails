package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;

public class Correo {
    private String Asunto;
    private String Contenido;
    private Contacto Remitente;
    private List<Contacto> Para = new ArrayList<>();
    
    public Correo(String Asunto, String Contenido, Contacto Remitente, List<Contacto> Para) {
        this.Asunto = Asunto;
        this.Contenido = Contenido;
        this.Remitente = Remitente;
        this.Para = Para;
    }
    
    public void agregarContactos(Contacto contact){
        Para.add(contact);
    }

    public List<Contacto> getPara(){
        return Para;
    }

    public void enviar(Correo correo){
        Remitente.BandejaDeEnviado.add(correo);
        for (Contacto destinatario : Para) {
            destinatario.BandejaDeEntrada.add(correo);
    }
}
}