package be.intecbrussel.models.registration;

import be.intecbrussel.models.enums.RaceType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ScheduledRace {
    @Id
    @GeneratedValue
    Long id;
    String location;
    String date;
    Integer number;
    RaceType raceType;
    String customedRace;
    Double coefficientGender;
    Double coefficientCategory;
    @OneToMany
    List<Team> teams;

    public ScheduledRace() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public RaceType getRaceType() {
        return raceType;
    }

    public void setRaceType(RaceType raceType) {
        this.raceType = raceType;
    }

    public String getCustomedRace() {
        return customedRace;
    }

    public void setCustomedRace(String customedRace) {
        this.customedRace = customedRace;
    }

    public Double getCoefficientGender() {
        return coefficientGender;
    }

    public void setCoefficientGender(Double coefficientGender) {
        this.coefficientGender = coefficientGender;
    }

    public Double getCoefficientCategory() {
        return coefficientCategory;
    }

    public void setCoefficientCategory(Double coefficientCategory) {
        this.coefficientCategory = coefficientCategory;
    }

    //Override methods////////////////////////////
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof ScheduledRace)) return false;
        return id != null && id.equals(((ScheduledRace)o).getId());
    }
    @Override
    public int hashCode() {
        return (int) (31* getId());
    }

    @Override
    public String toString() {
        return "ScheduledRace{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", number=" + number +
                ", raceType=" + raceType +
                ", customedRace='" + customedRace + '\'' +
                ", coefficientGender=" + coefficientGender +
                ", coefficientCategory=" + coefficientCategory +
                '}';
    }
}
