public enum TipoCliente {
    GENEREAL(15000),
    ESTUDIANTE(12000),
    NIÑO(10000),
    ADULTO_MAYOR(11000);

    private int valorEntrada;

    TipoCliente(int valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public int getValorEntrada() {
        return valorEntrada;
    }
}

