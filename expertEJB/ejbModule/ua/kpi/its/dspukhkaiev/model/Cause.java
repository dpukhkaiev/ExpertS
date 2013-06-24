package ua.kpi.its.dspukhkaiev.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Answer
 * 
 */
@Entity
@Table(name = "Cause")
@NamedQueries({ @NamedQuery(name = "Cause.findAll", query = "SELECT c FROM Cause c") })
public class Cause implements Serializable {
    @Id
    @Column(name = "idCause", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cause", nullable = false)
    private String cause;

    @OneToMany(mappedBy = "cause", cascade = CascadeType.ALL)
    private Set<ProblemAnswerPair> problemAnswerPairs = new HashSet<ProblemAnswerPair>();

    @ManyToOne
    @JoinColumn(name = "Rule_idRule", referencedColumnName = "idRule")
    private Rule rule;

    @Column(name = "probability", nullable = false)
    private double probability = 0;

    private static final long serialVersionUID = 1L;

    public Cause() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<ProblemAnswerPair> getProblemAnswerPairs() {
        return problemAnswerPairs;
    }

    public void setProblemAnswerPairs(Set<ProblemAnswerPair> problemAnswerPairs) {
        this.problemAnswerPairs = problemAnswerPairs;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

}
