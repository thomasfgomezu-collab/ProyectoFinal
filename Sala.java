import java.util.ArrayList;
import java.util.List;

public class Sala {
    private int codigo;
    private String nombre;
    private int capacidad;
    private EstadoSala estadoSala;

    private List<Asiento> ListaAsiento;

    public Sala(int codigo, String nombre, int capacidad, EstadoSala estadoSala ) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estadoSala = estadoSala;
        ListaAsiento = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public EstadoSala getEstadoSala() {
        return estadoSala;
    }

    public void setEstadoSala(EstadoSala estadoSala) {
        this.estadoSala = estadoSala;
    }

    public List<Asiento> getListaAsiento() {
        return ListaAsiento;
    }

    public void setListaAsiento(List<Asiento> listaAsiento) {
        ListaAsiento = listaAsiento;
    }

    @Override
    public String toString() {
        return "Sala: " +
                "codigo= " + codigo +
                ", nombre= " + nombre + '\'' +
                ", capacidad= " + capacidad +
                ", estadoSala= " + estadoSala +
                ", ListaAsientos= " + ListaAsiento ;
    }
}
