package be.intecbrussel.models.competition;


import be.intecbrussel.models.enums.Category;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Entity
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Un nom est requis")
    @Size(min=2, max=30)
    private String name;
    @NotNull(message = "Une information est requise")
    @Size(min=3, max=50)
    private String description;
    @NotNull(message = "Un lieu est requis")
    @Size(min=3, max=50)
    private String placeOfEvent;
    @NotNull(message = "Une date est requise")
    private LocalDate date;
    @NotNull(message = "Une information est requise")
    private String registrationRules;
    @NotNull(message = "Un contact est requis")
    private String RegistrationContact;
    @NotNull(message = "Un coût est requis")
    private BigDecimal registrationCost;
    @NotNull(message = "Une date d'inscription est requise")
    private LocalDate registrationLimit;
    @NotNull(message = "Une date est requise")
    private LocalDate lotteryDate;
    @NotNull(message = "Une information est requise")
    private String lotteryRules;
    @NotNull(message = "Un contact est requis")
    private String lotteryContact;
    @NotNull(message = "Une heure limite est requise")
    private String forfeitLimitHour;
    @NotNull(message = "Une date limite est requise")
    private LocalDate forfeitLimit;
    @NotNull(message = "Une information est requise")
    private String forfeitRules;
    @NotNull(message = "Un contact est requis")
    private String forfeitContact;
    @NotNull(message = "Une information est requise")
    private String complementaryRules;

    @OneToMany(mappedBy = "competition", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Compensation> compensationCategories;
    @OneToMany(mappedBy = "competition", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Race> races;





    public Competition() {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getRegistrationRules() {
        return registrationRules;
    }

    public void setRegistrationRules(String registrationRules) {
        this.registrationRules = registrationRules;
    }

    public String getRegistrationContact() {
        return RegistrationContact;
    }

    public void setRegistrationContact(String registrationContact) {
        RegistrationContact = registrationContact;
    }

    public BigDecimal getRegistrationCost() {
        return registrationCost;
    }

    public void setRegistrationCost(BigDecimal registrationCost) {
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

    public LocalDate getForfeitLimit() {
        return forfeitLimit;
    }

    public void setForfeitLimit(LocalDate forfeitLimit) {
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

    public LocalDate getRegistrationLimit() {
        return registrationLimit;
    }

    public void setRegistrationLimit(LocalDate registrationLimit) {
        this.registrationLimit = registrationLimit;
    }

    public LocalDate getLotteryDate() {
        return lotteryDate;
    }

    public void setLotteryDate(LocalDate lotteryDate) {
        this.lotteryDate = lotteryDate;
    }

    public List<Compensation> getCompensationCategories() {
        return compensationCategories;
    }

    public void setCompensationCategories(List<Compensation> compensationCategories) {
        this.compensationCategories = compensationCategories;
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
    public void addCompensation(Compensation compensation){
        compensationCategories.add(compensation);
        compensation.setCompetition(this);
    }
    public void removeCompensation(Compensation compensation){
        compensationCategories.remove(compensation);
        compensation.setCompetition(null);
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

}