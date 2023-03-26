package ma.fstm.ilisi.springbiblio.bo;

import jakarta.persistence.*;
@Entity
@Table(name="LIVRE")
public class Livre implements java.io.Serializable {

    public Livre(String isbn, String titre) {
        this.isbn = isbn;
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "isbn='" + isbn + '\'' +
                ", titre='" + titre + '\'' +
                '}';
    }

    private String isbn;
    private String titre;

    public Livre() {
    }


    public Livre(String isbn) {
        this.isbn = isbn;
    }

    @Id
    @Column(name="ISBN", unique=true, nullable=false, length=13)
    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    @Column(name="TITRE", length=100)
    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }



}

