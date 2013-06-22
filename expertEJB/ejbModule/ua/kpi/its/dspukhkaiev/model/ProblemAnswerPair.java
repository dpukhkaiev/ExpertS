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
        @NamedQuery(name = "ProblemAnswerPair.findAll", query = "SELECT pap FROM ProblemAnswerPair pap"),
        @NamedQuery(name = "ProblemAnswerPair.findByCause", query = "SELECT pap FROM ProblemAnswerPair pap WHERE pap.cause.id = :causeId") })
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

}
