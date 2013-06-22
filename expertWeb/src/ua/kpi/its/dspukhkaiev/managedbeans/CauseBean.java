package ua.kpi.its.dspukhkaiev.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.selectmanycheckbox.SelectManyCheckbox;

import ua.kpi.its.dspukhkaiev.dao.CauseDao;
import ua.kpi.its.dspukhkaiev.dao.ProblemAnswerPairDao;
import ua.kpi.its.dspukhkaiev.dao.ProblemDao;
import ua.kpi.its.dspukhkaiev.dao.SubjectAreaDao;
import ua.kpi.its.dspukhkaiev.model.Cause;
import ua.kpi.its.dspukhkaiev.model.ProblemAnswerPair;
import ua.kpi.its.dspukhkaiev.model.Subject_Area;

@ManagedBean(name = "causeBean")
@ViewScoped
public class CauseBean {
    @EJB
    private SubjectAreaDao subjectAreaDao;
    @EJB
    private ProblemDao problemDao;
    @EJB
    private CauseDao causeDao;
    @EJB
    private ProblemAnswerPairDao problemAnswerPairDao;
    private List<Cause> causes;
    private Cause selectedCause;
    private Cause newCause;
    private ProblemAnswerPair selectedProblemAnswerPair;
    private List<ProblemAnswerPair> selectedProblemAnswerPairs;
    private List<ProblemAnswerPair> problemAnswerPairs;

    private List<Subject_Area> subject_Areas;
    private Subject_Area selected_Subject_Area;
    private Subject_Area new_Subject_Area;

    @PostConstruct
    public void init() {
        causes = causeDao.findAll();
        selectedCause = new Cause();
        newCause = new Cause();
        problemAnswerPairs = problemAnswerPairDao.findAll();
        selectedProblemAnswerPairs = new ArrayList<ProblemAnswerPair>();
        selectedProblemAnswerPair = new ProblemAnswerPair();

        // subject_Areas = subjectAreaDao.findAll();
        // selected_Subject_Area = new Subject_Area();
        // new_Subject_Area = new Subject_Area();
    }

    public String newArea() {
        subjectAreaDao.create(new_Subject_Area);
        subject_Areas.add(new_Subject_Area);
        new_Subject_Area = new Subject_Area();
        return "success";
    }

    public String newCause() {
        causeDao.create(newCause);
        for (ProblemAnswerPair pap : selectedProblemAnswerPairs) {

            pap.setCause(newCause);
            if (problemAnswerPairDao.read(pap.getId()).getCause() == null) {
                problemAnswerPairDao.update(pap);
            } else {
                ProblemAnswerPair tempPair = pap;
                tempPair.setId(0);
                problemAnswerPairDao.create(tempPair);
            }
        }
        return "success";
    }

    public void viewCause(Cause cause) {
        selectedCause = cause;
        List<ProblemAnswerPair> problemAnswerPairs = problemAnswerPairDao
                .findByCause(selectedCause.getId());
        for (ProblemAnswerPair pap : problemAnswerPairs) {
            selectedProblemAnswerPairs.add(pap);
            if (this.problemAnswerPairs.contains(pap)) {

                // this.problemAnswerPairs.remove(pap);
            }
        }
    }

    public void editCause() {
        for (ProblemAnswerPair pap : selectedProblemAnswerPairs) {
            pap.setCause(selectedCause);
            if (problemAnswerPairDao.read(pap.getId()).getCause() == null) {
                problemAnswerPairDao.update(pap);
            } else {
                ProblemAnswerPair tempPair = pap;
                tempPair.setId(0);
                problemAnswerPairDao.create(tempPair);
            }
        }
    }

    public SubjectAreaDao getSubject_Area_Dao() {
        return subjectAreaDao;
    }

    public void setSubject_Area_Dao(SubjectAreaDao subjectAreaDao) {
        this.subjectAreaDao = subjectAreaDao;
    }

    public List<Subject_Area> getSubject_Areas() {
        return subject_Areas;
    }

    public void setSubject_Areas(List<Subject_Area> subject_Areas) {
        this.subject_Areas = subject_Areas;
    }

    public Subject_Area getSelected_Subject_Area() {
        return selected_Subject_Area;
    }

    public void setSelected_Subject_Area(Subject_Area selected_Subject_Area) {
        this.selected_Subject_Area = selected_Subject_Area;
    }

    public Subject_Area getNew_Subject_Area() {
        return new_Subject_Area;
    }

    public void setNew_Subject_Area(Subject_Area new_Subject_Area) {
        this.new_Subject_Area = new_Subject_Area;
    }

    public SubjectAreaDao getSubjectAreaDao() {
        return subjectAreaDao;
    }

    public void setSubjectAreaDao(SubjectAreaDao subjectAreaDao) {
        this.subjectAreaDao = subjectAreaDao;
    }

    public ProblemDao getProblemDao() {
        return problemDao;
    }

    public void setProblemDao(ProblemDao problemDao) {
        this.problemDao = problemDao;
    }

    public CauseDao getCauseDao() {
        return causeDao;
    }

    public void setCauseDao(CauseDao causeDao) {
        this.causeDao = causeDao;
    }

    public ProblemAnswerPairDao getProblemAnswerPairDao() {
        return problemAnswerPairDao;
    }

    public void setProblemAnswerPairDao(
            ProblemAnswerPairDao problemAnswerPairDao) {
        this.problemAnswerPairDao = problemAnswerPairDao;
    }

    public List<Cause> getCauses() {
        return causes;
    }

    public void setCauses(List<Cause> causes) {
        this.causes = causes;
    }

    public Cause getSelectedCause() {
        return selectedCause;
    }

    public void setSelectedCause(Cause selectedCause) {
        this.selectedCause = selectedCause;
    }

    public Cause getNewCause() {
        return newCause;
    }

    public void setNewCause(Cause newCause) {
        this.newCause = newCause;
    }

    public ProblemAnswerPair getSelectedProblemAnswerPair() {
        return selectedProblemAnswerPair;
    }

    public void setSelectedProblemAnswerPair(
            ProblemAnswerPair selectedProblemAnswerPair) {
        this.selectedProblemAnswerPair = selectedProblemAnswerPair;
    }

    public List<ProblemAnswerPair> getSelectedProblemAnswerPairs() {
        return selectedProblemAnswerPairs;
    }

    public void setSelectedProblemAnswerPairs(
            List<ProblemAnswerPair> selectedProblemAnswerPairs) {
        this.selectedProblemAnswerPairs = selectedProblemAnswerPairs;
    }

    public List<ProblemAnswerPair> getProblemAnswerPairs() {
        return problemAnswerPairs;
    }

    public void setProblemAnswerPairs(List<ProblemAnswerPair> problemAnswerPairs) {
        this.problemAnswerPairs = problemAnswerPairs;
    }

}