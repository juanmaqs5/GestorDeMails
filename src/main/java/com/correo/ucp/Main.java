package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MailManager mailManager = new MailManager();
        List<Contact> para = new ArrayList<>();
        Contact remitente = new Contact("Alex", "Alex@gmail.com");
        Contact destinatario = new Contact("Gonzalo","gonza.mata2003@gmail.com");
        Contact destinatario1 = new Contact("Gonzalo","gonza1.mata2003@gmail.com");
        Mail correo = new Mail("Hola", "hola", remitente , para);
        correo.para.add(destinatario);
        correo.para.add(destinatario1);
        mailManager.crearBuzon(correo);
        mailManager.agregarCorreoBandejaDeEnviados(correo);

        List<MailBox> buzones = mailManager.getListMailbox();
        for (MailBox buzon : buzones) {
            System.out.println("Buzón: " + buzon.getMail());
            List<Mail> bandejaEnviados = buzon.getBandejaDeEnviado();
            for (Mail mail : bandejaEnviados) {
                System.out.println(" - " + mail.getAsunto());
            }
        }
    }
}