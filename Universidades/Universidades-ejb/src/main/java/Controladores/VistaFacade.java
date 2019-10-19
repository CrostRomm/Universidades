package Controladores;

import Interfaces.VistaFacadeLocal;
import Default.AbstractFacadeV;
import Entity.Vista;
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
public class VistaFacade extends AbstractFacadeV<Vista> implements VistaFacadeLocal {
    /**
     * Declaracon de EM
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
     * Invoca el objeto vista
     */
    public VistaFacade() {
        super(Vista.class);
    }
    
    @Override
    public List<Vista> traerReporte(int id) {
        TypedQuery<Vista> consulta = em.createNamedQuery("traeReporte",Vista.class);
        consulta.setParameter("id", id);
        return consulta.getResultList();
    }
}
