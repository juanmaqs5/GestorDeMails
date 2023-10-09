import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correo.ucp.Contact;
import com.correo.ucp.FiltroMailsRecibidosYContenido;
import com.correo.ucp.Mail;
import com.correo.ucp.MailBox;
import com.correo.ucp.MailManager;

public class FiltroMailsRecibidosYContenidoTest {
    @Test
    public void filtrarMailsRecibidosYContenido_Test(){
        MailManager mailManager = new MailManager();
        MailBox buzon = new MailBox("Alex@gmail.com");
        mailManager.listMailbox.add(buzon);
        Contact contacto1 = new Contact("Alex", "Alex@gmail.com");
        Contact contacto2 = new Contact("Juan","Juan@gmail.com");
        Contact contacto3 = new Contact("Pedro", "Pedro@gmail.com");
        List<Contact> para = new ArrayList<>();
        para.add(contacto1);
        Mail correo = new Mail(null,null,contacto2,null);
        correo.setAsunto("Saludo");
        correo.setContenido("Hola Alex");
        correo.setPara(para);
        Mail correo1 = new Mail(null,null,contacto2,null);
        correo1.setAsunto("Plata");
        correo1.setContenido("Alex me debes plata");
        correo1.setPara(para);
        Mail correo2 = new Mail(null,null,contacto3,null);
        correo2.setAsunto("Saludo");
        correo2.setContenido("Hola Alex");
        correo2.setPara(para);
        mailManager.enviarCorreo(correo);
        mailManager.enviarCorreo(correo1);
        mailManager.enviarCorreo(correo2);
        FiltroMailsRecibidosYContenido filtro = new FiltroMailsRecibidosYContenido();
        filtro.filtarMailsRecibidosContenido(buzon, "Juan@gmail.com","Alex");
        assertEquals(filtro.listaMailsUsuarioYContenido.size(), 2);
        assertEquals(filtro.listaMailsUsuarioYContenido.get(0), correo);
        assertEquals(filtro.listaMailsUsuarioYContenido.get(1), correo1);
    }
}
