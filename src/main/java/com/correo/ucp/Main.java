package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MailManager mailManager = new MailManager();
        List<Contacto> para = new ArrayList<>();
        Contacto remitente = new Contacto("Alex", "Alex@gmail.com");
        Contacto destinatario = new Contacto("Gonzalo","gonza.mata2003@gmail.com");
        Contacto destinatario1 = new Contacto("Gonzalo","gonza.mata2003@gmail.com");
        Mail correo = new Mail("Hola", "hola", remitente , para);
        correo.para.add(destinatario);
        correo.para.add(destinatario1);
        mailManager.crearBuzon(correo);

        mailManager.imprimirMailboxes();
        }
    }