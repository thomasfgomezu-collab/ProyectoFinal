import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FuncionTest {
    Funcion funcion = new Funcion(123, null, null, null, "1:30", 2000, EstadoFuncion.PROGRAMADA);

    @Test
    void comprobarSiDatosSonCorrectos() {
        assertEquals(123,funcion.getCodigo());
        assertEquals(2000,funcion.getValorBase());
    }

    @Test
    void noPermitirCodigoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Funcion(-123, null, null, null, "1:30", 2000, EstadoFuncion.PROGRAMADA);
        });
    }

    @Test
    void noPermitirValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Funcion(123, null, null, null, "1:30", -2000, EstadoFuncion.PROGRAMADA);
        });
    }

}
