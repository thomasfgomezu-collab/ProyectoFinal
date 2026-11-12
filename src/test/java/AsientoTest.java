import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AsientoTest {
    Asiento asiento=new Asiento(1234,"a","2", EstadoAsiento.DISPONIBLE);

    @Test
    void comrpobarSiDatosSonCorrectos() {
        assertEquals(1234,asiento.getCodigo());
        assertEquals("a",asiento.getFila());
        assertEquals("2",asiento.getNumero());
        assertEquals(EstadoAsiento.DISPONIBLE,asiento.getEstadoAsiento());
    }

    @Test
    void noPermitirCodigoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Asiento(1234,"a","2", EstadoAsiento.DISPONIBLE);
        });
    }
}
