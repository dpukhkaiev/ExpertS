package ua.kpi.its.dspukhkaiev.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ua.kpi.its.dspukhkaiev.model.Subject_Area;

@Stateless
@LocalBean
public class Subject_Area_Dao implements GenericDao<Subject_Area, Integer> {
    @PersistenceContext(unitName = "expertEJB")
    EntityManager em;

    @Override
    public Integer create(Subject_Area newInstance) {
        em.persist(newInstance);
        return newInstance.getId();
    }

    @Override
    public Subject_Area read(Integer id) {
        Subject_Area subject_Area = em.find(Subject_Area.class, id);
        return subject_Area;
    }

    @Override
    public void update(Subject_Area transientObject) {
        em.merge(transientObject);
    }

    public List<Subject_Area> findAll() {
        TypedQuery<Subject_Area> query = em.createNamedQuery(
                "Subject_Area.findAll", Subject_Area.class);
        List<Subject_Area> results = query.getResultList();
        return results;
    }

}
