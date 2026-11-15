import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona implements ICliente{

    private TipoCliente tipoCliente;

    private List<Venta> ListaVenta;

    public Cliente(int identificacion, String nombre, String correo, String telefono, TipoCliente tipoCliente) {
        super(identificacion, nombre, correo, telefono);
        this.tipoCliente = tipoCliente;

        this.ListaVenta=new ArrayList<>();
    }

    @Override
    public double calcularDescuento(double valor) {
        double descuento = switch (this.tipoCliente) {
            case GENERAL -> descuentoGeneral;
            case ESTUDIANTE -> descuentoEstudiante;
            case NIÑO -> descuentoNiños;
            case ADULTO_MAYOR -> descuentoAdultoMayor;
        };

        return valor - (valor * descuento);
    }


    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public List<Venta> getListaVenta() {
        return ListaVenta;
    }

    public void setListaVenta(List<Venta> listaVenta) {
        ListaVenta = listaVenta;
    }

    @Override
    public String toString() {
        return "Cliente: "+super.toString()+
                ", Tipo de cliente: "+tipoCliente;
    }
}