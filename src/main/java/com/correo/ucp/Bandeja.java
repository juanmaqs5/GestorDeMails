package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;

public class Bandeja {
    public List<Mail> BandejaDeEntrada = new ArrayList<>();
    public List<Mail> BandejaDeEnviado = new ArrayList<>();

    public List<Mail> getBandejaDeEnviado(){
        return BandejaDeEnviado;
    }

    public List<Mail> getBandejaDeEntrada(){
        return BandejaDeEntrada;
    }
}
