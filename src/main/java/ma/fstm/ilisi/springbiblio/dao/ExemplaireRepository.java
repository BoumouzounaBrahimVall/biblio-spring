package ma.fstm.ilisi.springbiblio.dao;

import ma.fstm.ilisi.springbiblio.bo.Exemplaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExemplaireRepository extends JpaRepository<Exemplaire, Long> {
    @Query("SELECT e FROM Exemplaire e where e.livre.isbn = :isbn")
    List<Exemplaire> findByIsbn(@Param("isbn") String isbn);
    @Query("SELECT e FROM Exemplaire e JOIN e.emprunts m WHERE m.retourne=0 AND e.livre.isbn= :isbn")
    List<Exemplaire> findEmpruntedByIsbn(@Param("isbn") String isbn);
    @Query("SELECT e FROM Exemplaire e WHERE e NOT IN (SELECT em.exemplaire FROM Emprunt em )")
    List<Exemplaire> findFreeExemplaire( );
}