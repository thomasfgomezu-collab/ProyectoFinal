import java.util.Scanner;

public class EntradaDatos {
    private Scanner Scanner= new Scanner(System.in);

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return Scanner.nextLine().trim();
    }

    public String leerTextoNoVacio(String mensaje) {
        while (true) {
            String texto = leerTexto(mensaje);
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("El texto no puede quedar vacío.");
        }
    }

    public int leerEntero(String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(leerTexto(mensaje));
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número entero válido.");
            }
        }
    }

    public int leerEnteroEnRango(String mensaje, int minimo, int maximo) {
        while (true) {
            int valor = leerEntero(mensaje);
            if (valor >= minimo && valor <= maximo) {
                return valor;
            }
            System.out.printf("Ingrese un valor entre %d y %d.%n", minimo, maximo);
        }
    }

    public int leerEnteroPositivo(String mensaje) {
        while (true) {
            int valor = leerEntero(mensaje);
            if (valor > 0) {
                return valor;
            }
            System.out.println("El valor debe ser mayor que cero.");
        }
    }

    public double leerDouble(String mensaje) {
        while (true) {
            try {
                double valor = Double.parseDouble(leerTexto(mensaje).replace(',', '.'));
                if (Double.isFinite(valor)) {
                    return valor;
                }
            } catch (NumberFormatException ignorada) {
            }
            System.out.println("Ingrese un número válido.");
        }
    }

    public double leerDoublePositivo(String mensaje) {
        while (true) {
            double valor = leerDouble(mensaje);
            if (valor > 0) {
                return valor;
            }
            System.out.println("El valor debe ser mayor que cero.");
        }
    }

    public boolean leerBooleano(String mensaje) {
        while (true) {
            String r = leerTexto(mensaje + " (s/n): ");
            if (r.equalsIgnoreCase("s") || r.equalsIgnoreCase("si") || r.equalsIgnoreCase("sí")) {
                return true;
            }
            if (r.equalsIgnoreCase("n") || r.equalsIgnoreCase("no")) {
                return false;
            }
            System.out.println("Responda s o n.");
        }
    }

    public <T extends Enum<T>> T seleccionarEnum(T[] valores, String titulo) {
        System.out.println(titulo + ":");
        for (int i = 0; i < valores.length; i++) {
            System.out.println((i + 1) + ". " + valores[i]);
        }
        return valores[leerEnteroEnRango("Seleccione: ", 1, valores.length) - 1];
    }

    public String siNo(boolean valor) {
        return valor ? "sí" : "no";
    }
}
