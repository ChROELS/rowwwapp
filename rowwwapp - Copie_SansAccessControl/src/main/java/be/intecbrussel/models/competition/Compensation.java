package be.intecbrussel.models.competition;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
@Entity
public class Compensation {
    @Id
    @GeneratedValue
    Long id;

    private String compensationMale;

    private String compensationFemale;

    private String BEG;

    private String PR3;

    private String PR2;

    private String PR1;

    private String J10;

    private String J12;

    private String J14;

    private String J16;

    private String J18;

    private String U23;

    private String S_A;

    private String S_B;

    private String A;

    private String B;

    private String C;

    private String D;

    private String E;

    private String F;

    private String G;

    private String H;

    private String I;

    private String J;

    private String K;

    private  String L;

    private String M;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Competition competition;


    @Autowired
    public Compensation() {
        this.compensationMale = "00.00";
        this.compensationFemale = "00.00";
        this.BEG = "00.00";
        this.PR3 = "00.00";
        this.PR2 = "00.00";
        this.PR1 = "00.00";
        J10 = "00.00";
        J12 = "00.00";
        J14 = "00.00";
        J16 = "00.00";
        J18 = "00.00";
        U23 = "00.00";
        S_A = "00.00";
        S_B = "00.00";
        A = "00.00";
        B = "00.00";
        C = "00.00";
        D = "00.00";
        E = "00.00";
        F = "00.00";
        G = "00.00";
        H = "00.00";
        I = "00.00";
        J = "00.00";
        K = "00.00";
        L = "00.00";
        M = "00.00";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public String getCompensationMale() {
        return compensationMale;
    }

    public void setCompensationMale(String compensationMale) {
        this.compensationMale = compensationMale;
    }

    public String getCompensationFemale() {
        return compensationFemale;
    }

    public void setCompensationFemale(String compensationFemale) {
        this.compensationFemale = compensationFemale;
    }

    public String getBEG() {
        return BEG;
    }

    public void setBEG(String BEG) {
        this.BEG = BEG;
    }

    public String getPR3() {
        return PR3;
    }

    public void setPR3(String PR3) {
        this.PR3 = PR3;
    }

    public String getPR2() {
        return PR2;
    }

    public void setPR2(String PR2) {
        this.PR2 = PR2;
    }

    public String getPR1() {
        return PR1;
    }

    public void setPR1(String PR1) {
        this.PR1 = PR1;
    }

    public String getJ10() {
        return J10;
    }

    public void setJ10(String j10) {
        J10 = j10;
    }

    public String getJ12() {
        return J12;
    }

    public void setJ12(String j12) {
        J12 = j12;
    }

    public String getJ14() {
        return J14;
    }

    public void setJ14(String j14) {
        J14 = j14;
    }

    public String getJ16() {
        return J16;
    }

    public void setJ16(String j16) {
        J16 = j16;
    }

    public String getJ18() {
        return J18;
    }

    public void setJ18(String j18) {
        J18 = j18;
    }

    public String getU23() {
        return U23;
    }

    public void setU23(String u23) {
        U23 = u23;
    }

    public String getS_A() {
        return S_A;
    }

    public void setS_A(String s_A) {
        S_A = s_A;
    }

    public String getS_B() {
        return S_B;
    }

    public void setS_B(String s_B) {
        S_B = s_B;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getE() {
        return E;
    }

    public void setE(String e) {
        E = e;
    }

    public String getF() {
        return F;
    }

    public void setF(String f) {
        F = f;
    }

    public String getG() {
        return G;
    }

    public void setG(String g) {
        G = g;
    }

    public String getH() {
        return H;
    }

    public void setH(String h) {
        H = h;
    }

    public String getI() {
        return I;
    }

    public void setI(String i) {
        I = i;
    }

    public String getJ() {
        return J;
    }

    public void setJ(String j) {
        J = j;
    }

    public String getK() {
        return K;
    }

    public void setK(String k) {
        K = k;
    }

    public String getL() {
        return L;
    }

    public void setL(String l) {
        L = l;
    }

    public String getM() {
        return M;
    }

    public void setM(String m) {
        M = m;
    }


    //override methods///////////////////////////////
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof Compensation)) return false;
        return id != null && id.equals(((Compensation)o).getId());
    }
    @Override
    public int hashCode() {
        if(id != null)
        return (int) (31*id);
        return 31;
    }
}
