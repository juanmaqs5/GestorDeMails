package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;

public class Contactos {
    public List<Usuario> Contactos = new ArrayList<>();

    public void agregarContactos(Usuario contact){
        Contactos.add(contact);
    }

    public List<Usuario> getPara(){
        return Contactos;
    }
}
