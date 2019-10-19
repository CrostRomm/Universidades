package POJO;

import java.util.Date;

/**
 * @author Cristian Romero
 * @author Nathaly Salazar
 */
public class DiplomadoPOJO {
    private int id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private String descripcion;
    private int idU;

    public DiplomadoPOJO() {
    }

    public DiplomadoPOJO(String nombre, Date fechaInicio, Date fechaFin, String descripcion,int idU) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.idU = idU;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }
    
    
}
