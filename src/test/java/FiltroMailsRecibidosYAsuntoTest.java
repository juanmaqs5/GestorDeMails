import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correo.ucp.Contact;
import com.correo.ucp.FiltroMailsRecibidosYAsunto;
import com.correo.ucp.Mail;
import com.correo.ucp.MailBox;
import com.correo.ucp.MailManager;

public class FiltroMailsRecibidosYAsuntoTest{
    @Test 
    public void filtrarMailsAsunto(){
        MailManager mailManager = new MailManager();
        MailBox buzon = new MailBox("Alex@gmail.com");
        mailManager.listMailbox.add(buzon);
        Contact contacto1 = new Contact("Alex", "Alex@gmail.com");
        Contact contacto2 = new Contact("UCP","ucp@gmail.com");
        Contact contacto3 = new Contact("Pedro", "Pedro@gmail.com");
        List<Contact> para = new ArrayList<>();
        para.add(contacto1);
        Mail correo = new Mail("Saludo", "Hol Alex", contacto3 , para);
        Mail correo1 = new Mail("Cuota", "Debe una cuota", contacto2 , para);
        Mail correo2 = new Mail("Saludo", "Hola Alex", contacto2 , para);
        mailManager.enviarCorreo(correo);
        mailManager.enviarCorreo(correo1);
        mailManager.enviarCorreo(correo2);
        FiltroMailsRecibidosYAsunto filtro = new FiltroMailsRecibidosYAsunto();
        filtro.filtarMailsRecibidosAsunto(buzon, "ucp@gmail.com","Saludo" );
        assertEquals(filtro.listaMailsUsuarioYAsunto.size(), 1);
        assertEquals(filtro.listaMailsUsuarioYAsunto.get(0), correo2);
    }
}
