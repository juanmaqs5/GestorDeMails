import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correo.ucp.Contact;
import com.correo.ucp.Mail;
import com.correo.ucp.MailBox;
import com.correo.ucp.MailManager;

public class MailManagerTest {

    @Test
    public void createMailManager_Test(){
        MailManager mailManager = new MailManager();
        assertNotNull(mailManager);
    }

    @Test
    public void comprobarBuzonContactoFalse_Test(){
        MailManager mailManager = new MailManager();
        MailBox buzon = new MailBox("pedro@gmail.com");
        mailManager.listMailbox.add(buzon);
        Contact remitente = new Contact("Gonzalo", "gonza.mata2003@gmail.com");
        assertEquals(mailManager.comprobarBuzonContactos(remitente), false);
    }

    @Test
    public void comprobarBuzonContactoTrue_Test(){
        MailManager mailManager = new MailManager();
        MailBox buzon = new MailBox("pedro@gmail.com");
        mailManager.listMailbox.add(buzon);
        Contact destinatario = new Contact("Gonzalo", "pedro@gmail.com");
        assertEquals(mailManager.comprobarBuzonContactos(destinatario), true);
    }

    @Test
    public void crearBuzon_Test(){
        MailManager mailManager = new MailManager();
        List<Contact> para = new ArrayList<>();
        Contact remitente = new Contact("Alex", "Alex@gmail.com");
        Contact destinatario = new Contact("Gonzalo","pedro@gmail.com");
        Contact destinatario1 = new Contact("Gonzalo","gonza.mata2003@gmail.com");
        para.add(destinatario);
        para.add(destinatario1);
        Mail correo = new Mail("Hola", "hola", remitente , para);
        mailManager.crearBuzon(correo);
        assertTrue(mailManager.listMailbox.get(0).getMail().contains("Alex@gmail.com"));
        assertTrue(mailManager.listMailbox.get(1).getMail().contains("pedro@gmail.com"));
        assertTrue(mailManager.listMailbox.get(2).getMail().contains("gonza.mata2003@gmail.com"));
    }

    @Test
    public void comprobarQueNoRepiteBuzones_Test(){
        MailManager mailManager = new MailManager();
        List<Contact> para = new ArrayList<>();
        Contact remitente = new Contact("Alex", "Alex@gmail.com");
        Contact destinatario = new Contact("Gonzalo","gonza.mata2003@gmail.com");
        Contact destinatario1 = new Contact("Gonzalo","gonza.mata2003@gmail.com");
        Contact destinatario2 = new Contact("Gonzalo","gonza.mata2003@gmail.com");
        para.add(destinatario);
        para.add(destinatario1);
        para.add(destinatario2);
        Mail correo = new Mail("Hola", "hola", remitente , para);
        mailManager.crearBuzon(correo);
        assertEquals(mailManager.listMailbox.size(),2);
    }

    @Test
    public void agregarCorreoBandejaDeEnviados_Test(){
        MailManager mailManager = new MailManager();
        MailBox buzonRemitente = new MailBox("Alex@gmail.com");
        mailManager.listMailbox.add(buzonRemitente);
        List<Contact> para = new ArrayList<>();
        Contact remitente = new Contact("Alex", "Alex@gmail.com");
        Contact destinatario = new Contact("Gonzalo","gonza.mata2003@gmail.com");
        para.add(destinatario);
        Mail correo = new Mail("Hola", "hola", remitente , para);
        mailManager.agregarCorreoBandejaDeEnviados(correo);
        assertTrue(buzonRemitente.bandejaDeEnviado.contains(correo)); 
    }

    @Test
    public void agregarCorreoBandejaDeEntrada_Test(){
        MailManager mailManager = new MailManager();
        MailBox buzonDestinatario = new MailBox("Alex@gmail.com");
        MailBox buzonDestinatario1 = new MailBox("Pedro@gmail.com");
        mailManager.listMailbox.add(buzonDestinatario);
        mailManager.listMailbox.add(buzonDestinatario1);
        List<Contact> para = new ArrayList<>();
        Contact remitente = new Contact();
        Contact destinatario = new Contact("Alex","Alex@gmail.com");
        para.add(destinatario);
        Mail correo = new Mail("Hola", "hola", remitente , para);
        mailManager.agregarCorreoBandejaDeEntrada(correo);
        assertTrue(buzonDestinatario.bandejaDeEntrada.contains(correo)); 
        assertFalse(buzonDestinatario1.bandejaDeEntrada.contains(correo));
    }

    @Test
    public void enviarCorreo(){
        MailManager mailManager = new MailManager();
        Contact contacto1 = new Contact("Alex", "Alex@gmail.com");
        Contact contacto2 = new Contact("Juan","Juan@gmail.com");
        List<Contact> para = new ArrayList<>();
        para.add(contacto2);
        Mail correo = new Mail();
        correo.setRemitente(contacto1);
        correo.setPara(para);
        mailManager.enviarCorreo(correo);
        assertEquals(mailManager.listMailbox.get(0).mail,"Alex@gmail.com");
        assertEquals(mailManager.listMailbox.get(0).bandejaDeEnviado.get(0),correo);
        assertEquals(mailManager.listMailbox.get(1).mail,"Juan@gmail.com");
        assertEquals(mailManager.listMailbox.get(1).bandejaDeEntrada.get(0),correo);
    }
}