package be.intecbrussel.models.registration;

import be.intecbrussel.models.enums.RaceType;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
public class ScheduledRace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String location;
    String date;
    Integer number;
    RaceType raceType;
    String customedRace;
    String coefficientGender;
    String coefficientCategory;
    int amountOfTeams;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Team team;

    @Autowired
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

    public String getCoefficientGender() {
        return coefficientGender;
    }

    public void setCoefficientGender(String coefficientGender) {
        this.coefficientGender = coefficientGender;
    }

    public String getCoefficientCategory() {
        return coefficientCategory;
    }

    public void setCoefficientCategory(String coefficientCategory) {
        this.coefficientCategory = coefficientCategory;
    }

    public int getAmountOfTeams() {
        return amountOfTeams;
    }

    public void setAmountOfTeams(int amountOfTeams) {
        this.amountOfTeams = amountOfTeams;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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
        return (int) (41* 11);
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
                ", team=" + team +
                '}';
    }
}
