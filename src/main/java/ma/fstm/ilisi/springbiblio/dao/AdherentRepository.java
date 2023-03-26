package ma.fstm.ilisi.springbiblio.dao;

import ma.fstm.ilisi.springbiblio.bo.Adherant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdherentRepository extends JpaRepository<Adherant,String> {
}
