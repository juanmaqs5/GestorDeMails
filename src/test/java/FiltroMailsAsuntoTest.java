import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correo.ucp.Contact;
import com.correo.ucp.FiltroAsunto;
import com.correo.ucp.Mail;
import com.correo.ucp.MailBox;
import com.correo.ucp.MailManager;

public class FiltroMailsAsuntoTest {
    @Test 
    public void filtrarMailsAsunto_Test(){
        MailManager mailManager = new MailManager();
        MailBox buzon = new MailBox("Alex@gmail.com");
        mailManager.listMailbox.add(buzon);
        Contact contacto1 = new Contact("Alex", "Alex@gmail.com");
        Contact contacto2 = new Contact("UCP","ucp@gmail.com");
        Contact contacto3 = new Contact("Pedro", "Pedro@gmail.com");
        List<Contact> para = new ArrayList<>();
        List<Contact> para1 = new ArrayList<>();
        para.add(contacto3);
        para1.add(contacto1);
        Mail correo = new Mail("Saludo", "Hol Pedro", contacto1 , para);
        Mail correo1 = new Mail("Universidad", "cuota", contacto2 , para1);
        mailManager.enviarCorreo(correo);
        mailManager.enviarCorreo(correo1);
        FiltroAsunto filtroAsunto = new FiltroAsunto();
        filtroAsunto.filtrarMailsAsunto(buzon, "Universidad");
        assertEquals(filtroAsunto.listaMailsAsunto.size(), 1);
        assertEquals(filtroAsunto.listaMailsAsunto.get(0), correo1);
    }
}
