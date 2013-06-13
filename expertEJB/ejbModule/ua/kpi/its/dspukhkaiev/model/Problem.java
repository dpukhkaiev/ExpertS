package ua.kpi.its.dspukhkaiev.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Question
 * 
 */
@Entity
@Table(name = "Problem")
@NamedQueries({ @NamedQuery(name = "Problem.findAllBySubjectArea", query = "SELECT p FROM Problem p WHERE p.subject_Area.id = :id") })
public class Problem implements Serializable {

    @Id
    @Column(name = "idProblem", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "question", nullable = false)
    private String question;

    @ManyToOne
    @JoinColumn(name = "Subject_Area_idSubject_Area")
    private Subject_Area subject_Area;

    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL)
    private Set<Answer> answers = new HashSet<Answer>();

    private static final long serialVersionUID = 1L;

    public Problem() {
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

    public Subject_Area getSubject_Area() {
        return subject_Area;
    }

    public void setSubject_Area(Subject_Area subject_Area) {
        this.subject_Area = subject_Area;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
