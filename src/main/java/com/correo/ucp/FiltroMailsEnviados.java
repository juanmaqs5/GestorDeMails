package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FiltroMailsEnviados {
    public List<Mail> listaMailsUsuario = new ArrayList<>();

    public void filtrarMailsEnviados(MailBox usuario, String contacto) {
        Predicate<Mail> buscarUsuario = mail ->mail.getPara().stream().anyMatch(destinatario -> contacto.equals(destinatario.getMail()));
        listaMailsUsuario.addAll(usuario.bandejaDeEnviado.stream().filter(buscarUsuario).collect(Collectors.toList()));
    }
}

