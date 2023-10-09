import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.correo.ucp.Contact;

public class ContactTest{
    @Test
    public void createContacto_Test(){
        Contact contacto = new Contact("Gonzalo", "gonza.mata2003@gmail.com");
        assertNotNull(contacto);
        assertEquals(contacto.getNombre(),"Gonzalo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void excepcionMailEsNulo_Test() {
        new Contact("nombre", null);
    }
}
