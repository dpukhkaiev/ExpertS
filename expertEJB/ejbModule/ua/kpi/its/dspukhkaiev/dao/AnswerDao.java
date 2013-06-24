package ua.kpi.its.dspukhkaiev.dao;

import java.util.HashSet;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ua.kpi.its.dspukhkaiev.model.Answer;

@Stateless
@LocalBean
public class AnswerDao implements GenericDao<Answer, Integer> {

    @PersistenceContext(unitName = "expertEJB")
    EntityManager em;

    @Override
    public Integer create(Answer newInstance) {
        em.persist(newInstance);
        return newInstance.getId();
    }

    @Override
    public Answer read(Integer id) {
        Answer answer = em.find(Answer.class, id);
        return answer;
    }

    @Override
    public void update(Answer transientObject) {
        em.merge(transientObject);
    }

    public HashSet<Answer> findAllByProblem(int id) {
        TypedQuery<Answer> typedQuery = em.createNamedQuery(
                "Answer.findAllByProblem", Answer.class);
        typedQuery.setParameter("id", id);
        List<Answer> results = typedQuery.getResultList();
        HashSet<Answer> answers = new HashSet<Answer>(results);
        return answers;
    }

    public Answer findLast() {
        TypedQuery<Answer> typedQuery = em.createNamedQuery("Answer.findLast",
                Answer.class);
        typedQuery.setMaxResults(1);
        return typedQuery.getSingleResult();
    }

}
