package ua.kpi.its.dspukhkaiev.managedbeans;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ua.kpi.its.dspukhkaiev.dao.AnswerDao;
import ua.kpi.its.dspukhkaiev.dao.CauseDao;
import ua.kpi.its.dspukhkaiev.dao.ProblemAnswerPairDao;
import ua.kpi.its.dspukhkaiev.dao.ProblemDao;
import ua.kpi.its.dspukhkaiev.model.Answer;
import ua.kpi.its.dspukhkaiev.model.Cause;
import ua.kpi.its.dspukhkaiev.model.Problem;
import ua.kpi.its.dspukhkaiev.model.ProblemAnswerPair;
import ua.kpi.its.dspukhkaiev.model.Rule;
import ua.kpi.its.dspukhkaiev.model.Subject_Area;

@ManagedBean(name = "terminalController")
@ViewScoped
public class TerminalController {

    @EJB
    private ProblemDao problemDao;
    @EJB
    private AnswerDao answerDao;
    @EJB
    private CauseDao causeDao;
    @EJB
    private ProblemAnswerPairDao problemAnswerPairDao;

    private ArrayList<Problem> problems;
    private ArrayList<Answer> answers;
    private int currentProblem;
    private ArrayList<Answer> selectedAnswers;
    private List<Cause> causes;
    private Rule rule;

    @ManagedProperty(value = "#{indexBean}")
    private IndexBean indexBean;

    @PostConstruct
    public void init() {

        problems = new ArrayList<>(problemDao.findAllBySubjectArea(indexBean
                .getSelected_Subject_Area().getId()));
        currentProblem = 0;
        selectedAnswers = new ArrayList<Answer>();
        causes = causeDao.findAll();
        rule = new Rule();
        for (Cause c : causes) {
            c.setProblemAnswerPairs(new HashSet<ProblemAnswerPair>(
                    problemAnswerPairDao.findByCause(c.getId(), indexBean
                            .getSelected_Subject_Area().getId())));
        }

    }

    public String handleCommand(String command, String[] params) {
        if (command.equals("y"))
            return provideQuestion(currentProblem);
        if (command.equals("a")) {
            extractAnswer(params[0]);
            return provideQuestion(currentProblem);
        }
        if (command.equals("finish")) {
            return causeAnalysis();
        } else
            return command + " not found";
    }

    private String provideQuestion(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(problems.get(num).getQuestion());
        answers = new ArrayList<>(answerDao.findAllByProblem(problems.get(num)
                .getId()));

        for (int i = 0; i < answers.size(); i++) {
            sb.append("\n");
            sb.append(answers.get(i).getName());
            sb.append(" (" + (i + 1) + ")");
        }
        currentProblem += 1;
        return sb.toString();
    }

    private void extractAnswer(String answerNumber) {
        selectedAnswers.add(answers.get(Integer.parseInt(answerNumber) - 1));// *
    }

    private String showAnswers() {
        StringBuilder sb = new StringBuilder();
        for (Answer a : selectedAnswers) {
            sb.append(a.getName());
            sb.append(" \n");
        }
        return sb.toString();
    }

    private String causeAnalysis() {
        double probability = 0;
        for (Cause c : causes) {
            for (ProblemAnswerPair pap : c.getProblemAnswerPairs()) {
                double append = c.getProblemAnswerPairs().size();
                if (selectedAnswers.contains(pap.getAnswer())) {
                    probability += 1 / append;
                    c.setProbability(probability);
                }
            }
            causeDao.update(c);
            probability = 0;
        }
        StringBuilder sb = new StringBuilder();
        for (Cause c : causes) {

            sb.append(c.getId());
            sb.append(" The cause is: ");
            sb.append(c.getCause());
            sb.append(" with probability: ");
            sb.append(new DecimalFormat("#.##").format(c.getProbability()));
            sb.append("!");
        }
        return sb.toString();
    }

    public ProblemDao getProblemDao() {
        return problemDao;
    }

    public void setProblemDao(ProblemDao problemDao) {
        this.problemDao = problemDao;
    }

    public int getCurrentProblem() {
        return currentProblem;
    }

    public void setCurrentProblem(int currentProblem) {
        this.currentProblem = currentProblem;
    }

    public IndexBean getIndexBean() {
        return indexBean;
    }

    public void setIndexBean(IndexBean indexBean) {
        this.indexBean = indexBean;
    }

    public AnswerDao getAnswerDao() {
        return answerDao;
    }

    public void setAnswerDao(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    public ArrayList<Problem> getProblems() {
        return problems;
    }

    public void setProblems(ArrayList<Problem> problems) {
        this.problems = problems;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

}
