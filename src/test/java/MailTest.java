import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correo.ucp.Contact;
import com.correo.ucp.Mail;

public class MailTest {

    @Test
    public void createCorreo_Test(){
        Contact remitente = new Contact(null,"gonza@gmail.com");
        Mail correo = new Mail(null,null,remitente,null);
        correo.setAsunto("Saludo");
        correo.setContenido("Hola");
        assertNotNull(correo);
        assertEquals(correo.getAsunto(),"Saludo");
        assertEquals(correo.getContenido(),"Hola");
    }

    @Test(expected = IllegalArgumentException.class)
    public void excepcionRemitenteEsNulo_Test() {
        new Mail("Asunto", "Contenido", null, new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void excepcionsetRemitenteEsNulo_Test() {
        Contact remitente = new Contact(null,"gonza@gmail.com");
        Mail correo = new Mail("Asunto", "Contenido", remitente, new ArrayList<>());
        correo.setRemitente(null);
    }

    @Test
    public void agregarContactosEnElPara_Test(){
        Contact remitente = new Contact(null,"gonza@gmail.com");
        List<Contact> para = new ArrayList<>();
        Contact destinatario = new Contact(null,"paulo@gmail.com");
        Contact destinatario1 = new Contact(null,"juan@gmail.com");
        Mail correo = new Mail(null,null,remitente,para);
        correo.para.add(destinatario);
        correo.para.add(destinatario1);
        assertTrue(correo.getPara().contains(destinatario));
        assertTrue(correo.getPara().contains(destinatario1));
    }
}
