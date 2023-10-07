import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.correo.ucp.Contacto;
import com.correo.ucp.Mail;

public class MailTest {

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
}
