package ua.kpi.its.dspukhkaiev.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ua.kpi.its.dspukhkaiev.model.Rule;

@Stateless
@LocalBean
public class RuleDao implements GenericDao<Rule, Integer> {

    @PersistenceContext(unitName = "expertEJB")
    EntityManager em;

    @Override
    public Integer create(Rule newInstance) {
        em.persist(newInstance);
        return newInstance.getId();
    }

    @Override
    public Rule read(Integer id) {
        Rule rule = em.find(Rule.class, id);
        return rule;
    }

    @Override
    public void update(Rule transientObject) {
        em.merge(transientObject);
    }

}
