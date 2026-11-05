public class ClienteEstudiante extends Cliente {

    public ClienteEstudiante(int identificacion, String nombre, TipoCliente tipoCliente) {
        super(identificacion, nombre, tipoCliente);
    }

    @Override
    public double calcularPrecioEntrada(double valorBaseFuncion) {

        return valorBaseFuncion*getTipoCliente().getDescuento();
    }
}
