package ma.fstm.ilisi.springbiblio.bo;
import jakarta.persistence.*;
@Entity
@Table(name = "emprunt")
public class Emprunt {

    @EmbeddedId
    private EmpruntId empruntId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idExp")
    private Exemplaire exemplaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idAd")
    @JoinColumn(name = "idAd")
    private Adherent adherant;

    @Column(name = "dateEmp")
    private String dateEmp;

}
