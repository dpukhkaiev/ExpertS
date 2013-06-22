package ua.kpi.its.dspukhkaiev.converters;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import ua.kpi.its.dspukhkaiev.managedbeans.AreaBean;
import ua.kpi.its.dspukhkaiev.model.Problem;

@ManagedBean(name = "questionConverterBean")
@ViewScoped
public class QuestionConverter implements Converter {

    @ManagedProperty(value = "#{areaBean}")
    private AreaBean areaBean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
//        Problem problem = areaBean.getProblemDao().findByQuestion(value);
//        if (problem != null)
//            problem.setAnswers(areaBean.getAnswerDao().findAllByProblem(
//                    problem.getId()));
//        return problem;

        if ((value != null) && !value.equals("")
                && !value.equalsIgnoreCase("Select One")) {
            Problem problem = new Problem();
            problem.setQuestion(value);
            for (Problem p : areaBean.getSubject_Area().getProblems()) {
                if (p.getQuestion().equalsIgnoreCase(problem.getQuestion())) {
                    return p;
                }
            }
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
