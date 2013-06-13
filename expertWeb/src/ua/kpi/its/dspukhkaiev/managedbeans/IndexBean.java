package ua.kpi.its.dspukhkaiev.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ua.kpi.its.dspukhkaiev.dao.ProblemDao;
import ua.kpi.its.dspukhkaiev.dao.SubjectAreaDao;
import ua.kpi.its.dspukhkaiev.model.Subject_Area;

@ManagedBean(name = "indexBean")
@SessionScoped
public class IndexBean {
    @EJB
    private SubjectAreaDao subjectAreaDao;
    @EJB
    private ProblemDao problemDao;
    private List<Subject_Area> subject_Areas;
    private Subject_Area selected_Subject_Area;
    private Subject_Area new_Subject_Area;

    @PostConstruct
    public void init() {
        subject_Areas = subjectAreaDao.findAll();
        selected_Subject_Area = new Subject_Area();
        new_Subject_Area = new Subject_Area();
    }

    public String newArea() {
        subjectAreaDao.create(new_Subject_Area);
        subject_Areas.add(new_Subject_Area);
        new_Subject_Area = new Subject_Area();
        return "success";
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

}
