package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MailManager mailManager = new MailManager();
        MailBox buzon = new MailBox("Alex@gmail.com");
        mailManager.listMailbox.add(buzon);
        Contact contacto1 = new Contact("Alex", "Alex@gmail.com");
        Contact contacto2 = new Contact("Juan","Juan@gmail.com");
        Contact contacto3 = new Contact("Pedro", "Pedro@gmail.com");
        List<Contact> para = new ArrayList<>();
        List<Contact> para1 = new ArrayList<>();
        para.add(contacto2);
        para1.add(contacto3);
        Mail correo = new Mail("Saludo", "Hola Juan", contacto1 , para);
        Mail correo1 = new Mail("Plata", "Juan me debes plata", contacto1 , para);
        Mail correo2 = new Mail("Saludo", "Hola Pedro", contacto1 , para1);
        mailManager.enviarCorreo(correo);
        mailManager.enviarCorreo(correo1);
        mailManager.enviarCorreo(correo2);
        FiltroMailsEnviadosYAsunto filtro = new FiltroMailsEnviadosYAsunto();
        filtro.filtarMailsEnviadosAsunto(buzon, "Juan@gmail.com","Saludo");
        for (Mail correoFiltrado : filtro.listaMailsUsuarioYAsunto){
        System.out.println("Asunto: " + correoFiltrado.getAsunto());
        System.out.println("Contenido: " + correoFiltrado.getContenido());
        System.out.println("Remitente: " + correoFiltrado.getRemitente().getMail());
}
}
}