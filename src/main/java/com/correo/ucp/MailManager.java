package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MailManager{
    public List<MailBox> listMailbox;

    public MailManager(){
        listMailbox = new ArrayList<>();
    }

    public boolean comprobarBuzonContactos(Contacto contacto){
        for(MailBox buzon : listMailbox){
            if(buzon.mail == contacto.mail){
                return true;
            }
        }
        return false;
    }

    public void crearBuzon(Mail correo){
        if(comprobarBuzonContactos(correo.remitente) == false){
            MailBox buzon1 = new MailBox();
            buzon1.mail = correo.remitente.mail;
            listMailbox.add(buzon1);
            }
        for (Contacto destinatario : correo.para){
            if(comprobarBuzonContactos(destinatario) == false){
            MailBox buzon2 = new MailBox();
            buzon2.mail = destinatario.mail;
            listMailbox.add(buzon2);
            }
        }
    }

    public void agregarCorreoBandejaDeEnviados(Mail correo) {
        Predicate<MailBox> buscarBuzon = b -> correo.getRemitente().getMail().equals(b.getMail());
        List<MailBox> listaMailsUsuario = listMailbox.stream().filter(buscarBuzon).collect(Collectors.toList());
        for(MailBox buzon : listaMailsUsuario){
            buzon.bandejaDeEnviado.add(correo);
        }
    }

    public List<MailBox> getListMailbox() {
        return listMailbox;
    }

    public void imprimirMailboxes(){
        for(MailBox buzon : listMailbox){
            System.out.println("Dirección de correo: " + buzon.mail);
        }
    }
}