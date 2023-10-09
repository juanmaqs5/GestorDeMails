package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FiltroMailsEnviadosYContenido {
    public List<Mail> listaMailsUsuarioYContenido = new ArrayList<>();
    public void filtarMailsEnviadosContenido(MailBox usuario, String contacto, String contenido){
    Predicate<Mail> buscarUsuario = mail ->mail.getPara().stream().anyMatch(destinatario -> contacto.equals(destinatario.getMail()));
    Predicate<Mail> buscarContenido = mail -> mail.getContenido().contains(contenido);
    Predicate<Mail> buscarUsuarioYMail = buscarUsuario.and(buscarContenido);
    listaMailsUsuarioYContenido.addAll(usuario.bandejaDeEnviado.stream().filter(buscarUsuarioYMail).collect(Collectors.toList()));
    }
}
