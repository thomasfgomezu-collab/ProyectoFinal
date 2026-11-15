import java.time.LocalDateTime;

public class Venta {
    private int codigo;
    private Cliente cliente;
    private Funcion funcion;
    private Asiento asiento;
    private LocalDateTime fechaYHora;
    private double valorPagado;
    private EstadoVenta estadoVenta;

    public Venta(int codigo, Cliente cliente, Funcion funcion, Asiento asiento) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.funcion = funcion;
        this.asiento = asiento;
        this.fechaYHora = LocalDateTime.now();
        this.estadoVenta = EstadoVenta.ACTIVA;
        this.valorPagado = cliente.calcularDescuento(funcion.getValorBase());
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public double getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
    }

    public EstadoVenta getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(EstadoVenta estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    @Override
    public String toString() {
        return "Venta: " +
                "codigo " + codigo +
                ", cliente " + cliente +
                ", funcion " + funcion +
                ", asiento " + asiento +
                ", fechaYHora " + fechaYHora +
                ", valorPagado " + valorPagado +
                ", estadoVenta " + estadoVenta ;
    }
    public void cancelarVenta() {
        this.estadoVenta = EstadoVenta.CANCELADA;
        this.asiento.setEstadoAsiento(EstadoAsiento.DISPONIBLE);
    }
}
