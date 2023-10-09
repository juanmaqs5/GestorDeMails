import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correo.ucp.Contact;
import com.correo.ucp.FiltroMailsRecibidos;
import com.correo.ucp.Mail;
import com.correo.ucp.MailBox;
import com.correo.ucp.MailManager;

public class FiltroMailsRecibidosTest {
    @Test
    public void filtrarMailsRecibidosUsuario_Test(){
        MailManager mailManager = new MailManager();
        MailBox buzon = new MailBox("gonza.mata2003@gmail.com");
        mailManager.listMailbox.add(buzon);
        List<Contact> para = new ArrayList<>();
        Contact remitente = new Contact("Alex", "Alex@gmail.com");
        Contact remitente1 = new Contact("Pedro", "Pedro@gmail.com");
        Contact destinatario = new Contact("Gonzalo","gonza.mata2003@gmail.com");
        para.add(destinatario);
        Mail correo = new Mail(null,null,remitente,null);
        correo.setPara(para);
        Mail correo1 = new Mail(null,null,remitente,null);
        correo1.setPara(para);
        Mail correo2 = new Mail(null,null,remitente,null);
        correo2.setRemitente(remitente1);
        correo2.setPara(para);
        mailManager.enviarCorreo(correo);
        mailManager.enviarCorreo(correo1);
        mailManager.enviarCorreo(correo2);
        FiltroMailsRecibidos filtroPara = new FiltroMailsRecibidos();
        filtroPara.filtarMailsRecibidos(buzon, "Pedro@gmail.com");
        assertEquals(filtroPara.listaMailsUsuario.size(),1);
        assertEquals(filtroPara.listaMailsUsuario.get(0), correo2);
    }
}
