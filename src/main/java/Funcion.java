import java.time.LocalDate;
import java.time.LocalDateTime;

public class Funcion {
    private int codigo;
    private Pelicula pelicula;
    private Sala sala;
    private LocalDate fecha;
    private String hora;
    private double valorBase;
    private EstadoFuncion estadoFuncion;

    public Funcion(int codigo, Pelicula pelicula, Sala sala, LocalDate fecha, String hora, double valorBase, EstadoFuncion estadoFuncion) {
        this.codigo = codigo;
        this.pelicula = pelicula;
        this.fecha = fecha;
        this.hora = hora;
        this.valorBase = valorBase;
        this.estadoFuncion = estadoFuncion;

        if (sala != null) {
            Sala copiaSala = new Sala(sala.getCodigo(), sala.getNombre(), sala.getCapacidad(), sala.getEstadoSala());
            for (Asiento a : sala.getListaAsiento()) {
                copiaSala.getListaAsiento().add(
                        new Asiento(a.getCodigo(), a.getFila(), a.getNumero(), a.getEstadoAsiento())
                );
            }
            this.sala = copiaSala;
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public EstadoFuncion getEstadoFuncion() {
        return estadoFuncion;
    }

    public void setEstadoFuncion(EstadoFuncion estadoFuncion) {
        this.estadoFuncion = estadoFuncion;
    }

    @Override
    public String toString() {
        return "Funcion: " +
                " codigo " + codigo +
                ", pelicula " + pelicula +
                ", sala " + sala +
                ", fecha " + fecha +
                ", hora " + hora + '\'' +
                ", valorBase " + valorBase +
                ", estadoFuncion " + estadoFuncion ;
    }
}
