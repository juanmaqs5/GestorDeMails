package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FiltroMailsRecibidosYContenido {
    public List<Mail> listaMailsUsuarioYContenido = new ArrayList<>();
    public void filtarMailsRecibidosContenido(MailBox usuario, String contacto, String contenido){
    Predicate<Mail> buscarUsuario = mail -> contacto.equals(mail.getRemitente().getMail());
    Predicate<Mail> buscarContenido = mail -> mail.getContenido().contains(contenido);
    Predicate<Mail> buscarUsuarioYMail = buscarUsuario.and(buscarContenido);
    listaMailsUsuarioYContenido.addAll(usuario.bandejaDeEntrada.stream().filter(buscarUsuarioYMail).collect(Collectors.toList()));
    }
}