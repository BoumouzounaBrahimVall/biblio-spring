package ma.fstm.ilisi.springbiblio.bo;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class EmpruntId  implements java.io.Serializable {


    private long idexmp;
    private String cin;
    private String dateemp;

    public EmpruntId() {
    }

    public EmpruntId(long idexmp, String cin, String dateemp) {
        this.idexmp = idexmp;
        this.cin = cin;
        this.dateemp = dateemp;
    }



    @Column(name="IDEXMP", nullable=false, precision=22, scale=0)
    public long getIdexmp() {
        return this.idexmp;
    }

    public void setIdexmp(long idexmp) {
        this.idexmp = idexmp;
    }


    @Column(name="CIN", nullable=false, length=50)
    public String getCin() {
        return this.cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }


    @Column(name="DATEEMP", nullable=false, length=50)
    public String getDateemp() {
        return this.dateemp;
    }

    public void setDateemp(String dateemp) {
        this.dateemp = dateemp;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int)this.idexmp;
        hash = 89 * hash + Objects.hashCode(this.cin);
        hash = 89 * hash + Objects.hashCode(this.dateemp);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmpruntId other = (EmpruntId) obj;
        if (this.idexmp != other.idexmp) {
            return false;
        }
        if (!Objects.equals(this.cin, other.cin)) {
            return false;
        }
        return Objects.equals(this.dateemp, other.dateemp);
    }

    @Override
    public String toString() {
        return  "idexmp='" + idexmp + "', cin='" + cin + "'" + ", dateemp='" + dateemp + "'";
    }
    public static EmpruntId parseString(String str){
        Pattern pattern = Pattern.compile("idexmp=\\s*'([\\d]+)'.*cin=\\s*'([A-Za-z0-9]+)'.*dateemp=\\s*'([\\d\\-]+)'");

        Matcher matcher = pattern.matcher(str);
        EmpruntId idEmp=new EmpruntId();
        if (matcher.find()) {
            String idexp = matcher.group(1);
            String cin = matcher.group(2);
            String date = matcher.group(3);
            idEmp.setIdexmp(Integer.parseInt(idexp));
            idEmp.setCin(cin);
            idEmp.setDateemp(date);
        } else {
            System.out.println(str);
            System.out.println("No match found.");
        }
        return idEmp;
    }
}