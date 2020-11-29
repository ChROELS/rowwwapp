package be.intecbrussel.models.registration;



import be.intecbrussel.models.enums.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
import java.time.LocalDate;


@Component
@Entity
public class Rower extends Object {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String nationality;
    private Date birthDate;
    private String club;
    private String licenceNumber;
    private Disability disability;
    private RaceExperience raceExperience;
    private Position position;
    private int raceNumber;
    private String isLastRower;
    private String teamName;
    //fields calculated
    private String categoryCoef;
    private String genderCoef;
    private int age;
    private Category category;
    private Double rowerHandicap;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    private ScheduledRace race;
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    private Team team;

    //Constructor///////////////////
    @Autowired
    public Rower() {
    }

    //Getters and setters//////////


    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getIsLastRower() {
        return isLastRower;
    }

    public void setIsLastRower(String isLastRower) {
        this.isLastRower = isLastRower;
    }

    public int getRaceNumber() {
        return raceNumber;
    }

    public void setRaceNumber(int raceNumber) {
        this.raceNumber = Math.abs(raceNumber);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public RaceExperience getRaceExperience() {
        return raceExperience;
    }

    public void setRaceExperience(RaceExperience raceExperience) {
        this.raceExperience = raceExperience;
    }


    public String getCategoryCoef() {
        return categoryCoef;
    }

    public void setCategoryCoef(String value) {
        this.categoryCoef = value;
    }

    public String getGenderCoef() {
        return genderCoef;
    }

    public void setGenderCoef(String value) {
        this.genderCoef = value;
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        this.age = calculateAge(this.birthDate);
    }

    public Disability getDisability() {
        return disability;
    }

    public void setDisability(Disability disability) {
        this.disability = disability;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory() {
        if(this.disability!=Disability.Option_0) {
            this.category = Category.selectCategory(this.age);
        }else{
            this.category = Category.selectCategory(this.disability);
        }
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public ScheduledRace getRace() {
        return race;
    }

    public void setRace(ScheduledRace race) {
        this.race = race;
    }

    public Double getRowerHandicap() {
        return rowerHandicap;
    }

    public void setRowerHandicap() throws Exception {
        this.rowerHandicap = rowerHandicap(this.categoryCoef,
                this.genderCoef);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }



    //specific methods///////////////////////////////
    public double rowerHandicap(String categoryCoef, String genderCoef) {
        double categoryCoefNumber;
        double genderCoefNumber;
        try {
            categoryCoefNumber = Double.parseDouble(categoryCoef);
            genderCoefNumber = Double.parseDouble(genderCoef);
            return categoryCoefNumber * genderCoefNumber;
        }catch(Exception e){
            categoryCoefNumber = 0.00;
            genderCoefNumber = 0.00;
            return categoryCoefNumber * genderCoefNumber;
        }
    }
    public int calculateAge(Date birthDate){
        int actualYear = LocalDate.now().getYear();
        int birthYear = birthDate.toLocalDate().getYear();
        return actualYear-birthYear;
    }

    //Override methods////////////////////////////
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof Rower)) return false;
        return id != null && id.equals(((Rower)o).getId());
    }
    @Override
    public int hashCode() {
        return (int) (31);
    }

    @Override
    public String toString() {
        return "Rower " +
                "id=" + id +"\n"+
                ", lastName='" + lastName + '\'' +"\n"+
                ", firstName='" + firstName + '\'' +"\n"+
                ", nationality='" + nationality + '\'' +"\n"+
                ", gender=" + gender +"\n"+
                ", birthDate=" + birthDate +"\n"+
                ", disability=" + disability +"\n"+
                ", category=" + category +"\n"+
                ", club='" + club + '\'' +"\n"+
                ", licenceNumber='" + licenceNumber + '\'' +"\n"+
                ", rowerHandicap=" + rowerHandicap;
    }
}
