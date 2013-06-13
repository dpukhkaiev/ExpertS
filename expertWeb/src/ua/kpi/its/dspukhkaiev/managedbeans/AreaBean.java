package ua.kpi.its.dspukhkaiev.managedbeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.bean.ViewScoped;

import ua.kpi.its.dspukhkaiev.dao.AnswerDao;
import ua.kpi.its.dspukhkaiev.dao.ProblemDao;
import ua.kpi.its.dspukhkaiev.dao.RuleDao;
import ua.kpi.its.dspukhkaiev.dao.SubjectAreaDao;
import ua.kpi.its.dspukhkaiev.model.Answer;
import ua.kpi.its.dspukhkaiev.model.Problem;
import ua.kpi.its.dspukhkaiev.model.Rule;
import ua.kpi.its.dspukhkaiev.model.Subject_Area;

@ManagedBean(name = "areaBean")
@ViewScoped
public class AreaBean{

    @EJB
    private ProblemDao problemDao;
    @EJB
    private AnswerDao answerDao;
    @EJB
    private RuleDao ruleDao;
    @EJB
    private SubjectAreaDao subjectAreaDao;
    private Problem problem;
    private Answer answer;
    private Rule rule;
    private Subject_Area subject_Area;
    private Problem selectedProblem;

    @ManagedProperty(value = "#{navigationController}")
    private NavigationController navigationController;

    @ManagedProperty(value = "#{indexBean}")
    private IndexBean indexBean;

    private Integer id;

    // public AreaBean() {
    // id = Integer.valueOf(FacesContext.getCurrentInstance()
    // .getExternalContext().getRequestParameterMap().get("id"));
    // }

    @PostConstruct
    public void init() {
        subject_Area = indexBean.getSelected_Subject_Area();
        subject_Area.setProblems(problemDao.findAllBySubjectArea(subject_Area
                .getId()));
        problem = new Problem();
        problem.setSubject_Area(subject_Area);
        answer = new Answer();
        selectedProblem = new Problem();
    }

    public String addProblem() {
        problemDao.create(problem);
        return "success";
    }

    public String addAnswer() {
        answer.setProblem(selectedProblem);
        answerDao.create(answer);
        return "success";
    }

    public IndexBean getIndexBean() {
        return indexBean;
    }

    public void setIndexBean(IndexBean indexBean) {
        this.indexBean = indexBean;
    }

    public ProblemDao getProblemDao() {
        return problemDao;
    }

    public void setProblemDao(ProblemDao problemDao) {
        this.problemDao = problemDao;
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

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
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

    public SubjectAreaDao getSubject_Area_Dao() {
        return subjectAreaDao;
    }

    public void setSubject_Area_Dao(SubjectAreaDao subjectAreaDao) {
        this.subjectAreaDao = subjectAreaDao;
    }

    public Subject_Area getSubject_Area() {
        return subject_Area;
    }

    public void setSubject_Area(Subject_Area subject_Area) {
        this.subject_Area = subject_Area;
    }

    public NavigationController getNavigationController() {
        return navigationController;
    }

    public void setNavigationController(
            NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SubjectAreaDao getSubjectAreaDao() {
        return subjectAreaDao;
    }

    public void setSubjectAreaDao(SubjectAreaDao subjectAreaDao) {
        this.subjectAreaDao = subjectAreaDao;
    }

    public Problem getSelectedProblem() {
        return selectedProblem;
    }

    public void setSelectedProblem(Problem selectedProblem) {
        this.selectedProblem = selectedProblem;
    }

}
