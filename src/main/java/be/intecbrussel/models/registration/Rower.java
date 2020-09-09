package be.intecbrussel.models.registration;


import be.intecbrussel.models.competition.Competition;
import be.intecbrussel.models.enums.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Rower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Le prénom est requis")
    private String firstName;
    @NotNull(message = "Le nom est requis")
    private String lastName;
    @NotNull(message = "Le genre est requis")
    private Gender gender;
    private String nationality;
    @NotNull(message = "La date de naissance est requise")
    private LocalDate birthDate;
    private String club;
    private String licenceNumber;
    private Disability disability;
    private RaceExperience raceExperience;
    private Category category;

    private float categoryCoef;
    private float genderCoef;
    private int age;
    private float rowerHandicap;
    @ManyToOne
    private Team team;
    //Constructor///////////////////
    public Rower() {
    }
    //Getters and setters//////////
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public RaceExperience getRaceExperience() {
        return raceExperience;
    }

    public void setRaceExperience(RaceExperience raceExperience) {
        this.raceExperience = raceExperience;
    }

    public float getCategoryCoef() {
        return categoryCoef;
    }

    public void setCategoryCoef(float categoryCoef) {
        this.categoryCoef = categoryCoef;
    }

    public float getGenderCoef() {
        return genderCoef;
    }

    public void setGenderCoef(float genderCoef) {
        this.genderCoef = genderCoef;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    public void setCategory(Category category) {
        this.category = category;
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

    public float getRowerHandicap() {
        return rowerHandicap;
    }

    public void setRowerHandicap(float rowerHandicap) {
        this.rowerHandicap = rowerHandicap(this.categoryCoef,this.genderCoef);
    }
    //specific methods///////////////////////////////
    public int calculateAge(LocalDate birthDate){
        int actualYear = LocalDate.now().getYear();
        int birthYear = birthDate.getYear();
        return actualYear-birthYear;
    }
    public float rowerHandicap( float categoryCoef, float genderCoef){
        return this.categoryCoef*this.genderCoef;
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
        return (int) (31* getId());
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
