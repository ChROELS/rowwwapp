package be.intecbrussel.models.competition;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private String placeOfEvent;

    private String date;

    private String registrationRules;

    private String registrationContact;

    private String registrationCost;

    private String registrationLimit;

    private String lotteryDate;

    private String lotteryRules;

    private String lotteryContact;

    private String forfeitLimitHour;

    private String forfeitLimit;

    private String forfeitRules;

    private String forfeitContact;

    private String complementaryRules;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Race> races;

    @Autowired
    public Competition() {
        this.races = new ArrayList<>();
    }



    //getters/setters///////////////////////////////

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlaceOfEvent() {
        return placeOfEvent;
    }
    public void setPlaceOfEvent(String placeOfEvent) {
        this.placeOfEvent = placeOfEvent;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getRegistrationRules() {
        return registrationRules;
    }
    public void setRegistrationRules(String registrationRules) {
        this.registrationRules = registrationRules;
    }

    public String getRegistrationContact() {
        return registrationContact;
    }
    public void setRegistrationContact(String registrationContact) {
        registrationContact = registrationContact;
    }

    public String getRegistrationCost() {
        return registrationCost;
    }
    public void setRegistrationCost(String registrationCost) {
        this.registrationCost = registrationCost;
    }

    public String getLotteryRules() {
        return lotteryRules;
    }
    public void setLotteryRules(String lotteryRules) {
        this.lotteryRules = lotteryRules;
    }

    public String getLotteryContact() {
        return lotteryContact;
    }
    public void setLotteryContact(String lotteryContact) {
        this.lotteryContact = lotteryContact;
    }

    public String getForfeitLimitHour() {
        return forfeitLimitHour;
    }
    public void setForfeitLimitHour(String forfeitLimitHour) {
        this.forfeitLimitHour = forfeitLimitHour;
    }

    public String getForfeitLimit() {
        return forfeitLimit;
    }
    public void setForfeitLimit(String forfeitLimit) {
        this.forfeitLimit = forfeitLimit;
    }

    public String getForfeitRules() {
        return forfeitRules;
    }
    public void setForfeitRules(String forfeitRules) {
        this.forfeitRules = forfeitRules;
    }

    public String getForfeitContact() {
        return forfeitContact;
    }
    public void setForfeitContact(String forfeitContact) {
        this.forfeitContact = forfeitContact;
    }

    public List<Race> getRaces() {
        return races;
    }
    public void setRaces(List<Race> races) {
        this.races = races;
    }

    public String getComplementaryRules() {
        return complementaryRules;
    }
    public void setComplementaryRules(String complementaryRules) {
        this.complementaryRules = complementaryRules;
    }

    public String getRegistrationLimit() {
        return registrationLimit;
    }
    public void setRegistrationLimit(String registrationLimit) {
        this.registrationLimit = registrationLimit;
    }

    public String getLotteryDate() {
        return lotteryDate;
    }
    public void setLotteryDate(String lotteryDate) {
        this.lotteryDate = lotteryDate;
    }


    //specific methods///////////////////////////////
    public void addRace(Race race){
        races.add(race);
        race.setCompetition(this);
    }
    public void removeRace(Race race){
        races.remove(race);
        race.setCompetition(null);
    }

    public Date dateConvertor(String dateInput){
        return Date.valueOf(dateInput);
    }

    //override methods///////////////////////////////
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof Competition)) return false;
        return id != null && id.equals(((Competition)o).getId());
    }
    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", placeOfEvent='" + placeOfEvent + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
