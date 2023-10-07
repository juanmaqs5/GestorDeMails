package com.correo.ucp;

import java.util.ArrayList;
import java.util.List;

public class MailBox{
    public String mail;
    public List<Mail> bandejaDeEntrada;
    public List<Mail> bandejaDeEnviado;

    public MailBox(){
        this.bandejaDeEntrada = new ArrayList<>();
        this.bandejaDeEnviado = new ArrayList<>();
    }

    public MailBox(String mail){
        this.mail = mail;
        this.bandejaDeEntrada = new ArrayList<>();
        this.bandejaDeEnviado = new ArrayList<>();
    }

    public String getMail(){
        return mail;
    }

    public List<Mail> getBandejaDeEnviado(){
        return bandejaDeEnviado;
    }

    public List<Mail> getBandejaDeEntrada(){
        return bandejaDeEntrada;
    }
}
