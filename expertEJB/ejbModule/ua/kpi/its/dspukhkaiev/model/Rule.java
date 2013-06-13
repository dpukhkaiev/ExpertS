package ua.kpi.its.dspukhkaiev.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rule
 * 
 */
@Entity
@Table(name = "Rule")
public class Rule implements Serializable {

    @Id
    @Column(name = "idRule", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Cause_idCause", referencedColumnName = "idCause")
    private Cause cause;

    @ManyToMany
    private Set<Answer> answers = new HashSet<Answer>();

    private static final long serialVersionUID = 1L;

    public Rule() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cause getCause() {
        return cause;
    }

    public void setCause(Cause cause) {
        this.cause = cause;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
    
    

}