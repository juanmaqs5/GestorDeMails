import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correo.ucp.Contact;
import com.correo.ucp.FiltroContenido;
import com.correo.ucp.Mail;
import com.correo.ucp.MailBox;
import com.correo.ucp.MailManager;

public class FiltroMailsContenidoTest {
    @Test 
    public void filtrarMailsAsunto(){
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
        Mail correo = new Mail("Saludo", "Hola Pedro", contacto1 , para);
        Mail correo1 = new Mail("Cuota", "Hola Alex, tiene atrasada una cuota", contacto2 , para1);
        mailManager.enviarCorreo(correo);
        mailManager.enviarCorreo(correo1);
        FiltroContenido filtroContenido = new FiltroContenido();
        filtroContenido.filtrarMailsContenido(buzon, "Hola");
        assertEquals(filtroContenido.listMailsContenido.size(), 2);
        assertEquals(filtroContenido.listMailsContenido.get(0), correo1);
        assertEquals(filtroContenido.listMailsContenido.get(1), correo);
    }
}