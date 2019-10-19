package Controladores;

import Default.AbstractFacade;
import Interfaces.DiplomadoFacadeLocal;
import Entity.Diplomado;
import Entity.Universidad;
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
public class DiplomadoFacade extends AbstractFacade<Diplomado> implements DiplomadoFacadeLocal {
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
     * Invoca objeto Diplomado
     */
    public DiplomadoFacade() {
        super(Diplomado.class);
    }
    /**
     * Â¨Metodo que trae de BD una lista de universidades ya asignadas con un diplomado
     * @param uni
     * @param nombre
     * @return Lista de Diplomados
     */
    @Override
    public List<Diplomado> validaUniversidadAsignada(Universidad uni, String nombre) {
        TypedQuery<Diplomado> consulta = em.createNamedQuery("buscarUniversidadAsignada",Diplomado.class);
        consulta.setParameter("nombre", nombre);
        List<Diplomado> lista = consulta.getResultList();
        return consulta.getResultList();
    }
}
