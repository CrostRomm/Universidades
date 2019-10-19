package POJO;
/**
 * @author Cristian Romero
 * @author Nathaly Salazar
 */
public class AlumnoPOJO {
    private int id;
    private String nombre;
    private String foto;
    private int edad;

    public AlumnoPOJO() {
    }

    public AlumnoPOJO(String nombre, String foto, int edad) {
        this.nombre = nombre;
        this.foto = foto;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
