package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MailManager{
    public List<MailBox> mailbox;

    public MailManager() {
        mailbox = new ArrayList<>();
    }
    
    public void enviar(Mail correo){
        for (Contacto destinatario : correo.para) {
            MailBox buzon = new MailBox();
            buzon.mail = destinatario.mail;
            mailbox.add(buzon);
        }
    }

    public List<Mail> buscarUsuario(MailBox user) {
    Predicate<Mail> buscarUsuario = mail -> mail.getRemitente().getMail().equals(user.getMail());
    List<Mail> listaMailsUsuario = user.getBandejaDeEntrada().stream().filter(emailBuscar).collect(Collectors.toList());
    return listaMailsUsuario;
}

    public List<MailBox> getMailBox(){
        return mailbox;
    }

    public void imprimirMailboxes() {
        for (MailBox buzon : mailbox) {
            System.out.println("Dirección de correo: " + buzon.mail);
        }
    }
}