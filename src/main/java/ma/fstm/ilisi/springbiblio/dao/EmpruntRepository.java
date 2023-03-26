package ma.fstm.ilisi.springbiblio.dao;

import ma.fstm.ilisi.springbiblio.bo.Emprunt;
import ma.fstm.ilisi.springbiblio.bo.EmpruntId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, EmpruntId> {
    @Query("SELECT em from Emprunt em join em.adherant ad where ad.idAd=:idAd")
    List<Emprunt> findbyAdherent(@Param("idAd") String idAd);
}