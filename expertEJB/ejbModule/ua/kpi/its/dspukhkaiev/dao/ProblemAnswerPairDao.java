package ua.kpi.its.dspukhkaiev.dao;

import java.util.HashSet;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ua.kpi.its.dspukhkaiev.model.Answer;
import ua.kpi.its.dspukhkaiev.model.Cause;
import ua.kpi.its.dspukhkaiev.model.ProblemAnswerPair;
import ua.kpi.its.dspukhkaiev.model.Subject_Area;

@Stateless
@LocalBean
public class ProblemAnswerPairDao implements
        GenericDao<ProblemAnswerPair, Integer> {

    @PersistenceContext(unitName = "expertEJB")
    EntityManager em;

    @Override
    public Integer create(ProblemAnswerPair newInstance) {
        em.persist(newInstance);
        return newInstance.getId();
    }

    @Override
    public ProblemAnswerPair read(Integer id) {
        ProblemAnswerPair cause = em.find(ProblemAnswerPair.class, id);
        return cause;
    }

    @Override
    public void update(ProblemAnswerPair transientObject) {
        em.merge(transientObject);
    }

    public List<ProblemAnswerPair> findAll(int idSA) {
        TypedQuery<ProblemAnswerPair> query = em.createNamedQuery(
                "ProblemAnswerPair.findAll", ProblemAnswerPair.class);
        query.setParameter("idSubject_Area", idSA);
        List<ProblemAnswerPair> results = query.getResultList();
        return results;
    }

    public List<ProblemAnswerPair> findByCause(int id, int idSA) {
        TypedQuery<ProblemAnswerPair> typedQuery = em.createNamedQuery(
                "ProblemAnswerPair.findByCause", ProblemAnswerPair.class);
        typedQuery.setParameter("causeId", id);
        typedQuery.setParameter("idSubject_Area", idSA);
        List<ProblemAnswerPair> results = typedQuery.getResultList();
        return results;
    }

    public List<Cause> findCause(int idSA) {
        TypedQuery<Cause> typedQuery = em.createNamedQuery(
                "ProblemAnswerPair.findCause", Cause.class);
        typedQuery.setParameter("idSubject_Area", idSA);
        List<Cause> results = typedQuery.getResultList();
        return results;
    }

}
