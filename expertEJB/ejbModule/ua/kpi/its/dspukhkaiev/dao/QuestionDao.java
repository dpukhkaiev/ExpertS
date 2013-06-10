package ua.kpi.its.dspukhkaiev.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ua.kpi.its.dspukhkaiev.model.Question;

@Stateless
@LocalBean
public class QuestionDao implements GenericDao<Question, Integer> {
    
    @PersistenceContext(unitName = "expertEJB")
    EntityManager em;

    @Override
    public Integer create(Question newInstance) {
        em.persist(newInstance);
        return newInstance.getId();
    }

    @Override
    public Question read(Integer id) {
        Question question = em.find(Question.class, id);
        return question;
    }

    @Override
    public void update(Question transientObject) {
        em.merge(transientObject);
    }

}
