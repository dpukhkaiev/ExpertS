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
@Table(name = "Answer")
public class Answer implements Serializable {
    @Id
    @Column(name = "idAnswer", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "Problem_idProblem", referencedColumnName = "idProblem")
    private Problem problem;

    @ManyToMany(mappedBy = "answers", cascade = CascadeType.ALL)
    private Set<Rule> rules = new HashSet<Rule>();

    private static final long serialVersionUID = 1L;

    public Answer() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Rule> getRules() {
        return rules;
    }

    public void setRules(Set<Rule> rules) {
        this.rules = rules;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

}
