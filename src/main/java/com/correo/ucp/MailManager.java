package com.correo.ucp;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MailManager{
    public void enviar(Mail correo){
        correo.Remitente.BandejaDeEnviado.add(correo);
        for (Usuario destinatario : correo.Para.Contactos) {
            destinatario.BandejaDeEntrada.add(correo);
    }
    }

    public List<Mail> buscarUsuario(Usuario contact, Usuario user) {
    Predicate<Mail> emailBuscar = mail -> mail.getRemitente().getMail().equals(contact.getMail());
    List<Mail> listaMailsUsuario = user.getBandejaDeEntrada().stream().filter(emailBuscar).collect(Collectors.toList());
    return listaMailsUsuario;
}
}
