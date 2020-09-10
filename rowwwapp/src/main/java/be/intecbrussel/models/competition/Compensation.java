package be.intecbrussel.models.competition;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Compensation {
    @Id
    Long id;
    Float coefficient;
    @ManyToOne
    Competition competition;

    public Compensation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Float coefficient) {
        this.coefficient = coefficient;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    //override methods///////////////////////////////
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof Compensation)) return false;
        return id != null && id.equals(((Compensation)o).getId());
    }
    @Override
    public int hashCode() {
        return (int) (31*id);
    }
}
