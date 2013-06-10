package ua.kpi.its.dspukhkaiev.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
