package ua.kpi.its.dspukhkaiev.managedbeans;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.bean.ViewScoped;

import javax.faces.event.AjaxBehaviorEvent;

import ua.kpi.its.dspukhkaiev.dao.AnswerDao;
import ua.kpi.its.dspukhkaiev.dao.CauseDao;
import ua.kpi.its.dspukhkaiev.dao.ProblemAnswerPairDao;
import ua.kpi.its.dspukhkaiev.dao.ProblemDao;
import ua.kpi.its.dspukhkaiev.dao.RuleDao;
import ua.kpi.its.dspukhkaiev.dao.SubjectAreaDao;
import ua.kpi.its.dspukhkaiev.model.Answer;
import ua.kpi.its.dspukhkaiev.model.Cause;
import ua.kpi.its.dspukhkaiev.model.ProblemAnswerPair;
import ua.kpi.its.dspukhkaiev.model.Problem;
import ua.kpi.its.dspukhkaiev.model.Rule;
import ua.kpi.its.dspukhkaiev.model.Subject_Area;

@ManagedBean(name = "areaBean")
@ViewScoped
public class AreaBean {

    @EJB
    private ProblemDao problemDao;
    @EJB
    private AnswerDao answerDao;
    @EJB
    private RuleDao ruleDao;
    @EJB
    private SubjectAreaDao subjectAreaDao;
    @EJB
    private ProblemAnswerPairDao problemAnswerPairDao;
    @EJB
    private CauseDao causeDao;
    private Problem problem;
    private Answer answer;
    private Rule rule;
    private Subject_Area subject_Area;
    private Problem selectedProblem;
    private Answer selectedAnswer;
    private List<Rule> rules;
    private ProblemAnswerPair selectedProblemAnswerPair;
    private ProblemAnswerPair problemAnswerPair;
    private Cause cause;

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
        if (problem == null) {
            problem = new Problem();
            problem.setSubject_Area(subject_Area);
        }
        if (answer == null) {
            answer = new Answer();
        }
        if (selectedProblem == null) {
            selectedProblem = new Problem();
        }
        if (selectedAnswer == null) {
            selectedAnswer = new Answer();
        }
        if (rule == null) {
            rule = new Rule();
        }
        if (rules == null) {
            rules = ruleDao.findAll();
        }
        if (selectedProblemAnswerPair == null) {
            selectedProblemAnswerPair = new ProblemAnswerPair();
        }
        if (problemAnswerPair == null) {
            problemAnswerPair = new ProblemAnswerPair();
        }
        if (cause == null) {
            cause = new Cause();
        }
    }

    public String addProblem() {
        problemDao.create(problem);
        return "success";
    }

    public void addAnswer() {
        answer.setProblem(selectedProblem);
        answerDao.create(answer);
        problemAnswerPair.setAnswer(answerDao.findLast());
        problemAnswerPairDao.create(problemAnswerPair);
        answer = new Answer();
    }

    public void addRule() {
        Set<ProblemAnswerPair> causes = new HashSet<ProblemAnswerPair>();
        causes.add(selectedProblemAnswerPair);
        // rule.setP;
        // rule.setProbability(1.0 / causes.size());
        // ruleDao.create(rule);
    }

    public void changeQSignature(AjaxBehaviorEvent e) {
        if ((selectedProblem != null)
                && !selectedProblem.getQuestion().equals("")
                && !selectedProblem.getQuestion()
                        .equalsIgnoreCase("Select One")) {
            int id = selectedProblem.getId();
            if (id != 0) {
                HashSet<Answer> tempset = answerDao.findAllByProblem(id);
                HashSet<Answer> answers = tempset;
                selectedProblem.setAnswers(answers);
            }
        }
    }

    public void changeASignature(AjaxBehaviorEvent e) {
        if (selectedAnswer != null) {
            answer = selectedAnswer;
        }
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

    public Answer getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(Answer selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public ProblemAnswerPairDao getProblemAnswerPairDao() {
        return problemAnswerPairDao;
    }

    public void setProblemAnswerPairDao(
            ProblemAnswerPairDao problemAnswerPairDao) {
        this.problemAnswerPairDao = problemAnswerPairDao;
    }

    public ProblemAnswerPair getSelectedProblemAnswerPair() {
        return selectedProblemAnswerPair;
    }

    public void setSelectedProblemAnswerPair(
            ProblemAnswerPair selectedProblemAnswerPair) {
        this.selectedProblemAnswerPair = selectedProblemAnswerPair;
    }

    public ProblemAnswerPair getProblemAnswerPair() {
        return problemAnswerPair;
    }

    public void setProblemAnswerPair(ProblemAnswerPair problemAnswerPair) {
        this.problemAnswerPair = problemAnswerPair;
    }

    public CauseDao getCauseDao() {
        return causeDao;
    }

    public void setCauseDao(CauseDao causeDao) {
        this.causeDao = causeDao;
    }

    public Cause getCause() {
        return cause;
    }

    public void setCause(Cause cause) {
        this.cause = cause;
    }

}
