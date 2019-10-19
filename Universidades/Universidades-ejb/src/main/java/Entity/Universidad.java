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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Cristian Romero
 * @author Nathaly Salazar
 */
@NamedQueries({
    @NamedQuery(name="buscarNombreUniversidad", query="SELECT uni FROM Universidad uni WHERE uni.nombre = :nombre"),
    @NamedQuery(name="buscarUniversidadId", query="SELECT uni FROM Universidad uni WHERE uni.id = :id")
})
@Entity
@Table(name="universidad")
public class Universidad implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idu")
    private int id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="escudo")
    private String escudo;
    
    @Column(name="extension")
    private String extension;
    
    @Temporal(TemporalType.DATE)
    @Column(name="fundacion")
    private Date fecha;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universidad")
    List<Diplomado> diplomado;

    public Universidad() {
    }

    public Universidad(String nombre, String escudo, String extension, Date fecha) {
        this.nombre = nombre;
        this.escudo = escudo;
        this.extension = extension;
        this.fecha = fecha;
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

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Diplomado> getDiplomado() {
        return diplomado;
    }

    public void setDiplomado(List<Diplomado> diplomado) {
        this.diplomado = diplomado;
    }
}
