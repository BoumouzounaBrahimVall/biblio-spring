package ma.fstm.ilisi.springbiblio.bo;
import jakarta.persistence.*;
@Entity
@Table(name="EMPRUNT")
public class Emprunt  implements java.io.Serializable {


    private EmpruntId id;
    private Exemplaire exemplaire;
    private Adherant adherant;
    private int retourne;

    public Emprunt() {
    }

    public Emprunt(EmpruntId id) {
        this.id = id;
    }

    public Emprunt(EmpruntId id, int retourne) {
        this.id = id;
        this.retourne = retourne;
    }


    public Emprunt(EmpruntId id, Exemplaire exemplaire, Adherant adherant) {
        this.id = id;
        this.exemplaire = exemplaire;
        this.adherant = adherant;
    }
    public Emprunt(EmpruntId id, Exemplaire exemplaire, Adherant adherant, int retourne) {
        this.id = id;
        this.exemplaire = exemplaire;
        this.adherant = adherant;
        this.retourne = retourne;
    }

    @EmbeddedId
    @AttributeOverrides( {
            @AttributeOverride(name="idexmp", column=@Column(name="IDEXMP", nullable=false, precision=22, scale=0) ),
            @AttributeOverride(name="cin", column=@Column(name="CIN", nullable=false, length=50) ),
            @AttributeOverride(name="dateemp", column=@Column(name="DATEEMP", nullable=false, length=50) ) } )
    public EmpruntId getId() {
        return this.id;
    }

    public void setId(EmpruntId id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IDEXMP", nullable=false, insertable=false, updatable=false)
    public Exemplaire getExemplaire() {
        return this.exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CIN", nullable=false, insertable=false, updatable=false)
    public Adherant getAdherant() {
        return this.adherant;
    }

    public void setAdherant(Adherant adherant) {
        this.adherant = adherant;
    }


    @Column(name="RETOURNE", precision=22, scale=0)
    public int getRetourne() {
        return this.retourne;
    }

    public void setRetourne(int retourne) {
        this.retourne = retourne;
    }




}



