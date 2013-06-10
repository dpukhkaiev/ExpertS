package ua.kpi.its.dspukhkaiev.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import ua.kpi.its.dspukhkaiev.dao.Subject_Area_Dao;
import ua.kpi.its.dspukhkaiev.model.Subject_Area;

@ManagedBean(name = "indexBean")
@ViewScoped
public class IndexBean {
    @EJB
    private Subject_Area_Dao subject_Area_Dao;
    private List<Subject_Area> subject_Areas;
    private Subject_Area selected_Subject_Area;

    @PostConstruct
    public void init() {
        subject_Areas = subject_Area_Dao.findAll();
        selected_Subject_Area = new Subject_Area();
    }

    public String newArea() {
        subject_Area_Dao.create(selected_Subject_Area);
        return "success";
    }

    public Subject_Area_Dao getSubject_Area_Dao() {
        return subject_Area_Dao;
    }

    public void setSubject_Area_Dao(Subject_Area_Dao subject_Area_Dao) {
        this.subject_Area_Dao = subject_Area_Dao;
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

}
