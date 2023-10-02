package com.correo.ucp;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MailManager MailManager = new MailManager();
        Contactos Para = new Contactos();
        Usuario remitente1 = new Usuario("Gonzalo", "gonza.mata2003@gmail.com");
        Usuario remitente2 = new Usuario("Aquinopla", "Aquinopla@gmail.com");
        Usuario destinatario = new Usuario();
        Mail correo1 = new Mail("Saludo", "Hola",remitente1 , Para);
        Mail correo2 = new Mail("Saludo", "Hola",remitente2 , Para);
        Para.agregarContactos(destinatario);
        MailManager.enviar(correo1);
        MailManager.enviar(correo1);
        MailManager.enviar(correo2);

        List<Mail> bandejaDeEntrada = destinatario.getBandejaDeEntrada();
        List<Mail> bandejaDeEntradaConFiltro = MailManager.buscarUsuario(remitente2, destinatario);

        for (Mail correo : bandejaDeEntrada) {
        System.out.println("BANDEJA DE ENTRADA"); 
        System.out.println("Asunto: " + correo.getAsunto());
        System.out.println("Remitente: " + correo.getRemitente().getNombre());
        System.out.println("Mail: " + correo.getRemitente().getMail());
        System.out.println("Contenido: " + correo.getContenido());
        System.out.println(); 
        }
        for (Mail correo : bandejaDeEntradaConFiltro) {
        System.out.println(); 
        System.out.println("BANDEJA CON FILTRO");
        System.out.println("Asunto: " + correo.getAsunto());
        System.out.println("Remitente: " + correo.getRemitente().getNombre());
        System.out.println("Mail: " + correo.getRemitente().getMail());
        System.out.println("Contenido: " + correo.getContenido());
        }
    }
}