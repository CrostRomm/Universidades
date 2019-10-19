package POJO;

import java.util.Date;

/**
 * @author Cristian Romero
 * @author Nathaly Salazar
 */
public class UniversidadPOJO {
    private int id;
    private String nombre;
    private String escudo;
    private String extension;
    private Date fundacion;

    public UniversidadPOJO() {
    }

    
    
    public UniversidadPOJO(String nombre, String escudo, String extension, Date fundacion) {
        this.nombre = nombre;
        this.escudo = escudo;
        this.extension = extension;
        this.fundacion = fundacion;
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

    public Date getFundacion() {
        return fundacion;
    }

    public void setFundacion(Date fundacion) {
        this.fundacion = fundacion;
    }
    
    
}
