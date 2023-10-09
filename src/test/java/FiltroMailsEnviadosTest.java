import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correo.ucp.Contact;
import com.correo.ucp.FiltroMailsEnviados;
import com.correo.ucp.Mail;
import com.correo.ucp.MailBox;
import com.correo.ucp.MailManager;

public class FiltroMailsEnviadosTest {
    @Test
    public void filtrarMailsEnviadosUsuario_Test(){
        MailManager mailManager = new MailManager();
        MailBox buzon = new MailBox("Alex@gmail.com");
        mailManager.listMailbox.add(buzon);
        List<Contact> para = new ArrayList<>();
        List<Contact> para1 = new ArrayList<>();
        Contact remitente = new Contact("Alex", "Alex@gmail.com");
        Contact destinatario = new Contact("Pedro", "Pedro@gmail.com");
        Contact destinatario2 = new Contact("Gonzalo","gonza.mata2003@gmail.com");
        para.add(destinatario);
        para1.add(destinatario2);
        Mail correo = new Mail("Saludo", "Hola Pedro", remitente , para);
        Mail correo1 = new Mail("Saludo", "Hola Pedro", remitente , para);
        Mail correo2 = new Mail("Saludo", "Hola Gonzalo", remitente , para1);
        mailManager.enviarCorreo(correo);
        mailManager.enviarCorreo(correo1);
        mailManager.enviarCorreo(correo2);
        FiltroMailsEnviados filtroPara = new FiltroMailsEnviados();
        filtroPara.filtrarMailsEnviados(buzon, "Pedro@gmail.com");
        assertEquals(filtroPara.listaMailsUsuario.size(),2);
        assertEquals(filtroPara.listaMailsUsuario.get(0), correo);
        assertEquals(filtroPara.listaMailsUsuario.get(1), correo1);
    }
}
