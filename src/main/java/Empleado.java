import java.util.ArrayList;
import java.util.List;

public class Empleado extends Persona {
    private double salario;

    private List<Venta> ListaVenta;

    public Empleado(int identificacion, String nombre, String correo, String telefono, double salario) {
        super(identificacion, nombre, correo, telefono);
        this.salario = salario;

        this.ListaVenta=new ArrayList<>();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<Venta> getListaVenta() {
        return ListaVenta;
    }

    public void setListaVenta(List<Venta> listaVenta) {
        ListaVenta = listaVenta;
    }

    @Override
    public String toString() {
        return "Empleado: "+super.toString()+
                ", Salario: "+salario;
    }
}
