package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FiltroMailsEnviadosYAsunto {
    public List<Mail> listaMailsUsuarioYAsunto = new ArrayList<>();
    public void filtarMailsEnviadosAsunto(MailBox usuario, String contacto, String asunto){
    Predicate<Mail> buscarUsuario = mail ->mail.getPara().stream().anyMatch(destinatario -> contacto.equals(destinatario.getMail()));
    Predicate<Mail> buscarAsunto = mail -> mail.getAsunto().contains(asunto);
    Predicate<Mail> buscarUsuarioYMail = buscarUsuario.and(buscarAsunto);
    listaMailsUsuarioYAsunto.addAll(usuario.bandejaDeEnviado.stream().filter(buscarUsuarioYMail).collect(Collectors.toList()));
    }
}
