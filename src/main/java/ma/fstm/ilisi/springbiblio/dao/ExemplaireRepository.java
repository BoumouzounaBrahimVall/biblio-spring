package ma.fstm.ilisi.springbiblio.dao;

import ma.fstm.ilisi.springbiblio.bo.Exemplaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExemplaireRepository extends JpaRepository<Exemplaire, Long> {
}