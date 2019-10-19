/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 *
 * @author Hp-14
 */
@NamedQueries({
    @NamedQuery(name="traeReporte", query="SELECT v FROM Vista v WHERE v.id = :id")
})
@Entity
@Table(name="reporte_view")
@Immutable
public class Vista implements Serializable{
    
    @Id
    @Column(name = "id_alumno", updatable = false, nullable = false)
    private int idAlumno;
    
    @Column(name="identifier")
    private int id;
    
    @Column(name="nombreu")
    private String nombreUniversidad;
    
    @Column(name="extension")
    private String extension;
    
    @Column(name="nombred")
    private String nombreDiplomado;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="fecha_inicio")
    private Date fechaInicio;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="fecha_fin")
    private Date fechaFinal;
    
    @Column(name="nombrea")
    private String nombreAlumno;
    
    @Column(name="foto")
    private String fotoAlumno;

    public Vista(int idAlumno, int id, String nombreUniversidad, String extension, String nombreDiplomado, Date fechaInicio, Date fechaFinal, String nombreAlumno, String fotoAlumno) {
        this.idAlumno = idAlumno;
        this.id = id;
        this.nombreUniversidad = nombreUniversidad;
        this.extension = extension;
        this.nombreDiplomado = nombreDiplomado;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.nombreAlumno = nombreAlumno;
        this.fotoAlumno = fotoAlumno;
    }

    

    public Vista() {
    }

    public Vista(int id) {
        this.id = id;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUniversidad() {
        return nombreUniversidad;
    }

    public void setNombreUniversidad(String nombreUniversidad) {
        this.nombreUniversidad = nombreUniversidad;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getNombreDiplomado() {
        return nombreDiplomado;
    }

    public void setNombreDiplomado(String nombreDiplomado) {
        this.nombreDiplomado = nombreDiplomado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getFotoAlumno() {
        return fotoAlumno;
    }

    public void setFotoAlumno(String fotoAlumno) {
        this.fotoAlumno = fotoAlumno;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }
}
