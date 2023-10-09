package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FiltroAsunto {
    public List<Mail> listaMailsAsunto = new ArrayList<>();
    public void filtrarMailsAsunto(MailBox usuario, String asunto) {
            Predicate<Mail> buscarAsunto = mail -> mail.getAsunto().contains(asunto);
            listaMailsAsunto.addAll(usuario.bandejaDeEntrada.stream().filter(buscarAsunto).collect(Collectors.toList()));
            listaMailsAsunto.addAll(usuario.bandejaDeEnviado.stream().filter(buscarAsunto).collect(Collectors.toList()));
        }    
}
