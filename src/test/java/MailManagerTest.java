import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correo.ucp.Contacto;
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
        Contacto remitente = new Contacto("Gonzalo", "gonza.mata2003@gmail.com");
        assertEquals(mailManager.comprobarBuzonContactos(remitente), false);
    }

    @Test
    public void comprobarBuzonContactoTrue_Test(){
        MailManager mailManager = new MailManager();
        MailBox buzon = new MailBox("pedro@gmail.com");
        mailManager.listMailbox.add(buzon);
        Contacto destinatario = new Contacto("Gonzalo", "pedro@gmail.com");
        assertEquals(mailManager.comprobarBuzonContactos(destinatario), true);
    }

    @Test
    public void crearBuzon_Test(){
        MailManager mailManager = new MailManager();
        List<Contacto> para = new ArrayList<>();
        Contacto remitente = new Contacto("Alex", "Alex@gmail.com");
        Contacto destinatario = new Contacto("Gonzalo","pedro@gmail.com");
        Contacto destinatario1 = new Contacto("Gonzalo","gonza.mata2003@gmail.com");
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
        List<Contacto> para = new ArrayList<>();
        Contacto remitente = new Contacto("Alex", "Alex@gmail.com");
        Contacto destinatario = new Contacto("Gonzalo","gonza.mata2003@gmail.com");
        Contacto destinatario1 = new Contacto("Gonzalo","gonza.mata2003@gmail.com");
        Contacto destinatario2 = new Contacto("Gonzalo","gonza.mata2003@gmail.com");
        para.add(destinatario);
        para.add(destinatario1);
        para.add(destinatario2);
        Mail correo = new Mail("Hola", "hola", remitente , para);
        mailManager.crearBuzon(correo);
        assertEquals(mailManager.listMailbox.size(),2);
    }
}
