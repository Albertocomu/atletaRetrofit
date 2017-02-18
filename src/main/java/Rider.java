
public class Rider {
    private Long id;
    private String nombre;
    private String apellidos;
    private String nacionalidad;

    public Rider() {
    }

    public Rider(String nombre, String apellidos, String nacionalidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
    }

    public Long getId() {return id;}
    public String getNombre() {return nombre;}
    public String getApellidos() {return apellidos;}
    public String getNacionalidad() {return nacionalidad;}

    public void setId(Long id) {this.id = id;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}
    public void setNacionalidad(String nacionalidad) {this.nacionalidad = nacionalidad;}

    @Override
    public String toString() {
        return "Rider{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}
