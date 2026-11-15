import java.sql.SQLOutput;
import java.time.LocalDate;
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
    private List<Empleado> ListaEmpleado;
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
        ListaEmpleado = new ArrayList<>();
    }

    //Peliculas

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

    public void consultarPeliculas() {
        if(ListaPelicula.size() == 0) {
            System.out.println("No existen peliculas registrados");
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

    public boolean deshabilitarPelicula(int codigo){
        for (Pelicula p: ListaPelicula){
            if(p.getCodigo() == codigo){
                if (p.getEstadoPelicula()==EstadoPelicula.DISPONIBLE){
                    p.setEstadoPelicula(EstadoPelicula.NO_DISPONIBLE);
                    return true;
                }

            }
        }
        return false;
    }

    //Salas

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

    public void consultarSalas() {
        if(ListaSala.size() == 0) {
            System.out.println("No existen salas registrados");
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

    public boolean deshabilitarSala(int codigo){
        for (Sala s: ListaSala){
            if(s.getCodigo() == codigo){
                if (s.getEstadoSala()==EstadoSala.DISPONIBLE){
                    s.setEstadoSala(EstadoSala.FUERA_DE_SERVICIO);
                    return true;
                }

            }
        }
        return false;
    }

    //Asiento

    public boolean generarAsiento(int codigoSala, Asiento asiento){
        for (Sala s : ListaSala){
            if(codigoSala==s.getCodigo()){
                s.getListaAsiento().add(asiento);
                return true;
            }
        }
        return false;
    }

    public void mostrarAsientosPorSala(int codigoSala){
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

    //Funciones

    public Funcion buscarFuncionPorCodigo(int codigo) {
        for (Funcion f : ListaFunciones) {
            if (f.getCodigo() == codigo) return f;
        }
        return null;
    }
    public boolean programarFuncion(int codigo, int codigoPelicula, int codigoSala, LocalDate fecha, String hora, double valorBase) {
        Pelicula pelicula = buscarPeliculaPorCodigo(codigoPelicula);
        Sala sala = buscarSalaPorCodigo(codigoSala);

        if (pelicula == null || sala == null || sala.getEstadoSala() == EstadoSala.FUERA_DE_SERVICIO) {
            return false;
        }

        if (buscarFuncionPorCodigo(codigo) != null){
            return false;
        }

        Funcion funcion = new Funcion(codigo, pelicula, sala, fecha, hora, valorBase, EstadoFuncion.PROGRAMADA);
        ListaFunciones.add(funcion);
        return true;
    }

    public void MostrarListaFunciones(String mensaje){
        int a=1;
        if (ListaFunciones == null || ListaFunciones.isEmpty()) {
            System.out.println("La lista de funciones está vacía.");
        }
        for(Funcion funcion : ListaFunciones){
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.println(a+" | Pelicula: "+ funcion.getPelicula().getNombre()+" | Sala: "+funcion.getSala().getNombre()+" | Fecha: " +funcion.getFecha()+" | Hora: " + funcion.getHora()+" | Disponibilidad: "+funcion.getEstadoFuncion());
            a++;
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
    }



    public void buscarFuncionesPelicula(int codigo){
        Pelicula pelicula=buscarPeliculaPorCodigo(codigo);
        if (pelicula==null){
            System.out.println("No existe una pelicula con este codigo.");
        }else {
            System.out.println("Pelicula: " + pelicula.getNombre());
            for (Funcion f : ListaFunciones){
                int i=1;
                if (codigo==f.getPelicula().getCodigo()){
                    System.out.println(" Funcion "+i);
                    System.out.println(f.getSala());
                    System.out.println(f.getFecha());
                    System.out.println(f.getHora());
                    System.out.println("--------------");
                    i++;
                }
            }
        }
    }

    public void buscarFuncionesFecha(LocalDate fecha){
        if (ListaFunciones.isEmpty()){
            System.out.println("No existen funciones para este dia.");
        }else {
            for (Funcion f : ListaFunciones){
                if (fecha == f.getFecha()){
                    System.out.println(f);
                    System.out.println("----------------");
                }
            }
        }
    }

    //Cliente

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

    public void BuscarComprasCliente(int id) {
        for (Cliente c : ListaCliente){
            if (id==c.getIdentificacion()){
                if(c.getListaVenta().size() == 0) {
                    System.out.println("No existen ventas registrados");
                }
                else {
                    System.out.println("Compras hechas por: "+c.getNombre());
                    for(Venta v : c.getListaVenta()) {
                        System.out.println(v);
                        System.out.println("----------------");
                    }

                }
            }
        }
    }

    //Empleado

    public boolean registrarEmpleado(Empleado empleado) {
        if (buscarEmpleadoPorId(empleado.getIdentificacion()) != null) return false;
        ListaEmpleado.add(empleado);
        return true;
    }
    public Empleado buscarEmpleadoPorId(int id) {
        for (Empleado empleado : ListaEmpleado) {
            if (empleado.getIdentificacion() == id)
                return empleado;
        }
        return null;
    }

    public void BuscarVentasEmpleado(int id) {
        for (Empleado e : ListaEmpleado){
            if (id==e.getIdentificacion()){
                if(e.getListaVenta().size() == 0) {
                    System.out.println("No existen ventas registrados");
                }
                else {
                    System.out.println("Compras hechas por: "+e.getNombre());
                    for(Venta v : e.getListaVenta()) {
                        System.out.println(v);
                        System.out.println("----------------");
                    }

                }
            }
        }
    }

    public boolean procesarVenta(int codigoVenta, int idCliente, int idEmpleado, int codigoFuncion, String fila, String numero,LocalDate fecha) {
        Cliente cliente = buscarClientePorId(idCliente);
        Funcion funcion = buscarFuncionPorCodigo(codigoFuncion);
        Empleado empleado = buscarEmpleadoPorId(idEmpleado);

        if (cliente == null || funcion == null || funcion.getEstadoFuncion() != EstadoFuncion.PROGRAMADA) {
            return false;
        }

        Asiento asiento = funcion.getSala().buscarAsiento(fila, numero);
        if (asiento == null || asiento.getEstadoAsiento() == EstadoAsiento.OCUPADO) {
            return false;
        }

        Venta venta = new Venta(codigoVenta, cliente, empleado, funcion, asiento,fecha, ,EstadoVenta.ACTIVA);
        return true;
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

    public double 
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

    public List<Empleado> getListaEmpleado() {
        return ListaEmpleado;
    }

    public void setListaEmpleado(List<Empleado> listaEmpleado) {
        ListaEmpleado = listaEmpleado;
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
