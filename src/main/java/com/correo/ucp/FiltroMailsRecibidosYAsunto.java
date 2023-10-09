package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FiltroMailsRecibidosYAsunto{
    public List<Mail> listaMailsUsuarioYAsunto = new ArrayList<>();
    public void filtarMailsRecibidosAsunto(MailBox usuario, String contacto, String asunto){
    Predicate<Mail> buscarUsuario = mail -> contacto.equals(mail.getRemitente().getMail());
    Predicate<Mail> buscarAsunto = mail -> mail.getAsunto().contains(asunto);
    Predicate<Mail> buscarUsuarioYMail = buscarUsuario.and(buscarAsunto);
    listaMailsUsuarioYAsunto.addAll(usuario.bandejaDeEntrada.stream().filter(buscarUsuarioYMail).collect(Collectors.toList()));
    }
}