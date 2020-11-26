package be.intecbrussel.models.competition;

import be.intecbrussel.models.enums.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number;
    private String lastRace;
    //Field calculated
    private String name;
    private String distance;
    private String startingTime;
    private String maxTime;
    private RaceType racetype;
    private String customedRace;
    private Gender gender;
    private RaceExperience raceExperience;
    private RaceImpact raceImpact;
    private Category admissCategory;
    private RowingBoat admissRowingBoat;

    private String description;
    //Part used for registration
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },fetch = FetchType.EAGER)
    private Competition competition;


    @Autowired
    public Race() {

    }
    //getters/setters///////////////////////////////
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }


    public String getLastRace() {
        return lastRace;
    }

    public void setLastRace(String lastRace) {
        this.lastRace = lastRace;
    }

    public String getStartingTime() {
        return startingTime;
    }
    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public void setAdmissCategory(Category admissCategory) {
        this.admissCategory = admissCategory;
    }


    public String getName() {
        return name;
    }
    public void setName() {
        this.name = composeName(racetype.getValue(),customedRace,
                raceExperience.getValue(),admissRowingBoat.getValue(),gender.getValue(),admissCategory.getValue());
    }

    public String getDistance() {
        return distance;
    }
    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getMaxTime() {
        return maxTime;
    }
    public void setMaxTime(String maxTime) {
        this.maxTime = maxTime;
    }

    public RaceType getRacetype() {
        return racetype;
    }
    public void setRacetype(RaceType racetype) {
        this.racetype = racetype;
    }

    public String getCustomedRace() {
        return customedRace;
    }
    public void setCustomedRace(String customedRace) {
        this.customedRace = customedRace;
    }

    public RaceExperience getRaceExperience() {
        return raceExperience;
    }
    public void setRaceExperience(RaceExperience raceExperience) {
        this.raceExperience = raceExperience;
    }

    public RaceImpact getRaceImpact() {
        return raceImpact;
    }
    public void setRaceImpact(RaceImpact raceImpact) {
        this.raceImpact = raceImpact;
    }

    public Category getAdmissCategory() {
        return admissCategory;
    }
    public void setAdmissCategory(String admissCategory) {
        this.admissCategory = Category.findCategory(admissCategory);
    }

    public RowingBoat getAdmissRowingBoat() {
        return admissRowingBoat;
    }
    public void setAdmissRowingBoat(String admissRowingBoat) {
        this.admissRowingBoat = RowingBoat.findBoat(admissRowingBoat);
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Competition getCompetition() {
        return competition;
    }
    public void setCompetition(Competition competition) {
        this.competition = competition;
    }


    //specific methods///////////////////////////////
    public String composeName(String racetype, String customRace, String raceExperience, String rowingBoat,
                              String gender, String category){
        if(customRace==null||customRace.equals("")){
            return racetype+" "+ raceExperience+
                    " "+rowingBoat+" "+category+" "+gender;
        }else{
            return customRace+" "+ raceExperience+
                    " "+rowingBoat+" "+category+" "+gender;
        }

    }

    //override methods///////////////////////////////

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof Race)) return false;
        return id != null && id.equals(((Race)o).getId());
    }
    @Override
    public int hashCode() {
        if(id != null)
            return (int) (41*id);
        return 41;
    }

    @Override
    public String toString() {
        return "Race{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", startingTime='" + startingTime + '\'' +
                '}';
    }
}
