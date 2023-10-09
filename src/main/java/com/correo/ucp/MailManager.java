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

    public boolean comprobarBuzonContactos(Contact contacto){
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
        for (Contact destinatario : correo.para){
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

    public void agregarCorreoBandejaDeEntrada(Mail correo){
        List<MailBox> listaMailsUsuario = new ArrayList<>();
        for (Contact destinatario : correo.para) {
            Predicate<MailBox> buscarBuzon = b -> destinatario.getMail().equals(b.getMail());
            listaMailsUsuario.addAll(listMailbox.stream().filter(buscarBuzon).collect(Collectors.toList()));
        }
        for (MailBox buzon : listaMailsUsuario) {
            buzon.bandejaDeEntrada.add(correo);
        }
    }

    public void enviarCorreo(Mail correo){
        crearBuzon(correo);
        agregarCorreoBandejaDeEnviados(correo);
        agregarCorreoBandejaDeEntrada(correo);
    }
}