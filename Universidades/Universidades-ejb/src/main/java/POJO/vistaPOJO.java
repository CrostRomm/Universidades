/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.util.Date;

/**
 *
 * @author Hp-14
 */
public class vistaPOJO {
    
    private int id;
    private String nombreUniversidad;
    private String extension;
    private String nombreDiplomado;
    private Date fechaInicio;
    private Date fechaFin;
    private String nombreAlumno;
    private String foto;

    public vistaPOJO(int id, String nombreUniversidad, String extension, String nombreDiplomado, Date fechaInicio, Date fechaFin, String nombreAlumno, String foto) {
        this.id = id;
        this.nombreUniversidad = nombreUniversidad;
        this.extension = extension;
        this.nombreDiplomado = nombreDiplomado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombreAlumno = nombreAlumno;
        this.foto = foto;
    }

    public vistaPOJO() {
    }

    public vistaPOJO(int id) {
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

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    
}
