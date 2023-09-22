import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correo.ucp.Contacto;
import com.correo.ucp.Correo;

public class CorreoTest {

    @Test
    public void createCorreo_Test(){
        List<Contacto> Para = new ArrayList<>();
        Contacto remitente = new Contacto("GonzaMata", "gonzamata@gmail.com");
        Correo correo = new Correo("Ucp","Aporbe el examen", remitente, Para);
        assertNotNull(correo);
    }

    @Test
    public void agregarContactosEnElPara_Test(){
        List<Contacto> Para = new ArrayList<>();
        Contacto remitente = new Contacto("GonzaMata", "gonzamata@gmail.com");
        Contacto destinatario = new Contacto("Aquinopla", "Aquinopla88@gmail.com");
        Contacto destinatario1 = new Contacto("Aquinopla", "Aquinopla88@gmail.com");
        Correo correo = new Correo("Ucp","aprobe el examen", remitente, Para);
        correo.agregarContactos(destinatario);
        correo.agregarContactos(destinatario1);
        assertTrue(correo.getPara().contains(destinatario));
        assertTrue(correo.getPara().contains(destinatario1));
    }

    @Test
    public void enviarCorreo_Test(){
        List<Contacto> Para = new ArrayList<>();
        Contacto remitente = new Contacto("GonzaMata", "gonzamata@gmail.com");
        Contacto destinatario = new Contacto("Aquinopla", "Aquinopla88@gmail.com");
        Contacto destinatario1 = new Contacto("Aquinopla", "Aquinopla88@gmail.com");
        Correo correo = new Correo("Ucp","Aporbe el examen", remitente, Para);
        correo.agregarContactos(destinatario);
        correo.agregarContactos(destinatario1);
        correo.enviar(correo);
        assertTrue(remitente.getBandejaDeEnviado().contains(correo));
        assertTrue(destinatario.getBandejaDeEntrada().contains(correo));
        assertTrue(destinatario1.getBandejaDeEntrada().contains(correo));
    }
}
