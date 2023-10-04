package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MailManager{
    public List<MailBox> listMailbox;

    public MailManager() {
        listMailbox = new ArrayList<>();
    }

    public void crearBuzon(Mail correo){
        MailBox buzon1 = new MailBox();
        buzon1.mail = correo.remitente.mail;
        listMailbox.add(buzon1);
        for (Contacto destinatario : correo.para) {
            MailBox buzon2 = new MailBox();
            buzon2.mail = destinatario.mail;
            listMailbox.add(buzon2);
        }
    }

    public void agregarCorreoBandejaDeEnviados(Mail correo) {
    for (MailBox buzon : listMailbox){
    Predicate<MailBox> buscarBuzon = m -> correo.getRemitente().getMail().equals(buzon.getMail());
    }
    List<Mail> listaMailsUsuario = listMailbox.stream().filter(buscarBuzon).collect(Collectors.toList());
}

    public List<MailBox> getMailBox(){
        return listMailbox;
    }

    public void imprimirMailboxes() {
        for (MailBox buzon : listMailbox) {
            System.out.println("Dirección de correo: " + buzon.mail);
        }
    }
}