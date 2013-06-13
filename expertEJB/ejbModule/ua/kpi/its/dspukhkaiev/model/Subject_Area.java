package ua.kpi.its.dspukhkaiev.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Subject_Area
 * 
 */
@Entity
@Table(name = "Subject_Area")
@NamedQueries({ @NamedQuery(name = "Subject_Area.findAll", query = "SELECT sa FROM Subject_Area sa") })
public class Subject_Area implements Serializable {

    @Id
    @Column(name = "idSubject_Area", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "subject_Area", cascade = CascadeType.ALL)
    private Set<Problem> problems = new HashSet<Problem>();

    private static final long serialVersionUID = 1L;

    public Subject_Area() {
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

    public Set<Problem> getProblems() {
        return problems;
    }

    public void setProblems(Set<Problem> problems) {
        this.problems = problems;
    }

}
