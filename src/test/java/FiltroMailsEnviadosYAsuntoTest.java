import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correo.ucp.Contact;
import com.correo.ucp.FiltroMailsEnviadosYAsunto;
import com.correo.ucp.Mail;
import com.correo.ucp.MailBox;
import com.correo.ucp.MailManager;

public class FiltroMailsEnviadosYAsuntoTest {
    @Test 
    public void filtrarMailsAsunto_Test(){
        MailManager mailManager = new MailManager();
        MailBox buzon = new MailBox("Alex@gmail.com");
        mailManager.listMailbox.add(buzon);
        Contact contacto1 = new Contact("Alex", "Alex@gmail.com");
        Contact contacto2 = new Contact("Juan","Juan@gmail.com");
        Contact contacto3 = new Contact("Pedro", "Pedro@gmail.com");
        List<Contact> para = new ArrayList<>();
        List<Contact> para1 = new ArrayList<>();
        para.add(contacto2);
        para1.add(contacto3);
        Mail correo = new Mail("Saludo", "Hola Juan", contacto1 , para);
        Mail correo1 = new Mail("Plata", "Juan me debes plata", contacto1 , para);
        Mail correo2 = new Mail("Saludo", "Hola Pedro", contacto1 , para1);
        mailManager.enviarCorreo(correo);
        mailManager.enviarCorreo(correo1);
        mailManager.enviarCorreo(correo2);
        FiltroMailsEnviadosYAsunto filtro = new FiltroMailsEnviadosYAsunto();
        filtro.filtarMailsEnviadosAsunto(buzon, "Juan@gmail.com","Saludo");
        assertEquals(filtro.listaMailsUsuarioYAsunto.size(), 1);
        assertEquals(filtro.listaMailsUsuarioYAsunto.get(0), correo);
    }
}
