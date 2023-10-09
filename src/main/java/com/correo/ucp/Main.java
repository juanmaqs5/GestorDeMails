package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MailManager mailManager = new MailManager();
        MailBox buzon = new MailBox("gonza.mata2003@gmail.com");
        mailManager.listMailbox.add(buzon);
        List<Contact> para = new ArrayList<>();
        Contact remitente = new Contact("Alex", "Alex@gmail.com");
        Contact remitente1 = new Contact("Pedro", "Pedro@gmail.com");
        Contact destinatario = new Contact("Gonzalo","gonza.mata2003@gmail.com");
        para.add(destinatario);
        Mail correo = new Mail("Hola", "me llamo alex", remitente , para);
        Mail correo1 = new Mail("Hola", "me llamo alex", remitente , para);
        Mail correo2 = new Mail("Hola", "me llamo pedro", remitente1 , para);
        mailManager.enviarCorreo(correo);
        mailManager.enviarCorreo(correo1);
        mailManager.enviarCorreo(correo2);
        FiltroMailsRecibidos filtroPara = new FiltroMailsRecibidos();
        filtroPara.fil(buzon, "Pedro@gmail.com");
        List<Mail> listaMailsUsuario = filtroPara.listaMailsUsuario;
    for (Mail correoFiltrado : listaMailsUsuario){
        System.out.println("Asunto: " + correoFiltrado.getAsunto());
        System.out.println("Contenido: " + correoFiltrado.getContenido());
        System.out.println("Remitente: " + correoFiltrado.getRemitente().getMail());
    }
}
}