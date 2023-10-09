package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FiltroContenido{
    public List<Mail> listMailsContenido = new ArrayList<>();
    public void filtrarMailsContenido(MailBox usuario, String contenido){
            Predicate<Mail> buscarContenido = mail -> mail.getContenido().contains(contenido);
            listMailsContenido.addAll(usuario.bandejaDeEntrada.stream().filter(buscarContenido).collect(Collectors.toList()));
            listMailsContenido.addAll(usuario.bandejaDeEnviado.stream().filter(buscarContenido).collect(Collectors.toList()));
        }  
}
