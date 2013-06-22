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
import ua.kpi.its.dspukhkaiev.managedbeans.CauseBean;
import ua.kpi.its.dspukhkaiev.model.Answer;
import ua.kpi.its.dspukhkaiev.model.Problem;
import ua.kpi.its.dspukhkaiev.model.ProblemAnswerPair;

@ManagedBean(name = "problemAnswerPairConverterBean")
@ViewScoped
public class ProblemAnswerPairConverter implements Converter {

    @ManagedProperty(value = "#{causeBean}")
    private CauseBean causeBean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        String[] pap = value.split(" - ");
        Answer answer = new Answer();
        Problem problem = new Problem();
        problem.setQuestion(pap[0]);
        answer.setName(pap[pap.length - 1]);
        answer.setProblem(problem);

        for (ProblemAnswerPair p : causeBean.getProblemAnswerPairs()) {
            if ((p.getAnswer().getName().equals(answer.getName()) && (p
                    .getAnswer().getProblem().getQuestion().equals(answer
                    .getProblem().getQuestion())))) {
                return p;
            }
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        if (value instanceof ProblemAnswerPair) {
            StringBuilder sb = new StringBuilder(((ProblemAnswerPair) value)
                    .getAnswer().getProblem().getQuestion());
            sb.append(" - ");
            sb.append(((ProblemAnswerPair) value).getAnswer().getName());
            return sb.toString();
        }
        return null;
    }

    public CauseBean getCauseBean() {
        return causeBean;
    }

    public void setCauseBean(CauseBean causeBean) {
        this.causeBean = causeBean;
    }

}
