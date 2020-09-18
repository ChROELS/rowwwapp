package be.intecbrussel.models.registration;


import be.intecbrussel.models.competition.Race;
import be.intecbrussel.models.enums.RowingBoat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.*;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Un nom est requis")
    @Size(min=2, max=30)
    private String name;
    private RowingBoat type;
    private int sizeOfCrew;
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    private ScheduledRace race;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rower> crew;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Rower cox;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Rower stroke;
    private float teamHandicap;

    //Constructor///////////////////
    public Team() {
        name="Three men in a boat";
        type=RowingBoat.TRIPLE_SCULL_3X;
        sizeOfCrew=3;
        teamHandicap=0.3f;
        crew=new ArrayList<>();
    }
    //Getters and setters//////////

    public ScheduledRace getRace() {
        return race;
    }

    public void setRace(ScheduledRace race) {
        this.race = race;
    }

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

    public int getSizeOfCrew() {
        return sizeOfCrew;
    }

    public void setSizeOfCrew(int sizeOfCrew) {
        this.sizeOfCrew = this.crew.size();
    }

    public List<Rower> getCrew() {
        return crew;
    }

    public void setCrew(List<Rower> crew) {
        this.crew = crew;
    }

    public Rower getCox() {
        return cox;
    }

    public void setCox(Rower cox) {
        this.cox = cox;
    }

    public Rower getStroke() {
        return stroke;
    }

    public void setStroke(Rower stroke) {
        this.stroke = stroke;
    }

    public RowingBoat getType() {
        return type;
    }

    public void setType(RowingBoat type) {
        this.type = type;
    }

    public float getTeamHandicap() {
        return teamHandicap;
    }

    public void setTeamHandicap(float teamHandicap) {
        this.teamHandicap = calculateTeamHandicap(this.crew);
    }
    //specific methods///////////////////////////////
    public float calculateTeamHandicap(List<Rower> crew){
        float eachRowerHandicap = 0.0f;
        List<Float> sumOfRowerHandicap = new ArrayList<>();
        float totalOfRowerHandicap = 0.0f;
        for (Rower r: crew
        ) {
            eachRowerHandicap = r.getRowerHandicap();
            sumOfRowerHandicap.add(eachRowerHandicap);
        }
        Optional<Float> totalOfCrewHandicap = sumOfRowerHandicap.stream().reduce(Float::sum);
        if(totalOfCrewHandicap.isPresent()){
            totalOfRowerHandicap = totalOfCrewHandicap.get();
        }
        return totalOfRowerHandicap/sizeOfCrew;
    }
   public String getListCrewMembers(List<Rower> rowers){
        Map<Integer,String> crewNames = new TreeMap<>();
        String firstName= "";
        String lastName="";
        String name="";
        int i=0;
       for (Rower r: crew
            ) {
           firstName = r.getFirstName();
                   lastName = r.getLastName();
                           name=String.format("%s %s",firstName,lastName);
           crewNames.put(++i,name);
       }
        return crewNames.values().stream().sorted().reduce((crewMember, output) -> output+" "+crewMember).isPresent()?
                crewNames.values().stream().sorted().reduce((crewMember, output) -> output+" "+crewMember).get():"-";
   }
    public void addRower(Rower rower){
        crew.add(rower);
        rower.setTeam(this);
    }
    public void removeRower(Rower rower){
        crew.remove(rower);
        rower.setTeam(null);
    }
    //Override methods////////////////////////////
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof Team)) return false;
        return id != null && id.equals(((Team)o).getId());
    }
    @Override
    public int hashCode() {
        return (int) (31* getId());
    }

    @Override
    public String toString() {
        return "Team " +
                "id=" + id + "\n" +
                ", name=" + name + "\n" +
                ", sizeOfCrew=" + sizeOfCrew + "\n" +
                ", cox=" + cox + "\n" +
                ", stroke=" + stroke + "\n" +
                ", type=" + type + "\n" +
                ", teamHandicap=" + teamHandicap +
                ". List of rowers= " + Arrays.toString(crew.toArray());
    }
}
