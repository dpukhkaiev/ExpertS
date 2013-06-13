package ua.kpi.its.dspukhkaiev.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cause
 * 
 */
@Entity
@Table(name = "Cause")
public class Cause implements Serializable {

    @Id
    @Column(name = "idCause", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "probability", nullable = false)
    private double probability;

    @Column(name = "name", nullable = false)
    private double name;

    @OneToMany(mappedBy = "cause", cascade = CascadeType.ALL)
    Set<Rule> rules = new HashSet<Rule>();

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

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public double getName() {
        return name;
    }

    public void setName(double name) {
        this.name = name;
    }

    public Set<Rule> getRules() {
        return rules;
    }

    public void setRules(Set<Rule> rules) {
        this.rules = rules;
    }

}
