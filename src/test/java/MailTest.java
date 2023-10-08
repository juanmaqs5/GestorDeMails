import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.correo.ucp.Contact;
import com.correo.ucp.Mail;

public class MailTest {

    @Test
    public void createCorreo_Test(){
        Mail correo = new Mail();
        assertNotNull(correo);
    }

    @Test
    public void agregarContactosEnElPara_Test(){
        Contact destinatario = new Contact();
        Contact destinatario1 = new Contact();
        Mail correo = new Mail();
        correo.para.add(destinatario);
        correo.para.add(destinatario1);
        assertTrue(correo.getPara().contains(destinatario));
        assertTrue(correo.getPara().contains(destinatario1));
    }
}
