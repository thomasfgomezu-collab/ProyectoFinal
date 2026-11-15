public class Asiento {
    private int codigo;
    private String fila;
    private String numero;
    private EstadoAsiento estadoAsiento;

    public Asiento(int codigo, String fila, String numero, EstadoAsiento estadoAsiento) {
        this.codigo = codigo;
        this.fila = fila;
        this.numero = numero;
        this.estadoAsiento = estadoAsiento;
    }
    public String getEtiqueta() {
        return this.fila + this.numero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public EstadoAsiento getEstadoAsiento() {
        return estadoAsiento;
    }

    public void setEstadoAsiento(EstadoAsiento estadoAsiento) {
        this.estadoAsiento = estadoAsiento;
    }

    @Override
    public String toString() {
        return "Asientos: " +
                "codigo= " + codigo +
                ", fila= " + fila + '\'' +
                ", numero= " + numero + '\'' +
                ", estadoAsiento= " + estadoAsiento;
    }
}
