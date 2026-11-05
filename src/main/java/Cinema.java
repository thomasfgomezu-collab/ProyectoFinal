import java.util.ArrayList;
import java.util.List;

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
