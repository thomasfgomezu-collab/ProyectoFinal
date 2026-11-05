public class ClienteAdultoMayor extends Cliente{
    public ClienteAdultoMayor(int identificacion, String nombre){
        super(identificacion, nombre, TipoCliente.ADULTO_MAYOR);
    }

    @Override
    public double calcularPrecioEntrada(double valorBaseFuncion) {
        return valorBaseFuncion*getTipoCliente().getDescuento();
    }
}
