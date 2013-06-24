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
@NamedQueries({
        @NamedQuery(name = "Answer.findAllByProblem", query = "SELECT a FROM Answer a WHERE a.problem.id = :id"),
        @NamedQuery(name = "Answer.findLast", query = "SELECT a FROM Answer a ORDER BY a.id DESC") })
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

    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL)
    private Set<ProblemAnswerPair> problemAnswerPairs = new HashSet<ProblemAnswerPair>();

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

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Set<ProblemAnswerPair> getProblemAnswerPairs() {
        return problemAnswerPairs;
    }

    public void setProblemAnswerPairs(Set<ProblemAnswerPair> problemAnswerPairs) {
        this.problemAnswerPairs = problemAnswerPairs;
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
        Answer other = (Answer) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
