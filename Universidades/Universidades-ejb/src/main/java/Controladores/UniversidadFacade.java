package Controladores;

import Default.AbstractFacade;
import Interfaces.UniversidadFacadeLocal;
import Entity.Universidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * @author Cristian Romero
 * @author Nhathaly Salazar
 */
@Stateless
public class UniversidadFacade extends AbstractFacade<Universidad> implements UniversidadFacadeLocal {
    /**
     *Declaracion de EM
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
     * Invoca objeto Universidad
     */
    public UniversidadFacade() {
        super(Universidad.class);
    }
    /**
     * Metodo que valida registrar universidades
     * @param nombre
     * @return 
     */
    @Override
    public Universidad buscarNombre(String nombre){
        TypedQuery<Universidad> consulta = em.createNamedQuery("buscarNombreUniversidad", Universidad.class);
        consulta.setParameter("nombre", nombre);
        return consulta.getSingleResult();
    }
    /**
     * Metodo que ahce una consulta JPQL para buscar una universidad por si ID
     * @param id
     * @return 
     */
    @Override
    public Universidad buscarUniversidad(int id) {
        TypedQuery<Universidad> consulta = em.createNamedQuery("buscarUniversidadId", Universidad.class);
        consulta.setParameter("id", id);
        return consulta.getSingleResult();
    }
}
