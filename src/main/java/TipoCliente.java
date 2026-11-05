public enum TipoCliente {
    GENERAL(1),
    ESTUDIANTE(0.80),
    NIÑO(0.66),
    ADULTO_MAYOR(0.72);

    private final double descuento;

    TipoCliente(double valorEntrada) {
        this.descuento = valorEntrada;
    }

    public double getDescuento() {
        return descuento;
    }
}