package ua.kpi.its.dspukhkaiev.managedbeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ua.kpi.its.dspukhkaiev.dao.AnswerDao;
import ua.kpi.its.dspukhkaiev.dao.QuestionDao;
import ua.kpi.its.dspukhkaiev.dao.RuleDao;
import ua.kpi.its.dspukhkaiev.dao.Subject_Area_Dao;
import ua.kpi.its.dspukhkaiev.model.Answer;
import ua.kpi.its.dspukhkaiev.model.Question;
import ua.kpi.its.dspukhkaiev.model.Rule;
import ua.kpi.its.dspukhkaiev.model.Subject_Area;

@ManagedBean(name = "areaBean")
@ViewScoped
public class AreaBean {

    @EJB
    private QuestionDao questionDao;
    @EJB
    private AnswerDao answerDao;
    @EJB
    private RuleDao ruleDao;
    @EJB
    private Subject_Area_Dao subject_Area_Dao;
    private Question question;
    private Answer answer;
    private Rule rule;
    private Subject_Area subject_Area;

    @ManagedProperty(value = "#{indexBean}")
    private IndexBean indexBean;

    private Integer id;

//    public AreaBean() {
//        id = Integer.valueOf(FacesContext.getCurrentInstance()
//                .getExternalContext().getRequestParameterMap().get("id"));
//    }

     @PostConstruct
     public void init() {
     subject_Area = indexBean.getSelected_Subject_Area();
    }

    public IndexBean getIndexBean() {
        return indexBean;
    }

    public void setIndexBean(IndexBean indexBean) {
        this.indexBean = indexBean;
    }

    public QuestionDao getQuestionDao() {
        return questionDao;
    }

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public AnswerDao getAnswerDao() {
        return answerDao;
    }

    public void setAnswerDao(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    public RuleDao getRuleDao() {
        return ruleDao;
    }

    public void setRuleDao(RuleDao ruleDao) {
        this.ruleDao = ruleDao;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public Subject_Area_Dao getSubject_Area_Dao() {
        return subject_Area_Dao;
    }

    public void setSubject_Area_Dao(Subject_Area_Dao subject_Area_Dao) {
        this.subject_Area_Dao = subject_Area_Dao;
    }

    public Subject_Area getSubject_Area() {
        return subject_Area;
    }

    public void setSubject_Area(Subject_Area subject_Area) {
        this.subject_Area = subject_Area;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
