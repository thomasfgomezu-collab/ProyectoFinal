import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClienteEstudianteTest {

    ClienteAdultoMayor Cliente=new ClienteAdultoMayor(1234,"Juan");

    @Test
    void comprobarSiDatosSonCorrectos() {
        assertEquals(1234,Cliente.getIdentificacion());
        assertEquals("Juan",Cliente.getNombre());
    }

    @Test
    void noPermitirDocumentoNegativo(){
        assertThrows(IllegalArgumentException.class,()->{new ClienteAdultoMayor(-1234,"Juan");});
    }

}
