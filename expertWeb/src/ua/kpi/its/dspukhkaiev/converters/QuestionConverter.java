package ua.kpi.its.dspukhkaiev.converters;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import ua.kpi.its.dspukhkaiev.managedbeans.AreaBean;
import ua.kpi.its.dspukhkaiev.model.Problem;

@ManagedBean(name = "questionConverterBean")
@RequestScoped
public class QuestionConverter implements Converter {

    @ManagedProperty(value = "#{areaBean}")
    private AreaBean areaBean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value != null) {
            Problem problem = new Problem();
            problem.setQuestion(value);
            problem.setSubject_Area(areaBean.getSubject_Area());
            return problem;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        if (value instanceof Problem) {
            return ((Problem) value).getQuestion();
        }
        return null;
    }

    public AreaBean getAreaBean() {
        return areaBean;
    }

    public void setAreaBean(AreaBean areaBean) {
        this.areaBean = areaBean;
    }

}
