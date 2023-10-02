import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correo.ucp.Usuario;
import com.correo.ucp.Contactos;
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
        Usuario destinatario = new Usuario();
        Usuario destinatario1 = new Usuario();
        Mail correo = new Mail();
        correo.Para.agregarContactos(destinatario);
        correo.Para.agregarContactos(destinatario1);
        assertTrue(correo.Para.getPara().contains(destinatario));
        assertTrue(correo.Para.getPara().contains(destinatario1));
    }

    @Test
    public void enviarCorreo_Test(){
        MailManager MailManager = new MailManager();
        Usuario destinatario = new Usuario();
        Usuario destinatario1 = new Usuario();
        Mail correo = new Mail();
        correo.Para.agregarContactos(destinatario);
        correo.Para.agregarContactos(destinatario1);
        MailManager.enviar(correo);
        assertTrue(correo.Remitente.getBandejaDeEnviado().contains(correo));
        assertTrue(destinatario.getBandejaDeEntrada().contains(correo));
        assertTrue(destinatario1.getBandejaDeEntrada().contains(correo));
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
