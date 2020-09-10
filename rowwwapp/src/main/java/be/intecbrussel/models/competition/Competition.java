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
    private String description;
    @NotNull(message = "Un lieu est requis")
    @Size(min=3, max=50)
    private String placeOfEvent;
    @NotNull(message = "Une date est requise")
    private LocalDate date;
    private String registrationRules;
    private String RegistrationContact;
    @NotNull(message = "Un coût est requis")
    private BigDecimal registrationCost;
    private LocalDateTime registrationLimit;
    private LocalDateTime lotteryDate;
    private String lotteryRules;
    private String lotteryContact;
    private LocalDateTime forfeitLimit;
    private String forfeitRules;
    private String forfeitContact;
    private String complementaryRules;
    private Float compensationMale;
    private Float compensationFemale;
    @OneToMany
    private Map<Integer,Compensation> compensationCategories;
    @OneToMany
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


    public LocalDateTime getRegistrationLimit() {
        return registrationLimit;
    }

    public void setRegistrationLimit(LocalDateTime registrationLimit) {
        this.registrationLimit = registrationLimit;
    }

    public LocalDateTime getLotteryDate() {
        return lotteryDate;
    }

    public void setLotteryDate(LocalDateTime lotteryDate) {
        this.lotteryDate = lotteryDate;
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

    public LocalDateTime getForfeitLimit() {
        return forfeitLimit;
    }

    public void setForfeitLimit(LocalDateTime forfeitLimit) {
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

    public Map<Integer,Compensation> getCompensationCategories() {
        return compensationCategories;
    }

    public void setCompensationCategories(Map<Integer,Compensation> compensationCategories) {
        this.compensationCategories = compensationCategories;
    }

    public  Float getCompensationMale() {
        return compensationMale;
    }
    public  Float getCompensationFemale() {
        return compensationFemale;
    }

    public void setCompensationMale(Float compensation) {
        this.compensationMale = compensation;
    }
    public void setCompensationFemale(Float compensation) {
        this.compensationMale = compensation;
    }

    //specific methods///////////////////////////////
    public String listCompensationsCategories(Map<Integer,Compensation> compensationCategories){

        Compensation[] allCompensations = (Compensation[]) compensationCategories.values().stream().toArray();
        List<Float> allCoefficients = new ArrayList<>();
        for (Compensation c: allCompensations
             ) {
            allCoefficients.add(c.getCoefficient());
        }

        Integer[] allCategoriesOrdinals = (Integer[]) compensationCategories.keySet().toArray();
        List<String> allCategories = new ArrayList<>();
        List<Category> categories = Arrays.asList(Category.values());
        for (Integer f: allCategoriesOrdinals
             ) {
            for (Category c: categories
                 ) {
                if(f==c.ordinal()){
                    allCategories.add(c.name());
                }
            }
        }
        return Arrays.toString(allCategories.toArray())+"\n"+Arrays.toString(allCoefficients.toArray());
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
