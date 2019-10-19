package Controladores;

import Default.AbstractFacade;
import Interfaces.AlumnoFacadeLocal;
import Entity.Alumno;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * @author Cristian Romero
 * @author Nathaly Salazar
 */
@Stateless
public class AlumnoFacade extends AbstractFacade<Alumno> implements AlumnoFacadeLocal {
    /**
     * Declaracion de EM
     */
    @PersistenceContext(unitName = "persistencia")
    private EntityManager em;
    /**
     * Inicializacion de EM
     * @return 
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    /**
     * Invoca Objeto Alumno
     */
    public AlumnoFacade() {
        super(Alumno.class);
    }
    /**
     * Consulta una lista de estudiantes que ya han sido asignados a un diplomado
     * @param dip
     * @return Lista de estudiantes
     */
    @Override
    public List<Alumno> consultaDiplomado(String dip) {
        TypedQuery<Alumno> consulta = em.createNamedQuery("buscarDiplomadoAsignado",Alumno.class);
        consulta.setParameter("nombre", dip);
        return consulta.getResultList();
    }
}
