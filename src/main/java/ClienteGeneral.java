public class ClienteGeneral extends Cliente {

    public ClienteGeneral(int identificacion, String nombre) {
        super(identificacion, nombre, TipoCliente.GENERAL);
    }

    @Override
    public double calcularPrecioEntrada(double valorBaseFuncion) {
        return valorBaseFuncion * getTipoCliente().getDescuento();
    }
}
