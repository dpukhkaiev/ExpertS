package ua.kpi.its.dspukhkaiev.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cause
 * 
 */
@Entity
@Table(name = "ProblemAnswerPair")
@NamedQueries({
        @NamedQuery(name = "ProblemAnswerPair.findAll", query = "SELECT pap FROM ProblemAnswerPair pap WHERE pap.cause.id = NULL AND pap.answer.problem.subject_Area.id = :idSubject_Area"),
        @NamedQuery(name = "ProblemAnswerPair.findByCause", query = "SELECT pap FROM ProblemAnswerPair pap WHERE pap.cause.id = :causeId AND pap.answer.problem.subject_Area.id = :idSubject_Area"),
        @NamedQuery(name = "ProblemAnswerPair.findCause", query = "SELECT pap.cause FROM ProblemAnswerPair pap WHERE pap.cause.id <> NULL AND pap.answer.problem.subject_Area.id = :idSubject_Area") })
public class ProblemAnswerPair implements Serializable {

    @Id
    @Column(name = "idProblemAnswerPair", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Answer_idAnswer", referencedColumnName = "idAnswer")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "Cause_idCause", referencedColumnName = "idCause")
    private Cause cause;

    private static final long serialVersionUID = 1L;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Cause getCause() {
        return cause;
    }

    public void setCause(Cause cause) {
        this.cause = cause;
    }

    public ProblemAnswerPair deepClone() {
        ProblemAnswerPair other = new ProblemAnswerPair();
        other.setId(this.id);
        other.setAnswer(this.answer);
        other.setCause(this.cause);
        return other;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProblemAnswerPair other = (ProblemAnswerPair) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
