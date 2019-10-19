package Controller;

import Entity.Alumno;
import Entity.Diplomado;
import Entity.Universidad;
import Entity.Vista;
import Interfaces.AlumnoFacadeLocal;
import Interfaces.DiplomadoFacadeLocal;
import Interfaces.UniversidadFacadeLocal;
import Interfaces.VistaFacadeLocal;
import POJO.AlumnoPOJO;
import POJO.DiplomadoPOJO;
import POJO.UniversidadPOJO;
import POJO.vistaPOJO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.FileUploadEvent;

/**
 * @author Cristian Romero
 * @author Nathaly Salazar
 */
@ManagedBean(name = "bean")
@SessionScoped
public class inicioController implements Serializable {

    @EJB
    private UniversidadFacadeLocal universidadEjb;

    @EJB
    private DiplomadoFacadeLocal diplomadoEjb;

    @EJB
    private AlumnoFacadeLocal alumnoEjb;

    @EJB
    private VistaFacadeLocal vistaEjb;
            
    private UniversidadPOJO pojoU;

    private DiplomadoPOJO pojoD;

    private AlumnoPOJO pojoA;

    private vistaPOJO pojoV;
    
    private List<Universidad> listaUniversidad;

    private List<Diplomado> listaDiplomado;

    private List<Alumno> listaAlumno;

    private List<Vista> listaVista;
    
    private UploadedFile file;
    
    private UploadedFile foto;
    @PostConstruct
    public void iniciar() {
        pojoU = new UniversidadPOJO();
        pojoD = new DiplomadoPOJO();
        pojoA = new AlumnoPOJO();
        pojoV = new vistaPOJO();
        listaUniversidad = new ArrayList();
        listaDiplomado = new ArrayList();
        listaAlumno = new ArrayList();
        listaVista = new ArrayList();
    }

    /**
     * Constructor
     */
    public inicioController() {
    }

    public UniversidadFacadeLocal getUniversidadEjb() {
        return universidadEjb;
    }

    public void setUniversidadEjb(UniversidadFacadeLocal universidadEjb) {
        this.universidadEjb = universidadEjb;
    }

    public DiplomadoFacadeLocal getDiplomadoEjb() {
        return diplomadoEjb;
    }

    public void setDiplomadoEjb(DiplomadoFacadeLocal diplomadoEjb) {
        this.diplomadoEjb = diplomadoEjb;
    }

    public AlumnoFacadeLocal getAlumnoEjb() {
        return alumnoEjb;
    }

    public void setAlumnoEjb(AlumnoFacadeLocal alumnoEjb) {
        this.alumnoEjb = alumnoEjb;
    }

    public UniversidadPOJO getPojoU() {
        return pojoU;
    }

    public void setPojoU(UniversidadPOJO pojoU) {
        this.pojoU = pojoU;
    }

    public DiplomadoPOJO getPojoD() {
        return pojoD;
    }

    public void setPojoD(DiplomadoPOJO pojoD) {
        this.pojoD = pojoD;
    }

    public AlumnoPOJO getPojoA() {
        return pojoA;
    }

    public void setPojoA(AlumnoPOJO pojoA) {
        this.pojoA = pojoA;
    }

    public List<Universidad> getListaUniversidad() {
        return listaUniversidad;
    }

    public void setListaUniversidad(List<Universidad> listaUniversidad) {
        this.listaUniversidad = listaUniversidad;
    }

    public List<Diplomado> getListaDiplomado() {
        return listaDiplomado;
    }

    public void setListaDiplomado(List<Diplomado> listaDiplomado) {
        this.listaDiplomado = listaDiplomado;
    }

    public List<Alumno> getListaAlumno() {
        return listaAlumno;
    }

    public void setListaAlumno(List<Alumno> listaAlumno) {
        this.listaAlumno = listaAlumno;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public UploadedFile getFoto() {
        return foto;
    }

    public void setFoto(UploadedFile foto) {
        this.foto = foto;
    }

    public vistaPOJO getPojoV() {
        return pojoV;
    }

    public void setPojoV(vistaPOJO pojoV) {
        this.pojoV = pojoV;
    }

    public VistaFacadeLocal getVistaEjb() {
        return vistaEjb;
    }

    public void setVistaEjb(VistaFacadeLocal vistaEjb) {
        this.vistaEjb = vistaEjb;
    }
    
   
    public void crearUniversidad() {
        try {
            String destination="B:\\Universidad de Cundinamarca\\9 SEMESTRE\\Linea de profundización II\\Universidades\\Universidades\\Universidades-web\\src\\main\\webapp\\img";
            copyFile(file.getFileName(), file.getInputstream(), destination);
            Universidad uni = new Universidad(pojoU.getNombre(), file.getFileName(), pojoU.getExtension(), pojoU.getFundacion());
            Universidad uniTemporal = universidadEjb.buscarNombre(uni.getNombre());
            pojoU.setEscudo(file.getFileName());
            if (uniTemporal != null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atencion", "La universidad " + uniTemporal.getNombre() + " ya existe, pruebe con otra"));
            } else {
                universidadEjb.create(uni);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atencion", "La universidad " + uniTemporal.getNombre() + " ya existe, pruebe con otra"));
        } catch (Exception ex ) {
            System.out.println("error "+ex.getMessage());
            Universidad uni = new Universidad(pojoU.getNombre(),file.getFileName(), pojoU.getExtension(), pojoU.getFundacion());
            universidadEjb.create(uni);
        }
    }

    /**
     * Lista las universidades existentes
     *
     * @return
     */
    public List<Universidad> listaUniversidad() {
        listaUniversidad = universidadEjb.findAll();

        return listaUniversidad;
    }

    public void fileUploadListener(FileUploadEvent event) {
        file = event.getFile();
        System.out.println("subudo");
    }
    public void fileUploadListener2(FileUploadEvent event) {
        foto = event.getFile();
        System.out.println("subudo");
    }
    
    public Boolean copyFile(String fileName, InputStream in, String destination) {
        try {
            OutputStream out = new FileOutputStream(new File(destination + fileName));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            return true;
        } catch (IOException e) {
            System.out.println("Ocurrio un error al momento de guardar el archivo: " + e.getLocalizedMessage());
        }
        return false;
    }
    /**
     * Crear un diplomado
     */
    public void crearDiplomado(){
        int id = pojoD.getIdU();
        Universidad uni = universidadEjb.find(pojoD.getIdU());
        Diplomado dip = new Diplomado(pojoD.getNombre(), pojoD.getFechaInicio(), pojoD.getFechaFin(), pojoD.getDescripcion(), uni);
            diplomadoEjb.create(dip);   
    }
    public List<Universidad> listaDeUniversidad(){
        listaUniversidad = universidadEjb.findAll();
        return listaUniversidad;
    }
    public List<Diplomado> mostrarDiplomado(){
        listaDiplomado = diplomadoEjb.findAll();
        return listaDiplomado;
    }
    public List<Diplomado> listaDeDiplomado(){
        listaDiplomado = diplomadoEjb.findAll();
        return listaDiplomado;
    }

    public List<Vista> getListaVista() {
        return listaVista;
    }

    public void setListaVista(List<Vista> listaVista) {
        this.listaVista = listaVista;
    }
    
    
        /**
     * Crea un estudiante
     */
    public void crearEstudiante(){
        
        Diplomado dip = diplomadoEjb.find(pojoA.getId());
        try
        {
            String destination="B:\\Universidad de Cundinamarca\\9 SEMESTRE\\Linea de profundización II\\Universidades\\Universidades\\Universidades-web\\src\\main\\webapp\\foto";
            copyFile(foto.getFileName(), foto.getInputstream(), destination);
            Alumno est = new Alumno(pojoA.getNombre(),foto.getFileName(),pojoA.getEdad(),dip);
            List<Alumno> estTemporal = alumnoEjb.consultaDiplomado(pojoA.getNombre());
            if(estTemporal.isEmpty()){
                alumnoEjb.create(est);
            }else{
                for(Alumno d:estTemporal){
                    if(d.getNombre().equals(pojoA.getNombre())){
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "No permitido", "El estudiante que usted intenta asignar '"
                        + dip.getNombre() +"', ya existe"));
                        break;
                    }else{
                        alumnoEjb.create(est);
                        break;
                    }
                }
            }

        }catch(Exception e){
            Alumno est = new Alumno(pojoA.getNombre(),foto.getFileName(),pojoA.getEdad(),dip);
            alumnoEjb.create(est);   
        }
    }
    public List<Alumno> listarEstudiante(){
        listaAlumno = alumnoEjb.findAll();
        return listaAlumno;
    }
    
    public List<Vista> generarReporte(){
        try{
            int id = pojoD.getIdU();
            List<Vista> listaAux = vistaEjb.traerReporte(id);
            listaVista.addAll(listaAux);
            return listaVista;
        }catch(Exception e){
            return listaVista;
        }
    }
}
