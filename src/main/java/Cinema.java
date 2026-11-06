import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cinema {
    private String nombre;
    private int nit;
    private String direccion;

    private List<Sala> ListaSala;
    private  List<Pelicula> ListaPelicula;
    private List<Cliente> ListaCliente;
    private List<Venta> ListaVenta;
    private List<Funcion> ListaFunciones;

    public Cinema(String nombre, int nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        ListaSala = new ArrayList<>();
        ListaPelicula = new ArrayList<>();
        ListaCliente = new ArrayList<>();
        ListaVenta = new ArrayList<>();
        ListaFunciones = new ArrayList<>();
    }

    public Pelicula buscarPeliculaPorCodigo(int codigo) {
        for (Pelicula p : ListaPelicula) {
            if (p.getCodigo() == codigo) return p;
        }
        return null;
    }
    public boolean registrarPelicula(Pelicula pelicula) {
        if (buscarPeliculaPorCodigo(pelicula.getCodigo()) != null) return false;
        ListaPelicula.add(pelicula);
        return true;
    }
    public Sala buscarSalaPorCodigo(int codigo) {
        for (Sala s : ListaSala) {
            if (s.getCodigo() == codigo) return s;
        }
        return null;
    }
    public boolean registrarSala(Sala sala) {
        if (buscarSalaPorCodigo(sala.getCodigo()) != null) return false;
        ListaSala.add(sala);
        return true;
    }
    public Funcion buscarFuncionPorCodigo(int codigo) {
        for (Funcion f : ListaFunciones) {
            if (f.getCodigo() == codigo) return f;
        }
        return null;
    }
    public boolean programarFuncion(int codigo, int codigoPelicula, int codigoSala, LocalDateTime fecha, String hora, double valorBase) {
        Pelicula pelicula = buscarPeliculaPorCodigo(codigoPelicula);
        Sala sala = buscarSalaPorCodigo(codigoSala);

        if (pelicula == null || sala == null || sala.getEstadoSala() == EstadoSala.FUERA_DE_SERVICIO) {
            return false;
        }

        if (buscarFuncionPorCodigo(codigo) != null) return false;

        Funcion funcion = new Funcion(codigo, pelicula, sala, fecha, hora, valorBase, EstadoFuncion.PROGRAMADA);
        ListaFunciones.add(funcion);
        return true;
    }

    public boolean registrarCliente(Cliente cliente) {
        if (buscarClientePorId(cliente.getIdentificacion()) != null) return false;
        ListaCliente.add(cliente);
        return true;
    }
    public Cliente buscarClientePorId(int id) {
        for (Cliente c : ListaCliente) {
            if (c.getIdentificacion() == id) return c;
        }
        return null;
    }
    public Venta procesarVenta(int codigoVenta, int idCliente, int codigoFuncion, String fila, String numero) {
        Cliente cliente = buscarClientePorId(idCliente);
        Funcion funcion = buscarFuncionPorCodigo(codigoFuncion);

        if (cliente == null || funcion == null || funcion.getEstadoFuncion() != EstadoFuncion.PROGRAMADA) {
            return null;
        }

        Asiento asiento = funcion.getSala().buscarAsiento(fila, numero);
        if (asiento == null || asiento.getEstadoAsiento() == EstadoAsiento.OCUPADO) {
            return null;
        }
        
        Venta venta = new Venta(codigoVenta, cliente, funcion, asiento);
        ListaVenta.add(venta);
        return venta;
    }

    public boolean cancelarVenta(int codigoVenta) {
        for (Venta v : ListaVenta) {
            if (v.getCodigo() == codigoVenta && v.getEstadoVenta() == EstadoVenta.ACTIVA) {
                v.cancelarVenta();
                return true;
            }
        }
        return false;
    }
    public int reporteTotalEntradasVendidas() {
        int total = 0;
        for (Venta v : ListaVenta) {
            if (v.getEstadoVenta() == EstadoVenta.ACTIVA) total++;
        }
        return total;
    }

    public double reporteTotalIngresos() {
        double ingresos = 0.0;
        for (Venta v : ListaVenta) {
            if (v.getEstadoVenta() == EstadoVenta.ACTIVA) ingresos += v.getValorPagado();
        }
        return ingresos;
    }

    public String reportePeliculaMasVendida() {
        if (ListaVenta.isEmpty()) return "Sin ventas registradas";

        Map<Pelicula, Integer> contador = new HashMap<>();
        for (Venta v : ListaVenta) {
            if (v.getEstadoVenta() == EstadoVenta.ACTIVA) {
                Pelicula p = v.getFuncion().getPelicula();
                contador.put(p, contador.getOrDefault(p, 0) + 1);
            }
        }

        Pelicula masVendida = null;
        int max = -1;
        for (Map.Entry<Pelicula, Integer> entry : contador.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                masVendida = entry.getKey();
            }
        }
        return masVendida != null ? masVendida.getNombre() + " (" + max + " entradas)" : "Sin ventas";
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Sala> getListaSala() {
        return ListaSala;
    }

    public void setListaSala(List<Sala> listaSala) {
        ListaSala = listaSala;
    }

    public List<Pelicula> getListaPelicula() {
        return ListaPelicula;
    }

    public void setListaPelicula(List<Pelicula> listaPelicula) {
        ListaPelicula = listaPelicula;
    }

    public List<Cliente> getListaCliente() {
        return ListaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        ListaCliente = listaCliente;
    }

    public List<Venta> getListaVenta() {
        return ListaVenta;
    }

    public void setListaVenta(List<Venta> listaVenta) {
        ListaVenta = listaVenta;
    }

    public List<Funcion> getListaFunciones() {
        return ListaFunciones;
    }

    public void setListaFunciones(List<Funcion> listaFuncione) {
        ListaFunciones = listaFuncione;
    }

    @Override
    public String toString() {
        return "Cinema: " +
                "nombre " + nombre + '\'' +
                ", nit " + nit +
                ", direccion " + direccion + '\'' +
                ", ListaSala " + ListaSala +
                ", ListaPelicula " + ListaPelicula +
                ", ListaCliente " + ListaCliente +
                ", ListaVenta " + ListaVenta +
                ", ListaFuncione " + ListaFunciones ;
    }
}
