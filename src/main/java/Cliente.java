public abstract class Cliente implements ICalculadorTarifa {
    private int identificacion;
    private String nombre;
    private TipoCliente tipoCliente;

    public Cliente(int identificacion, String nombre, TipoCliente tipoCliente) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
    }

    protected Cliente() {
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "Cliente: " +
                " identificacion " + identificacion +
                ", nombre= " + nombre + '\'' +
                ", tipoCliente " + tipoCliente ;
    }
}