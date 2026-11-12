import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClienteTest {

    Cliente Cliente=new Cliente(1234,"Juan",TipoCliente.GENERAL);

    @Test
    void comprobarSiDatosSonCorrectos() {
        assertEquals(1234,Cliente.getIdentificacion());
        assertEquals("Juan",Cliente.getNombre());
        assertEquals(TipoCliente.GENERAL,Cliente.getTipoCliente());
    }

    @Test
    void noPermitirDocumentoNegativo(){
        assertThrows(IllegalArgumentException.class,()->{new Cliente(-1234,"Juan",TipoCliente.GENERAL);});
    }

}
