public interface ICliente {

    static double descuentoGeneral=0;
    static double descuentoEstudiante=0.10;
    static double descuentoNiños=0.20;
    static double descuentoAdultoMayor=0.15;

    double calcularDescuento(double valor);
    }
