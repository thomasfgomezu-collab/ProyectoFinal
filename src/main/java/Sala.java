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

    public void generarAsientos(int filas, int columnas) {
        if (filas <= 0 || filas > 26 || columnas <= 0) {
            throw new IllegalArgumentException("Dimensiones inválidas: las filas deben estar entre 1 y 26, y las columnas deben ser mayores a 0.");
        }

        if (this.ListaAsiento == null) {
            this.ListaAsiento = new ArrayList<>();
        } else {
            this.ListaAsiento.clear();
        }

        int codigoAsiento = 1;

        for (int f = 1; f <= filas; f++) {
            String letraFila = String.valueOf((char) ('A' + f - 1));

            for (int c = 1; c <= columnas; c++) {
                Asiento nuevo = new Asiento(
                        codigoAsiento++,
                        letraFila,
                        String.valueOf(c),
                        EstadoAsiento.DISPONIBLE
                );
                this.ListaAsiento.add(nuevo);
            }
        }

        this.capacidad = filas * columnas;
    }
    public void mostrarMinimapa() {
        String filaActual = "";
        System.out.println("\n--- PANTALLA ---");

        for (Asiento a : this.ListaAsiento) {
            if (!a.getFila().equals(filaActual)) {
                filaActual = a.getFila();
                System.out.print("\nFila " + filaActual + ": ");
            }

            if (a.getEstadoAsiento() == EstadoAsiento.DISPONIBLE) {
                System.out.print("[" + a.getFila() + a.getNumero() + "] ");
            } else {
                System.out.print("[X] ");
            }
        }
        System.out.println("\n");
    }
    public Asiento buscarAsiento(String fila, String numero) {
        for (Asiento a : ListaAsiento) {
            if (a.getFila().equalsIgnoreCase(fila) && a.getNumero().equalsIgnoreCase(numero)) {
                return a;
            }
        }
        return null;
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
