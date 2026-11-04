public class Pelicula {
    private int codigo;
    private String nombre;
    private String genero;
    private String duracion;
    private String estado;

    private ClasificacionPelicula clasificacionPelicula;

    Pelicula(int codigo, String nombre, String genero, String duracion, String estado, ClasificacionPelicula clasificacionPelicula) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.genero = genero;
        this.duracion = duracion;
        this.estado = estado;
        this.clasificacionPelicula = clasificacionPelicula;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ClasificacionPelicula getClasificacionPelicula() {
        return clasificacionPelicula;
    }

    public void setClasificacionPelicula(ClasificacionPelicula clasificacionPelicula) {
        this.clasificacionPelicula = clasificacionPelicula;
    }

    @Override
    public String toString() {
        return "ClasificacionPelicula: " +
                "codigo= " + codigo +
                ", nombre= " + nombre + '\'' +
                ", genero= " + genero + '\'' +
                ", duracion= " + duracion + '\'' +
                ", estado= " + estado + '\'' +
                ", clasificacionPelicula= " + clasificacionPelicula ;
    }
}
