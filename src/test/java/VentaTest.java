import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class VentaTest {
    Venta venta=new Venta(1234,null,null,null);

    @Test
    void noPermitirCodigoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Venta(1234,null,null,null);
        });
    }

}
