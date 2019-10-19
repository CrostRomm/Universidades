package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Cristian Romero
 * @author Nathaly Salazar
 */
@NamedQueries({
    @NamedQuery(name="buscarDiplomadoAsignado", query="SELECT est FROM Alumno est WHERE est.nombre = :nombre")
})
@Entity
@Table(name="alumno")
public class Alumno implements Serializable{
    /**
     * id de alumo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ida")
    private int id;
    /**
     * nombre de alumno
     */
    @Column(name="nombre")
    private String nombre;
    /**
     * foto de alumno
     */
    @Column(name="foto")
    private String foto;
    /**
     * edad de alumno
     */
    @Column(name="edad")
    private int edad;
    /**
     * Relación contra diplomado
     */
    @ManyToOne
    @JoinColumn(name = "id_diplomado", nullable = false)
    Diplomado diplomado;
    /**
     * Constructor
     */
    public Alumno() {
    }
    /**
     * Constructor
     * @param nombre
     * @param foto
     * @param edad
     * @param diplomado 
     */
    public Alumno(String nombre, String foto, int edad, Diplomado diplomado) {
        this.nombre = nombre;
        this.foto = foto;
        this.edad = edad;
        this.diplomado = diplomado;
    }
    /**
     * Get id
     * @return  int
     */
    public int getId() {
        return id;
    }
    /**
     * Set id
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Get nomnbre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Set nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Get foto
     * @return 
     */
    public String getFoto() {
        return foto;
    }
    /**
     * Set foto
     * @param foto 
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }
    /**
     * Get edad
     * @return 
     */
    public int getEdad() {
        return edad;
    }
    /**
     * Set edad
     * @param edad 
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    /**
     * get diplomado
     * @return 
     */
    public Diplomado getDiplomado() {
        return diplomado;
    }
    /**
     * Set diplomado
     * @param diplomado 
     */
    public void setDiplomado(Diplomado diplomado) {
        this.diplomado = diplomado;
    }
}
