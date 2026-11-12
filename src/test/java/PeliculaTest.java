import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PeliculaTest {
    Pelicula pelicula=new Pelicula(1234,"fast and furious","accion","2:00",  ClasificacionPelicula.MAYORES_12);

    @Test
    void comprobarSiDatosSonCorrectos() {
        assertEquals(1234,pelicula.getCodigo());
        assertEquals("fast and furious",pelicula.getNombre());
        assertEquals("accion",pelicula.getGenero());
        assertEquals("2:00",pelicula.getDuracion());
        assertEquals(ClasificacionPelicula.MAYORES_12,pelicula.getClasificacionPelicula());
    }

    @Test
    void noPermitirCodigoNegativo(){
        assertThrows(IllegalArgumentException.class,()->{new Pelicula(-1234,"fast and furious","accion","2:00", ClasificacionPelicula.MAYORES_12);});
    }
}
