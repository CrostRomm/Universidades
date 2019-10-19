package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
/**
 * @author Cristian Romero
 * @author Nathaly Salazar
 */
@NamedQueries({
    @NamedQuery(name="buscarUniversidadAsignada", query="SELECT dip FROM Diplomado dip WHERE dip.nombre = :nombre")
})
@Entity
@Table(name="diplomado")
public class Diplomado implements Serializable{
    /**
     * id diplomado
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idd")
    private int id;
    /**
     * nombre diplomado
     */
    @Column(name="nombre")
    private String nombre;
    /**
     * fecha inicio pilomado
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="fecha_inicio")
    private Date fechaInicio;
    /**
     * Fecha fin diplomado
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="fecha_fin")
    private Date fechaFin;
    /**
     * descripcion diplomado
     */
    @Column(name="descripcion")
    private String descripcion;
    /**
     * relacion contra universidad
     */
    @ManyToOne
    @JoinColumn(name = "id_universidad", nullable = false)
    private Universidad universidad;
    /**
     * Relacion contra alumno
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diplomado")
    private List<Alumno> alumno;
/**
 * constructor
 */
    public Diplomado() {
    }
    /**
     * Constructor
     * @param nombre
     * @param fechaInicio
     * @param fechaFin
     * @param descripcion
     * @param universidad 
     */
    public Diplomado(String nombre, Date fechaInicio, Date fechaFin, String descripcion, Universidad universidad) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.universidad = universidad;
    }
    /**
     * get id
     * @return 
     */
    public int getId() {
        return id;
    }
    /**
     * set id
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * get nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * set nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * get fecha inicio
     * @return 
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }
    /**
     * Set fecha inicio
     * @param fechaInicio 
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    /**
     * Get decha fin
     * @return 
     */
    public Date getFechaFin() {
        return fechaFin;
    }
    /**
     * set fecha fin
     * @param fechaFin 
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    /**
     * Get descripcion
     * @return 
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * set descriocion
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * get univerisda
     * @return 
     */
    public Universidad getUniversidad() {
        return universidad;
    }
    /**
     * ste unviersidad
     * @param universidad 
     */
    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }
    /**
     * get alumno
     * @return 
     */
    public List<Alumno> getAlumno() {
        return alumno;
    }
    /**
     * set alumno
     * @param alumno 
     */
    public void setAlumno(List<Alumno> alumno) {
        this.alumno = alumno;
    }
    
    
}
