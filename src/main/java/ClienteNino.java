public class ClienteNino extends Cliente{
   public ClienteNino(int identificacion, String nombre){
       super(identificacion, nombre, TipoCliente.NIÑO);
   }

    @Override
    public double calcularPrecioEntrada(double valorBaseFuncion) {
        return valorBaseFuncion*getTipoCliente().getDescuento();
    }
}
