package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FiltroMailsRecibidos {
    public List<Mail> listaMailsUsuario = new ArrayList<>();

    public void filtarMailsRecibidos(MailBox usuario, String contacto) {
        Predicate<Mail> buscarUsuario = mail -> contacto.equals(mail.getRemitente().getMail());
        listaMailsUsuario.addAll(usuario.bandejaDeEntrada.stream().filter(buscarUsuario).collect(Collectors.toList()));
    }    
}
