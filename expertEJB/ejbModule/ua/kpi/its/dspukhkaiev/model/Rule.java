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
@NamedQueries({ @NamedQuery(name = "Rule.findAll", query = "SELECT r FROM Rule r") })
public class Rule implements Serializable {

    @Id
    @Column(name = "idRule", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "rule", cascade = CascadeType.ALL)
    private Set<Cause> causes = new HashSet<Cause>();

    @Column(name = "probability", nullable = false)
    private double probability;

    private static final long serialVersionUID = 1L;

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

    public Set<Cause> getCauses() {
        return causes;
    }

    public void setCauses(Set<Cause> causes) {
        this.causes = causes;
    }


}
