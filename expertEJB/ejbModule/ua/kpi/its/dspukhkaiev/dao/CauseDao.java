package ua.kpi.its.dspukhkaiev.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ua.kpi.its.dspukhkaiev.model.Cause;

@Stateless
@LocalBean
public class CauseDao implements GenericDao<Cause, Integer> {
    @PersistenceContext(unitName = "expertEJB")
    EntityManager em;

    @Override
    public Integer create(Cause newInstance) {
        em.persist(newInstance);
        return newInstance.getId();
    }

    @Override
    public Cause read(Integer id) {
        Cause cause = em.find(Cause.class, id);
        return cause;
    }

    @Override
    public void update(Cause transientObject) {
        em.merge(transientObject);
    }

    public List<Cause> findAll() {
        TypedQuery<Cause> query = em.createNamedQuery("Cause.findAll",
                Cause.class);
        List<Cause> results = query.getResultList();
        return results;
    }
}
