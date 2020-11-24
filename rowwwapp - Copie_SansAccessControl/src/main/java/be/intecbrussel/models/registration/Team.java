package be.intecbrussel.models.registration;



import be.intecbrussel.models.enums.Category;
import be.intecbrussel.models.enums.Disability;
import be.intecbrussel.models.enums.Position;
import be.intecbrussel.models.enums.RowingBoat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@Component
@Entity
@NamedQuery(name="Team.findByName",query="SELECT t FROM Team t WHERE t.name = ?1")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private RowingBoat type;
    private int sizeOfCrew;
    private String teamHandicap;

    @OneToMany(mappedBy = "team", cascade = CascadeType.MERGE, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Rower> crew;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Rower cox;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Rower stroke;


    //Constructor///////////////////
    @Autowired
    public Team() {
        crew=new ArrayList<>();
    }
    //Getters and setters//////////





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
    public void addCrewMember(Rower rower){
        this.crew.add(rower);
        rower.setTeam(this);
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

    public String getTeamHandicap() {
        return teamHandicap;
    }

    public void setTeamHandicap() {
        this.teamHandicap = String.valueOf(calculateTeamHandicap(this.crew));
    }
    //specific methods///////////////////////////////
    public double calculateTeamHandicap(List<Rower> crew){
        double eachRowerHandicap;
        List<Double> sumOfRowerHandicap = new ArrayList<>();
        double totalOfRowerHandicap = 0;
        for (Rower r: crew
        ) {
            eachRowerHandicap = r.getRowerHandicap();
            sumOfRowerHandicap.add(eachRowerHandicap);
        }
        Optional<Double> totalOfCrewHandicap = sumOfRowerHandicap.stream().reduce(Double::sum);
        if(totalOfCrewHandicap.isPresent()){
            totalOfRowerHandicap = totalOfCrewHandicap.get();
        }
        return totalOfRowerHandicap/sizeOfCrew;
    }
   public String getListCrewMembers(List<Rower> rowers){
        Map<Integer,String> crewNames = new TreeMap<>();
        String firstName;
        String lastName;
        String name;
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

    //Override methods////////////////////////////
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof Team)) return false;
        return id != null && id.equals(((Team)o).getId());
    }
    @Override
    public int hashCode() {
        return (int) (31* 11);
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
