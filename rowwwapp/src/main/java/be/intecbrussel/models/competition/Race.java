package be.intecbrussel.models.competition;

import be.intecbrussel.models.enums.*;
import be.intecbrussel.models.registration.Team;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int number;
    private LocalTime startingTime;
    @NotNull(message = "Un nom est requis")
    @Size(min=2, max=30)
    private String name;
    private int distance;
    private int maxTime;
    @NotNull(message = "Ce descripteur est requis")
    private RaceType racetype;
    private String customedRace;
    @NotNull(message = "Ce descripteur est requis")
    private RaceExperience raceExperience;
    @NotNull(message = "Ce descripteur est requis")
    private RaceImpact raceImpact;
    @NotNull(message = "Ce descripteur est requis")
    private Category admissCategory;
    @NotNull(message = "Ce descripteur est requis")
    private RowingBoat admissRowingBoat;
    private String description;
    //Part used for registration
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },fetch = FetchType.LAZY)
    private Competition competition;
    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Team> teams;


    public Race() {
    }
    //getters/setters///////////////////////////////

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalTime startingTime) {
        this.startingTime = startingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(int maxTime) {
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

    public void setAdmissCategory(Category admissCategory) {
        this.admissCategory = admissCategory;
    }

    public RowingBoat getAdmissRowingBoat() {
        return admissRowingBoat;
    }

    public void setAdmissRowingBoat(RowingBoat admissRowingBoat) {
        this.admissRowingBoat = admissRowingBoat;
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

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }



    //specific methods///////////////////////////////
    public String composeName(RaceType racetype, String customRace, RaceExperience raceExperience, RowingBoat rowingBoat,
                              Gender gender, Category category){
        if(this.customedRace!=null&&!this.customedRace.equals("")){
            return this.name + " "+racetype.name()+" "+ raceExperience.name()+
                    " "+rowingBoat.name()+" "+category.name()+" "+gender.name();
        }
        if(this.customedRace!=null &&this.customedRace.length()>=2){
            return this.name + " "+customRace+" "+ raceExperience.name()+
                    " "+rowingBoat.name()+" "+category.name()+" "+gender.name();
        }
        return"";
    }
    public void addTeam(Team team){
        teams.add(team);
        team.setRace(this);
    }
    public void removeTeam(Team team){
        teams.remove(team);
        team.setRace(null);
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
        return (int) (31*getId());
    }
}
