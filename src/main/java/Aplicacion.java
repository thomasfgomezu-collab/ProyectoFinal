import java.time.LocalDate;

public class Aplicacion {

    private final Cinema cinema;
    private final EntradaDatos datos;

    public Aplicacion(){
        cinema= new Cinema("CinemaUQ", 123456789, "Carrera 15 con Calle 12 Norte, Armenia");
        datos= new EntradaDatos();
    }

    static void main(){
        new Aplicacion().iniciar();
    }

    void iniciar(){

        int opcion;

        do{
            mostrarMenu();
            opcion = datos.leerEntero("Opción: ");

            switch (opcion){
                case 1 -> registrarCliente();
                case 2 -> registrarEmpleado();
                case 3 -> administrarPeliculas();
                case 4 -> adminiatrarSalas();
                case 5 -> adminitrarFunciones();

                case 10-> reportesVentas();
                case 0 -> System.out.println("Gracias por utilizar CinemaUQ.");
                default -> System.out.println("Opción no valida");
            }
        }while (opcion!=0);

    }

    private void mostrarMenu(){
        System.out.println("\n========== " + cinema.getNombre() + " ==========");
        System.out.println(" 1. Registrar cliente");
        System.out.println(" 2. Registrar empleado");
        System.out.println(" 3. Administrar peliculas");
        System.out.println(" 4. Administrar salas");
        System.out.println(" 5. AdiministrarFunciones");
        System.out.println(" 6. ");
        System.out.println(" 7. ");
        System.out.println(" 8. ");
        System.out.println(" 9. ");
        System.out.println("10. Reportes de ventas");
        System.out.println(" 0. Salir");
    }

    private void registrarCliente(){
        System.out.println("---Registrar cliente---");

        int identificacion= datos.leerEntero("Ingrese el numero de identificacion: ");
        String nombre= datos.leerTextoNoVacio("Ingrese el nombre de la persona: ");
        String correo= datos.leerTexto("Ingrese el correo (si tiene): ");
        String telefono=datos.leerTexto("Ingrese el número de telefono(si tiene): ");
        TipoCliente tipoCliente=datos.seleccionarEnum(TipoCliente.values(), "Tipo de cliente");
        Cliente cliente= new Cliente(identificacion, nombre,correo, telefono, tipoCliente);
        if (cinema.registrarCliente(cliente)){
            System.out.println("El cliente ha sido registrado correctamente.");
        }else {
            System.out.println("Ya existe una persona registrada con esa identificación.");
        }
    }

    private void registrarEmpleado(){
        System.out.println("---Registrar Empleado---");

        int identificacion= datos.leerEntero("Ingrese el numero de identificacion: ");
        String nombre= datos.leerTextoNoVacio("Ingrese el nombre de la persona: ");
        String correo= datos.leerTexto("Ingrese el correo (si tiene): ");
        String telefono=datos.leerTexto("Ingrese el número de telefono(si tiene): ");
        double salario=datos.leerDouble("Ingrese el salario del empleado: ");
        Empleado empleado = new Empleado(identificacion, nombre,correo, telefono, salario);
        if (cinema.registrarEmpleado(empleado)){
            System.out.println("El Empleado ha sido registrado correctamente.");
        }else {
            System.out.println("Ya existe una persona registrada con esa identificación.");
        }
    }

    private void administrarPeliculas(){
        System.out.println("---Administrar peliculas---");
        System.out.println("Que acción desea realizar: " +
                "1. Registrar pelicula"+
                "2. Mostrar peliculas"+
                "3. Actualizar peliculas"+
                "4. deshabilitar pelicula\n");

        int opcion=datos.leerEnteroEnRango("Opción: ", 1,4);
        if (opcion==1){
            System.out.println("---Registrar pelicula---");
            int codigo=datos.leerEntero("Ingrese el codigo de la pelicula: ");
            String nombre= datos.leerTextoNoVacio("Ingrese el nombre de la pelicula: ");
            String genero= datos.leerTextoNoVacio("Ingrese el género de la pelicula: ");
            String duracion= datos.leerTextoNoVacio("Ingrese la duración: ");
            EstadoPelicula estadoPelicula= datos.seleccionarEnum(EstadoPelicula.values(),"Estado de la pelicula");
            ClasificacionPelicula clasificacionPelicula=datos.seleccionarEnum(ClasificacionPelicula.values(),"Clasidicacón de la,pelicula");
            Pelicula pelicula=new Pelicula(codigo, nombre, genero, duracion, estadoPelicula, clasificacionPelicula);
            if (cinema.registrarPelicula(pelicula)){
                System.out.println("La pelicula ha sido registrada correctamente.");
            }else {
                System.out.println("Ya existe una oelicula con este código.");
            }
        } else if (opcion==2) {
            System.out.println("---Mostrar peliculas---");
            cinema.consultarPeliculas();
        } else if (opcion==3) {
            System.out.println("---Actualizar pelicula---");

            int codigoA=datos.leerEnteroPositivo("Ingrese el código: ");
            String nombreA= datos.leerTextoNoVacio("Ingrese el nuevo nombre: ");
            String generoA= datos.leerTextoNoVacio("Ingrese el nuevo género: ");
            String duracionA= datos.leerTextoNoVacio("ingrese la nueva duración: ");
            EstadoPelicula estadoPeliculaA= datos.seleccionarEnum(EstadoPelicula.values(), "Estado pelicula");
            ClasificacionPelicula clasificacionPeliculaA=datos.seleccionarEnum(ClasificacionPelicula.values(),"Clasidicacón de la,pelicula");
            Pelicula peliculaActualizada=new Pelicula(codigoA, nombreA, generoA, duracionA, estadoPeliculaA, clasificacionPeliculaA);
            if (cinema.actualizarPelicula(codigoA, peliculaActualizada)){
                System.out.println("La peliculaha sido actualizada.");
            }else {
                System.out.println("No existe pelicula con este código.");
            }
        } else{
            System.out.println("---Deshabilitar pelicula---");
            int codigo= datos.leerEnteroPositivo("Ingrese el código: ");
            if(cinema.deshabilitarPelicula(codigo)){
                System.out.println("Pelicula deshabilitada.");
            }else {
                System.out.println("Pelicula ya estaba deshabilitada.");
            }
        }
    }

    private void adminiatrarSalas(){
        System.out.println("---Administrar salas---");
        System.out.println("Que acción desea realizar: " +
                "1. Registrar sala"+
                "2. Mostrar salas"+
                "3. Actualizar sala"+
                "4. deshabilitar sala\n");

        int opcion=datos.leerEnteroEnRango("Opción: ", 1,4);
        if (opcion==1){
            System.out.println("---Registrar sala---");
            int codigo=datos.leerEntero("Ingrese el codigo de la sala: ");
            String nombre= datos.leerTextoNoVacio("Ingrese el nombre de la sala: ");
            int capacidad= datos.leerEnteroPositivo("Ingrese la capacidad de la sala(asientos): ");
            EstadoSala estadoSala =datos.seleccionarEnum(EstadoSala.values(),"Estado Sala");
            Sala sala= new Sala(codigo, nombre, capacidad, estadoSala);
            if (cinema.registrarSala(sala)){
                System.out.println("Ingresas asientos");
                generarAsiento(codigo,capacidad);
                System.out.println("La sala ha sido registrada correctamente.");
            }else {
                System.out.println("Ya existe una sala con este código.");
            }
        } else if (opcion==2) {
            System.out.println("---Mostrar salas---");
            cinema.consultarSalas();
        } else if (opcion==3) {
            System.out.println("---Actualizar sala---");

            int codigoA=datos.leerEntero("Ingrese el codigo de la sala: ");
            String nombreA= datos.leerTextoNoVacio("Ingrese el nuevo nombre de la sala: ");
            int capacidadA= datos.leerEnteroPositivo("Ingrese la nueva capacidad de la sala(asientos): ");
            EstadoSala estadoSalaA =datos.seleccionarEnum(EstadoSala.values(),"Estado Sala");
            Sala salaA= new Sala(codigoA, nombreA, capacidadA, estadoSalaA);
            if (cinema.actualizarSala(codigoA, salaA)){

                System.out.println("La sala ha sido registrada correctamente.");
            }else {
                System.out.println("No existe una sala con este código.");
            }
        } else{
            System.out.println("---Deshabilitar sala---");
            int codigo= datos.leerEnteroPositivo("Ingrese el código: ");
            if(cinema.deshabilitarSala(codigo)){
                System.out.println("Pelicula deshabilitada.");
            }else {
                System.out.println("Pelicula ya estaba deshabilitada.");
            }
        }
    }

    private void generarAsiento(int codigoSala, int capacidad){
        for (int i =1; i<=capacidad; i++){
            System.out.println("Ingrese el asiento "+i);
            int codigo= datos.leerEnteroPositivo("Ingrese el código: ");
            String fila= datos.leerTextoNoVacio("Ingrese la fila: ");
            String numero= datos.leerTextoNoVacio("Ingrese el Número: ");
            EstadoAsiento estadoAsiento= EstadoAsiento.DISPONIBLE;
            Asiento asiento=new Asiento(codigo, fila, numero,estadoAsiento);
            cinema.generarAsiento(codigoSala, asiento);
        }
    }

    private  void adminitrarFunciones(){
        System.out.println("---Administrar funciones---");
        System.out.println("Que acción desea realizar: " +
                "1. Registrar función"+
                "2. Consultar funciones por fecha"+
                "3. consultar las funciones de una pelicula");
        int opcion=datos.leerEnteroEnRango("Opción: ", 0, 3);
        if (opcion==1){
            System.out.println("---Resgistrar función---");

        } else if (opcion==2) {
            System.out.println("---Concultar funciones por fecha---");
            LocalDate fecha= datos.leerFecha("Ingrese la fecha: ");
            cinema.buscarFuncionesFecha(fecha);
        }else {
            System.out.println("---consultar funciones de una pelicula---");
            int codigo=datos.leerEnteroPositivo("Ingrese el código de la pelicula: ");
            cinema.buscarFuncionesPelicula(codigo);
        }
    }

    //otras funciones del case












    private void reportesVentas(){
        System.out.println("---Reporte de ventas---");
        System.out.println("Que acción desea realizar: "+
                "1. Consultar ventas de un Cliente"+
                "2. Consultar ventas de un empleado"+
                "3. Ver total de entradas vendidas"+
                "4. Consultar en total de ingresos"+
                "5. Consultar la pelicula que mas vendio");
        int opcion= datos.leerEnteroEnRango("Opción: ", 0,5);
        if (opcion==1){
            int codigo=datos.leerEnteroPositivo("Ingrese el código del cliente: ");
            cinema.BuscarComprasCliente(codigo);
        } else if (opcion==2) {
            int codigo=datos.leerEnteroPositivo("Ingrese el código del empleado: ");
            cinema.BuscarVentasEmpleado(codigo);
        } else if (opcion==3) {
            cinema.reporteTotalEntradasVendidas();
        } else if (opcion==4) {
            cinema.reporteTotalIngresos();
        } else if (opcion==5) {
            cinema.reportePeliculaMasVendida();
        }
    }
}
