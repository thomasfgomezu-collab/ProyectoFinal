public class Pelicula {
    private int codigo;
    private String nombre;
    private String genero;
    private String duracion;

    private EstadoPelicula estadoPelicula;
    private ClasificacionPelicula clasificacionPelicula;

   public Pelicula(int codigo, String nombre, String genero, String duracion, EstadoPelicula estadoPelicula, ClasificacionPelicula clasificacionPelicula) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.genero = genero;
        this.duracion = duracion;
        this.estadoPelicula = estadoPelicula;
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

    public EstadoPelicula getEstadoPelicula() {
        return estadoPelicula;
    }

    public void setEstadoPelicula(EstadoPelicula estadoPelicula) {
        this.estadoPelicula = estadoPelicula;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public ClasificacionPelicula getClasificacionPelicula() {
        return clasificacionPelicula;
    }

    public void setClasificacionPelicula(ClasificacionPelicula clasificacionPelicula) {
        this.clasificacionPelicula = clasificacionPelicula;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", duracion='" + duracion + "min" +'\'' +
                ", estado='" + estadoPelicula + '\'' +
                ", clasificacionPelicula=" + clasificacionPelicula +
                '}';
    }

}
