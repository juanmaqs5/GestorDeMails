package com.correo.ucp;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MailManager mailManager = new MailManager();
        Contacto destinatario = new Contacto("Gonzalo","gonza.mata2003@gmail.com");
        Contacto destinatario1 = new Contacto("Gonzalo","gonza.mata2003@gmail.com");
        Mail correo = new Mail();
        correo.para.add(destinatario);
        correo.para.add(destinatario1);
        mailManager.enviar(correo);

        mailManager.imprimirMailboxes();
        }
    }