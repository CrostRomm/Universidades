package Default;

import java.util.List;
import javax.persistence.EntityManager;

/**
 * @author Cristian Romero
 * @author Nathaly Salazar
 */
public abstract class AbstractFacadeV<T> {
    /**
     * Declara EM
     */
    private Class<T> entityClass;
    /**
     * Invoca EM
     * @param entityClass 
     */
    public AbstractFacadeV(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    /**
     * Obtiene EM
     * @return 
     */
    protected abstract EntityManager getEntityManager();
    /**
     * Metodo crear por defecto
     * @param entity 
     */
    public void create(T entity) {
        getEntityManager().persist(entity);
    }
    /**
     * Metodo editar por defecto
     * @param entity 
     */
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }
    /**
     * Metodo eliminar por defecto
     * @param entity 
     */
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }
    /**
     * Metodo de busqueda que retorna un objeto
     * @param id
     * @return 
     */
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }
    /**
     * Busqueda que retorna una lisra
     * @return 
     */
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    /**
     * Bsuqueda de rango
     * @param range
     * @return 
     */
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }
    /**
     * busqueda con contador
     * @return 
     */
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
