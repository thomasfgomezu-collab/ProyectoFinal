import java.time.LocalDate;

public class Aplicacion {

    private final Cinema cinema;
    private final EntradaDatos datos;

    public Aplicacion() {
        cinema = new Cinema("CinemaUQ", 123456789, "Carrera 15 con Calle 12 Norte, Armenia");
        datos = new EntradaDatos();
        cargarDatosPrueba();
    }

    private void cargarDatosPrueba() {
        cinema.registrarCliente(new Cliente(101, "Juan Perez", "juan@uq.edu.co", "3001234567", TipoCliente.ESTUDIANTE));
        cinema.registrarEmpleado(new Empleado(201, "Carlos Ruiz", "carlos@cinemauq.com", "3109876543", 1300000));
        cinema.registrarPelicula(new Pelicula(1, "Interestelar", "Ciencia Ficcion", "169", EstadoPelicula.DISPONIBLE, ClasificacionPelicula.MAYORES_12));

        Sala sala1 = new Sala(1, "Sala 1", 12, EstadoSala.DISPONIBLE);
        sala1.generarAsientos(3, 4);
        cinema.registrarSala(sala1);

        cinema.programarFuncion(1, 1, 1, LocalDate.now().plusDays(1), "18:00", 15000);
    }

    public static void main(String[] args) {
        new Aplicacion().iniciar();
    }

    void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = datos.leerEntero("Opción: ");

            switch (opcion) {
                case 1 -> registrarCliente();
                case 2 -> registrarEmpleado();
                case 3 -> administrarPeliculas();
                case 4 -> administrarSalas();
                case 5 -> administrarFunciones();
                case 6 -> ventaDeEntrada();
                case 7 -> cancelarVenta();
                case 8 -> reportesVentas();
                case 0 -> System.out.println("Gracias por utilizar CinemaUQ.");
                default -> System.out.println("Opción no valida");
            }
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n========== " + cinema.getNombre() + " ==========");
        System.out.println(" 1. Registrar cliente");
        System.out.println(" 2. Registrar empleado");
        System.out.println(" 3. Administrar peliculas");
        System.out.println(" 4. Administrar salas");
        System.out.println(" 5. Administrar Funciones");
        System.out.println(" 6. Registrar ventas");
        System.out.println(" 7. Cancelar venta");
        System.out.println(" 8. Reportes de ventas");
        System.out.println(" 0. Salir");
    }

    private void registrarCliente() {
        System.out.println("---Registrar cliente---");
        int identificacion = datos.leerEntero("Ingrese el numero de identificacion: ");
        String nombre = datos.leerTextoNoVacio("Ingrese el nombre de la persona: ");
        String correo = datos.leerTexto("Ingrese el correo (si tiene): ");
        String telefono = datos.leerTexto("Ingrese el número de telefono (si tiene): ");
        TipoCliente tipoCliente = datos.seleccionarEnum(TipoCliente.values(), "Tipo de cliente");

        Cliente cliente = new Cliente(identificacion, nombre, correo, telefono, tipoCliente);
        if (cinema.registrarCliente(cliente)) {
            System.out.println("El cliente ha sido registrado correctamente.");
        } else {
            System.out.println("Ya existe una persona registrada con esa identificación.");
        }
    }

    private void registrarEmpleado() {
        System.out.println("---Registrar Empleado---");
        int identificacion = datos.leerEntero("Ingrese el numero de identificacion: ");
        String nombre = datos.leerTextoNoVacio("Ingrese el nombre de la persona: ");
        String correo = datos.leerTexto("Ingrese el correo (si tiene): ");
        String telefono = datos.leerTexto("Ingrese el número de telefono (si tiene): ");
        double salario = datos.leerDouble("Ingrese el salario del empleado: ");

        Empleado empleado = new Empleado(identificacion, nombre, correo, telefono, salario);
        if (cinema.registrarEmpleado(empleado)) {
            System.out.println("El Empleado ha sido registrado correctamente.");
        } else {
            System.out.println("Ya existe una persona registrada con esa identificación.");
        }
    }

    private void administrarPeliculas() {
        System.out.println("---Administrar peliculas---");
        System.out.println("Que acción desea realizar: \n" +
                "1. Registrar pelicula\n" +
                "2. Mostrar peliculas\n" +
                "3. Actualizar peliculas\n" +
                "4. Deshabilitar pelicula\n");

        int opcion = datos.leerEnteroEnRango("Opción: ", 1, 4);
        if (opcion == 1) {
            System.out.println("---Registrar pelicula---");
            int codigo = datos.leerEntero("Ingrese el codigo de la pelicula: ");
            String nombre = datos.leerTextoNoVacio("Ingrese el nombre de la pelicula: ");
            String genero = datos.leerTextoNoVacio("Ingrese el género de la pelicula: ");
            String duracion = datos.leerTextoNoVacio("Ingrese la duración: ");
            EstadoPelicula estadoPelicula1 = datos.seleccionarEnum(EstadoPelicula.values(), "Estado de la pelicula");
            ClasificacionPelicula clasificacionPelicula = datos.seleccionarEnum(ClasificacionPelicula.values(), "Clasificación de la pelicula");

            Pelicula pelicula = new Pelicula(codigo, nombre, genero, duracion, estadoPelicula1, clasificacionPelicula);
            if (cinema.registrarPelicula(pelicula)) {
                System.out.println("La pelicula ha sido registrada correctamente.");
            } else {
                System.out.println("Ya existe una pelicula con este código.");
            }
        } else if (opcion == 2) {
            System.out.println("---Mostrar peliculas---");
            cinema.consultarPeliculas();
        } else if (opcion == 3) {
            System.out.println("---Actualizar pelicula---");
            int codigoA = datos.leerEnteroPositivo("Ingrese el código: ");
            String nombreA = datos.leerTextoNoVacio("Ingrese el nuevo nombre: ");
            String generoA = datos.leerTextoNoVacio("Ingrese el nuevo género: ");
            String duracionA = datos.leerTextoNoVacio("Ingrese la nueva duración: ");
            EstadoPelicula estadoPeliculaA = datos.seleccionarEnum(EstadoPelicula.values(), "Estado pelicula");
            ClasificacionPelicula clasificacionPeliculaA = datos.seleccionarEnum(ClasificacionPelicula.values(), "Clasificación de la pelicula");

            Pelicula peliculaActualizada = new Pelicula(codigoA, nombreA, generoA, duracionA, estadoPeliculaA, clasificacionPeliculaA);
            if (cinema.actualizarPelicula(codigoA, peliculaActualizada)) {
                System.out.println("La pelicula ha sido actualizada.");
            } else {
                System.out.println("No existe pelicula con este código.");
            }
        } else {
            System.out.println("---Deshabilitar pelicula---");
            int codigo = datos.leerEnteroPositivo("Ingrese el código: ");
            if (cinema.deshabilitarPelicula(codigo)) {
                System.out.println("Pelicula deshabilitada.");
            } else {
                System.out.println("Pelicula no existe o ya estaba deshabilitada.");
            }
        }
    }

    private void administrarSalas() {
        System.out.println("---Administrar salas---");
        System.out.println("Que acción desea realizar: \n" +
                "1. Registrar sala\n" +
                "2. Mostrar salas\n" +
                "3. Actualizar sala\n" +
                "4. Deshabilitar sala\n");

        int opcion = datos.leerEnteroEnRango("Opción: ", 1, 4);
        if (opcion == 1) {
            System.out.println("---Registrar sala---");
            int codigo = datos.leerEntero("Ingrese el código de la sala: ");
            String nombre = datos.leerTextoNoVacio("Ingrese el nombre de la sala: ");
            int filas = datos.leerEnteroEnRango("Ingrese la cantidad de filas (1 - 26): ", 1, 26);
            int columnas = datos.leerEnteroPositivo("Ingrese la cantidad de columnas por fila: ");
            int capacidad = filas * columnas;
            EstadoSala estadoSala = datos.seleccionarEnum(EstadoSala.values(), "Estado Sala");

            Sala sala = new Sala(codigo, nombre, capacidad, estadoSala);
            sala.generarAsientos(filas, columnas);

            if (cinema.registrarSala(sala)) {
                System.out.println("La sala ha sido registrada correctamente.");
                sala.mostrarMinimapa();
            } else {
                System.out.println("Ya existe una sala con este código.");
            }
        } else if (opcion == 2) {
            System.out.println("---Mostrar salas---");
            cinema.consultarSalas();
        } else if (opcion == 3) {
            System.out.println("---Actualizar sala---");
            int codigoA = datos.leerEntero("Ingrese el código de la sala: ");
            String nombreA = datos.leerTextoNoVacio("Ingrese el nuevo nombre de la sala: ");
            int filasA = datos.leerEnteroEnRango("Ingrese la nueva cantidad de filas (1 - 26): ", 1, 26);
            int columnasA = datos.leerEnteroPositivo("Ingrese la nueva cantidad de columnas por fila: ");
            int capacidadA = filasA * columnasA;
            EstadoSala estadoSalaA = datos.seleccionarEnum(EstadoSala.values(), "Estado Sala");

            Sala salaA = new Sala(codigoA, nombreA, capacidadA, estadoSalaA);
            salaA.generarAsientos(filasA, columnasA);

            if (cinema.actualizarSala(codigoA, salaA)) {
                System.out.println("La sala ha sido actualizada correctamente.");
                salaA.mostrarMinimapa();
            } else {
                System.out.println("No existe una sala con este código.");
            }
        } else {
            System.out.println("---Deshabilitar sala---");
            int codigo = datos.leerEnteroPositivo("Ingrese el código: ");
            if (cinema.deshabilitarSala(codigo)) {
                System.out.println("Sala deshabilitada correctamente.");
            } else {
                System.out.println("La sala no existe o ya estaba deshabilitada.");
            }
        }
    }

    private void administrarFunciones() {
        System.out.println("---Administrar funciones---");
        System.out.println("Que acción desea realizar: \n" +
                "1. Registrar función\n" +
                "2. Consultar funciones por fecha\n" +
                "3. Consultar las funciones de una pelicula\n");

        int opcion = datos.leerEnteroEnRango("Opción: ", 1, 3);
        if (opcion == 1) {
            System.out.println("---Registrar función---");
            int codigo = datos.leerEntero("Ingrese el codigo de la funcion: ");
            int codigoPelicula = datos.leerEntero("Ingrese el codigo de la pelicula: ");
            int codigoSala = datos.leerEntero("Ingrese el codigo de la sala: ");
            LocalDate fecha1 = datos.leerFecha("Ingrese la fecha");
            String hora = datos.leerTextoNoVacio("Ingrese la hora de la funcion: ");
            double valorBase = datos.leerDoublePositivo("Ingrese el valor base: ");

            if (cinema.programarFuncion(codigo, codigoPelicula, codigoSala, fecha1, hora, valorBase)) {
                System.out.println("Funcion agregada con exito.");
            } else {
                System.out.println("La funcion ya esta programada o la pelicula/sala no existe o está deshabilitada.");
            }
        } else if (opcion == 2) {
            System.out.println("---Consultar funciones por fecha---");
            LocalDate fecha = datos.leerFecha("Ingrese la fecha");
            cinema.buscarFuncionesFecha(fecha);
        } else {
            System.out.println("---Consultar funciones de una pelicula---");
            int codigo = datos.leerEnteroPositivo("Ingrese el código de la pelicula: ");
            cinema.buscarFuncionesPelicula(codigo);
        }
    }

    private void ventaDeEntrada() {
        System.out.println("---Venta de entrada---");
        int codigoDeVenta = datos.leerEntero("Ingrese codigo de venta: ");
        int codigoClienteVenta = datos.leerEntero("Ingrese codigo del cliente: ");
        int codigoEmpleadoVenta = datos.leerEntero("Ingrese codigo del empleado: ");

        System.out.println("---Funciones---");
        cinema.MostrarListaFunciones("---Funciones---");

        if (cinema.getListaFunciones().isEmpty()) {
            System.out.println("No hay funciones disponibles para vender.");
            return;
        }

        Funcion funcion = imprimirListaFunciones();
        funcion.getSala().mostrarMinimapa();

        String fila = datos.leerTextoNoVacio("Ingrese la fila del asiento (ej. A): ").trim().toUpperCase();
        String numero = datos.leerTextoNoVacio("Ingrese el numero del asiento (ej. 1): ").trim();
        LocalDate fechaVenta = datos.leerFecha("Ingresa la fecha");

        boolean venta = cinema.procesarVenta(codigoDeVenta, codigoClienteVenta, codigoEmpleadoVenta, funcion.getCodigo(), fila, numero, fechaVenta);

        if (venta) {
            System.out.println("La venta ha sido agregada con éxito.");
        } else {
            System.out.println("La venta no tiene los datos correctos o el asiento ya está ocupado.");
        }
    }

    private void cancelarVenta() {
        System.out.println("---Cancelar venta---");
        int codigoVenta = datos.leerEntero("Ingrese el código de la venta a cancelar: ");
        if (cinema.cancelarVenta(codigoVenta)) {
            System.out.println("La venta ha sido cancelada y el asiento quedó disponible nuevamente.");
        } else {
            System.out.println("No existe una venta activa con ese código.");
        }
    }

    private void reportesVentas() {
        System.out.println("---Reporte de ventas---");
        System.out.println("Que acción desea realizar: \n" +
                "1. Consultar ventas de un Cliente\n" +
                "2. Consultar ventas de un empleado\n" +
                "3. Ver total de entradas vendidas\n" +
                "4. Consultar el total de ingresos\n" +
                "5. Consultar la pelicula que mas vendio\n");

        int opcion = datos.leerEnteroEnRango("Opción: ", 1, 5);
        if (opcion == 1) {
            int codigo = datos.leerEnteroPositivo("Ingrese el código del cliente: ");
            cinema.BuscarComprasCliente(codigo);
        } else if (opcion == 2) {
            int codigo = datos.leerEnteroPositivo("Ingrese el código del empleado: ");
            cinema.BuscarVentasEmpleado(codigo);
        } else if (opcion == 3) {
            System.out.println("Total de entradas vendidas: " + cinema.reporteTotalEntradasVendidas());
        } else if (opcion == 4) {
            System.out.println("Total de ingresos: $" + cinema.reporteTotalIngresos());
        } else {
            System.out.println("Película más vendida: " + cinema.reportePeliculaMasVendida());
        }
    }

    public Funcion imprimirListaFunciones() {
        int numeroPelicula = datos.leerEnteroEnRango("Ingrese el numero de la funcion que desea comprar: ", 1, cinema.getListaFunciones().size());
        return cinema.getListaFunciones().get(numeroPelicula - 1);
    }
}