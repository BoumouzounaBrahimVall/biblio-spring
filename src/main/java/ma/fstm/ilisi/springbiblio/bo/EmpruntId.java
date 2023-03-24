package ma.fstm.ilisi.springbiblio.bo;
import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class EmpruntId implements Serializable {

    @Column(name = "idExp")
    private Long idExp;

    @Column(name = "idAd")
    private String idAd;

    @Column(name = "dateEmp")
    private String dateEmp;

    public EmpruntId() {
    }

    public EmpruntId(Long idExp, String idAd, String dateEmp) {
        this.idExp = idExp;
        this.idAd = idAd;
        this.dateEmp = dateEmp;
    }

    public Long getIdExp() {
        return idExp;
    }

    public void setIdExp(Long idExp) {
        this.idExp = idExp;
    }

    public String getIdAd() {
        return idAd;
    }

    public void setIdAd(String idAd) {
        this.idAd = idAd;
    }

    public String getDateEmp() {
        return dateEmp;
    }

    public void setDateEmp(String dateEmp) {
        this.dateEmp = dateEmp;
    }
}