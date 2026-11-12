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
    private List<Funcion> ListaFuncione;

    public Cinema(String nombre, int nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        ListaSala = new ArrayList<>();
        ListaPelicula = new ArrayList<>();
        ListaCliente = new ArrayList<>();
        ListaVenta = new ArrayList<>();
        ListaFuncione = new ArrayList<>();
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

    public List<Funcion> getListaFuncione() {
        return ListaFuncione;
    }

    public void setListaFuncione(List<Funcion> listaFuncione) {
        ListaFuncione = listaFuncione;
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
                ", ListaFuncione " + ListaFuncione ;
    }

    public boolean registrarCliente(Cliente cliente) {
        for (Cliente c : ListaCliente) {
            if (c.getIdentificacion() == cliente.getIdentificacion()) {
                return false;
            }
        }
        ListaCliente.add(cliente);
        return true;
    }

    public boolean registrarPelicula(Pelicula pelicula) {
        for (Pelicula p : ListaPelicula) {
            if (p.getCodigo() == pelicula.getCodigo()) {
                return false;
            }
        }
        ListaPelicula.add(pelicula);
        return true;
    }

    public void consultarPeliculas() {
        if(ListaPelicula.size() == 0) {
            System.out.println("No existen clientes registrados");
        }
        else {
            for(Pelicula peliculaLista : ListaPelicula) {
                System.out.println(peliculaLista);
                System.out.println("----------------");
            }
        }
    }

    public boolean actualizarPelicula(int codigo, Pelicula peliculaActualizada){
        for (Pelicula p: ListaPelicula){
            if(p.getCodigo() == codigo){
                p.setNombre(peliculaActualizada.getNombre());
                p.setGenero(peliculaActualizada.getGenero());
                p.setDuracion(peliculaActualizada.getDuracion());
                p.setClasificacionPelicula(peliculaActualizada.getClasificacionPelicula());
                return true;
            }
        }
        return false;
    }

    public boolean deshabilitarPelicula(Pelicula pelicula){
        for (Pelicula p: ListaPelicula){
            if(p.getCodigo() == pelicula.getCodigo()){
                if (p.getEstadoPelicula()==EstadoPelicula.DISPONIBLE){
                    p.setEstadoPelicula(EstadoPelicula.NO_DISPONIBLE);
                    return true;
                }

            }
        }
        return false;
    }

    public boolean registrarSala(Sala sala) {
        for (Sala s : ListaSala) {
            if (s.getCodigo() == sala.getCodigo()) {
                return false;
            }
        }
        ListaSala.add(sala);
        return true;
    }

    public void consultarSalas() {
        if(ListaSala.size() == 0) {
            System.out.println("No existen clientes registrados");
        }
        else {
            for(Sala salaLista : ListaSala) {
                System.out.println(salaLista);
                System.out.println("----------------");
            }
        }
    }

    public boolean actualizarSala(int codigo, Sala salaActualizada){
        for (Sala s: ListaSala){
            if(s.getCodigo() == codigo){
                s.setNombre(salaActualizada.getNombre());
                s.setCapacidad(salaActualizada.getCapacidad());

                return true;
            }
        }
        return false;
    }

    public boolean deshabilitarSala(Sala sala){
        for (Sala s: ListaSala){
            if(s.getCodigo() == sala.getCodigo()){
                if (s.getEstadoSala()==EstadoSala.ACTIVA){
                    s.setEstadoSala(EstadoSala.DESHABILITADA);
                    return true;
                }

            }
        }
        return false;
    }

    public boolean generarAsiento(int codigoSala, Asiento asiento){
        for (Sala s : ListaSala){
            if(codigoSala==s.getCodigo()){
                s.getListaAsiento().add(asiento);
                return true;
            }
        }
        return false;
    }

    public void mostrarAsientos(int codigoSala){
        for (Sala s : ListaSala){
            if (codigoSala==s.getCodigo()){
                if(s.getListaAsiento().size() == 0) {
                    System.out.println("No existen asientos registrados");
                }
                else {
                    System.out.println("Asientos de la sala: "+s.getNombre());
                    for(Asiento asiento : s.getListaAsiento()) {
                        System.out.println(asiento);
                        System.out.println("----------------");
                    }

                }
            }
        }
    }
}
