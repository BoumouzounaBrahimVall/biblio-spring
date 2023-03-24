package ma.fstm.ilisi.springbiblio.bo;

import jakarta.persistence.*;
@Entity
@Table(name = "livre")
public class Livre {

    @Id
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "titre")
    private String titre;

    public Livre(String isbn, String titre) {
        this.isbn = isbn;
        this.titre = titre;
    }

    public Livre() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}