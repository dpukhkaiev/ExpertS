package ua.kpi.its.dspukhkaiev.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ua.kpi.its.dspukhkaiev.model.Problem;

@Stateless
@LocalBean
public class ProblemDao implements GenericDao<Problem, Integer> {

    @PersistenceContext(unitName = "expertEJB")
    EntityManager em;

    @Override
    public Integer create(Problem newInstance) {
        em.persist(newInstance);
        return newInstance.getId();
    }

    @Override
    public Problem read(Integer id) {
        Problem problem = em.find(Problem.class, id);
        return problem;
    }

    @Override
    public void update(Problem transientObject) {
        em.merge(transientObject);
    }

    public Set<Problem> findAllBySubjectArea(int id) {
        TypedQuery<Problem> typedQuery = em.createNamedQuery(
                "Problem.findAllBySubjectArea", Problem.class);
        typedQuery.setParameter("id", id);
        List<Problem> results = typedQuery.getResultList();
        Set<Problem> problems = new HashSet<Problem>(results);
        return problems;
    }

}
