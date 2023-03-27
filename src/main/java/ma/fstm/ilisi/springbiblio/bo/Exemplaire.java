package ma.fstm.ilisi.springbiblio.bo;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="EXEMPLAIRE")
public class Exemplaire  implements java.io.Serializable {



    private long idexp;
    private Livre livre;
    private Set<Emprunt> emprunts = new HashSet(0);

    public Exemplaire() {
    }


    public Exemplaire(long idexp) {
        this.idexp = idexp;
    }
    public Exemplaire(long idexp, Livre livre, Set emprunts) {
        this.idexp = idexp;
        this.livre = livre;
        this.emprunts = emprunts;
    }

    public Exemplaire(long idexp, Livre livre) {
        this.idexp = idexp;
        this.livre = livre;
    }
    public Exemplaire(Livre livre){
        this.livre=livre;
    }


    @Id
    @Column(name="IDEXP", unique=true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdexp() {
        return this.idexp;
    }

    public void setIdexp(long idexp) {
        this.idexp = idexp;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ISBN")
    public Livre getLivre() {
        return this.livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="exemplaire")
    public  Set<Emprunt> getEmprunts() {
        return this.emprunts;
    }

    public void setEmprunts( Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }




}


