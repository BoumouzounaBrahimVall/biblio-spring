package ma.fstm.ilisi.springbiblio.bo;
import jakarta.persistence.*;
@Entity
@Table(name = "adherant")
public class Adherent {
    @Id
    @Column(name = "idAd")
    private String idAd;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    public Adherent(String idAd, String nom, String prenom) {
        this.idAd = idAd;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Adherent() {
    }

    public String getIdAd() {
        return idAd;
    }

    public void setIdAd(String idAd) {
        this.idAd = idAd;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}