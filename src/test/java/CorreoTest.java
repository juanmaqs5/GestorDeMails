import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correo.ucp.MailBox;
import com.correo.ucp.Contacto;
import com.correo.ucp.Mail;
import com.correo.ucp.MailManager;

public class CorreoTest {

    @Test
    public void createCorreo_Test(){
        Mail correo = new Mail();
        assertNotNull(correo);
    }

    @Test
    public void agregarContactosEnElPara_Test(){
        Contacto destinatario = new Contacto();
        Contacto destinatario1 = new Contacto();
        Mail correo = new Mail();
        correo.para.add(destinatario);
        correo.para.add(destinatario1);
        assertTrue(correo.getPara().contains(destinatario));
        assertTrue(correo.getPara().contains(destinatario1));
    }

    @Test
    public void enviarCorreo_Test(){
        MailManager mailManager = new MailManager();
        Contacto destinatario = new Contacto("Gonzalo","gonza.mata2003@gmail.com");
        Contacto destinatario1 = new Contacto("Gonzalo","gonza.mata2003@gmail.com");
        Mail correo = new Mail();
        correo.para.add(destinatario);
        correo.para.add(destinatario1);
        mailManager.enviar(correo);
        for (MailBox buzon : mailManager.mailbox){
            assertTrue(buzon.getMail().contains("gonza.mata2003@gmail.com"));
        }
    }

    @Test
    public void FiltrarCorreo_Test(){
        MailManager MailManager = new MailManager();
        Contactos Para = new Contactos();
        Usuario remitente1 = new Usuario("Gonzalo", "gonza.mata2003@gmail.com");
        Usuario remitente2 = new Usuario("Aquinopla", "Aquinopla@gmail.com");
        Usuario destinatario = new Usuario();
        Mail correo1 = new Mail("Saludo", "Hola",remitente1 , Para);
        Mail correo2 = new Mail("Saludo", "Hola",remitente2 , Para);
        Para.agregarContactos(destinatario);
        MailManager.enviar(correo1);
        MailManager.enviar(correo1);
        MailManager.enviar(correo2);
        List<Mail> ListaPrueba = new ArrayList<>();
        ListaPrueba.add(correo2);
        assertEquals(MailManager.buscarUsuario(remitente2, destinatario), ListaPrueba);
    }
}
