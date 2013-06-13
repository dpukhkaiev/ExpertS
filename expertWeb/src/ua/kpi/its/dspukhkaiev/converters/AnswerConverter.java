package ua.kpi.its.dspukhkaiev.converters;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import ua.kpi.its.dspukhkaiev.managedbeans.AreaBean;
import ua.kpi.its.dspukhkaiev.model.Answer;

@ManagedBean(name = "answerConverterBean")
@RequestScoped
public class AnswerConverter implements Converter {

    @ManagedProperty(value = "#{areaBean}")
    private AreaBean areaBean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        Answer answer = new Answer();
        answer.setName(value);
        for (Answer a : areaBean.getSelectedProblem().getAnswers()) {
            if (a.getName().equalsIgnoreCase(answer.getName())) {
                return a;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        if (value instanceof Answer) {
            return ((Answer) value).getName();
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
