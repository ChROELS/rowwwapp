package be.intecbrussel.models.competition;




import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Compensation {
    @Id
    Long id;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String compensationMale;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String compensationFemale;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String BEG;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String PR3;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String PR2;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String PR1;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String J10;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String J12;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String J14;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String J16;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String J18;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String U23;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String S_A;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String S_B;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String A;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String B;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String C;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String D;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String E;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String F;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String G;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String H;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String I;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String J;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String K;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private  String L;
    @NotNull(message = "Une entrée (00.00 au moins) est requise")
    private String M;
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },fetch = FetchType.LAZY)
    Competition competition;

    public Compensation() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
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
        return (int) (31*id);
    }
}
